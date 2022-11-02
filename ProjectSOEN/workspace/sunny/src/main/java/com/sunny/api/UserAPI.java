package com.sunny.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.http.client.ClientProtocolException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunny.model.GooglePojo;
import com.sunny.model.Product;
import com.sunny.model.User;
import com.sunny.service.IUserService;
import com.sunny.utils.GoogleUtils;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userservice;

	@PostMapping("/user/reset-password")
	public void resetPassword(@RequestBody User user, @RequestParam(defaultValue = "") Integer code) throws Exception {
		userservice.resetPassword(user, code);
	}

	@GetMapping("/user/reset-password")
	public void resetPasswordForm() throws Exception {
	}

	@GetMapping("/user/forget-password")
	public void forgetPasswordForm(HttpServletResponse response) throws Exception {
	}

	@PostMapping("/user/forget-password")
	public void forgetPassword(@RequestBody User user, HttpServletResponse response) throws Exception {
		userservice.sendEmailVerify(user);
		response.sendRedirect("/user/reset-password");
	}

	@PutMapping("/user/register/verifyer")
	@Transactional
	public boolean verifyerRegister(@RequestParam(defaultValue = "") Integer code, HttpSession session)
			throws Exception {
		if (session != null) {
			User userResp = (User) session.getAttribute("user");
			return userservice.verifyerRegister(userResp, code.intValue());
		}
		return false;
	}

	@GetMapping("/user/register/verifyer")
	@Transactional
	public void verifyerRegisterForm() throws Exception {
	}

	@PostMapping("/user/register")
	@Transactional
	public void createUser(@Validated @RequestBody User user, HttpServletResponse response, HttpSession session) throws Exception {
		User userResp = userservice.getUserByAccountName(user);
		if (userResp != null && userResp.isEnable() == false) {
			session.setAttribute("user", userResp);
			userservice.sendEmailVerify(user);
			response.sendRedirect("/user/register/verifyer");
		} else if (userResp != null && userResp.isEnable() == true) {
			throw new Exception("User exist!");
		} else {
			userResp = userservice.createUser(user);
			session.setAttribute("user", userResp);
			userservice.sendEmailVerify(user);
			response.sendRedirect("/user/register/verifyer");
		}

	}

	@PutMapping("/user")
	@Transactional
	public void updateUser(@RequestParam String newPassword, @RequestParam String oldPassword, HttpSession session) {
		if (session != null) {
			User user = (User) session.getAttribute("user");
			if (BCrypt.checkpw(oldPassword, user.getPassword()) == true) {
				user.setPassword(newPassword);
				userservice.updateUser(user);
			}
		}
	}

//	@GetMapping("/user")
//	@Transactional
//	public ResponseEntity<?> getAllUser() {
//		List<User> result = userservice.getAllUser();
//		return ResponseEntity.status(HttpStatus.OK).body(result);
//	}

	@GetMapping("/user/profile")
	@Transactional
	public ResponseEntity<?> getUser(HttpSession session) {
		User result = new User();
		if (session != null) {
			result = userservice.getUser((User) session.getAttribute("user"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@DeleteMapping("/user")
	@Transactional
	public void deleteUser(@RequestBody User user) {
		userservice.deleteUser(user);
	}

	@GetMapping("/login")
	public void loginForm() {

	}

	@PostMapping("/login")
	@Transactional
	public void verifyerUser(@RequestBody User user, HttpSession session, HttpServletResponse response)
			throws IOException {
		User userResp = userservice.verifyerLogin(user.getAccountName(), user.getPassword());
		session.setAttribute("user", userResp);
		if (userResp == null || userResp.isDeleted() == true)
			response.sendRedirect("/login");
		else {
			if (userservice.checkUserInfo(userResp))
				response.sendRedirect("/home");
			else
				//Sua lai trang cap nhat thong tin nguoi dung
				response.sendRedirect("/info");
		}
	}

	@GetMapping("/logout")
	public void logOut(HttpSession session, HttpServletResponse response) throws IOException {
		session.getAttribute("user");
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect("/home");
	}

	@GetMapping("/login-google")
	public void loginGoogle(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			response.sendRedirect("/login");
		} else {
			String accessToken = GoogleUtils.getToken(code);
			GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
			User userResp = userservice.createOrLogin(googlePojo);
			if (userResp == null)
				throw new Exception("Tài khoản đã tồn tại");
			else {
				session.setAttribute("user", userResp);
				if (userservice.checkUserInfo(userResp))
					response.sendRedirect("/home");
				else
					response.sendRedirect("/info");
			}
		}
	}
}
