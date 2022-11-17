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
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.sunny.service.impl.Result;
import com.sunny.utils.GoogleUtils;
@CrossOrigin
@RestController
public class UserAPI {
	@Autowired
	private IUserService userservice;

	@PostMapping("/user/reset-password")
	public void resetPassword(@RequestBody User user, @RequestParam(defaultValue = "") Integer code) throws Exception {
		userservice.resetPassword(user, code);
	}
	
	//quên mk
	@PostMapping("/user/forget-password")
	public void forgetPassword(@RequestBody User user, HttpServletResponse response) throws Exception {
		userservice.sendEmailVerify(user);
		response.sendRedirect("/user/reset-password");
	}
	
	//xác thực
	@PutMapping("/user/register/verifyer")
	@Transactional
	public ResponseEntity<?> verifyerRegister(@RequestParam(defaultValue = "") Integer code, @RequestParam Integer userId, HttpSession session)
			throws Exception {
		//System.out.println(session.getAttribute("user") != null?((User) session.getAttribute("user")).getUserId():null);
		//System.out.println( );
		
		//if (session.getAttribute("user") != null) {
			//User userResp = (User) session.getAttribute("user");
			User userResp = userservice.getUserById(userId);
			if (userservice.verifyerRegister(userResp, code.intValue())) {
				return ResponseEntity.status(HttpStatus.OK).body(new Result(true, "xác thực thành công"));
			}
			//return userservice.verifyerRegister(userResp, code.intValue());
		//}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new Result(true, "xác thực không thành công"));
	}
	
	//đăng kí tài khoản mới
	@PostMapping("/user/register")
	@Transactional
	public ResponseEntity<?> createUser(@Validated @RequestBody User user, HttpServletResponse response, HttpSession session) throws Exception {
		User userResp = userservice.getUserByAccountName(user);
		if (userResp != null && userResp.isEnable() == false) {
			session.setAttribute("user", userResp);
			userservice.sendEmailVerify(user);
			//response.sendRedirect("/user/register/verifyer");
			return ResponseEntity.status(HttpStatus.FOUND).body(new Result(true, "tài khoản đã tồn tại nhưng chưa xác nhận"));
			
		} else if (userResp != null && userResp.isEnable() == true) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new Result(false, "tài khoản đã tồn tại"));
		} else {
			userResp = userservice.createUser(user);
			session.setAttribute("user", userResp);
			userservice.sendEmailVerify(user);
			//response.sendRedirect("/user/register/verifyer");
			return ResponseEntity.status(HttpStatus.OK).body(userResp);
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
		System.out.println(session.getAttribute("user") != null?((User) session.getAttribute("user")).getUserId():null);
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
	
	//đăng nhập
	@PostMapping("/login")
	@Transactional
	public ResponseEntity<?> verifyerUser(@RequestBody User user, HttpSession session, HttpServletResponse response)
			throws IOException {
		
		//kiểm tra tk mật khẩu có chính xác chưa
		User userResp = userservice.verifyerLogin(user.getAccountName(), user.getPassword());
		
		session.setAttribute("user", userResp);
		if (userResp == null || userResp.isDeleted() == true)
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new Result(false, "tài khoản hoặc mật khẩu không chính xác"));
		else {
			if (userservice.checkUserInfo(userResp))
				return ResponseEntity.status(HttpStatus.OK).body(userResp);
			else if(userResp.isEnable())
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Result(true, "tài khoản chưa nhập thông tin người dùng"));
			else 
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new Result(true, "tài khoản chưa được xác thực"));
		}
	}
	
	//đăng xuất
	@GetMapping("/logout")
	public void logOut(HttpSession session, HttpServletResponse response) throws IOException {
		session.getAttribute("user");
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect("/home");
	}
	
	//đăng nhập với gg
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
