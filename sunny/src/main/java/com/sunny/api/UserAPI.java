package com.sunny.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.http.client.ClientProtocolException;
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

import com.sunny.model.GooglePojo;
import com.sunny.model.User;
import com.sunny.service.IUserService;
import com.sunny.utils.GoogleUtils;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userservice;

	@GetMapping("/user/forget-password")
	public String forgetPassword(@RequestBody User user) throws Exception {
		userservice.sendEmailVerify(user);
		return "redirect:/user/reset-password";
	}

	@PostMapping("/user/reset-password")
	public void resetPassword(@RequestBody User user, @RequestParam(defaultValue = "") Integer code) throws Exception {
		userservice.resetPassword(user, code);
	}

	@PutMapping("/user/register/verifyer")
	@Transactional
	public boolean verifyerRegister(@RequestBody User user, @RequestParam(defaultValue = "") Integer code)
			throws Exception {
		return userservice.verifyerRegister(user, code.intValue());
	}

	@PostMapping("/user/register")
	@Transactional
	public String createUser(@Validated @RequestBody User user) throws Exception {
		userservice.sendEmailVerify(user);

		userservice.create(user);
		return "redirect:/user/register/verifyer";

	}

	@PutMapping("/user")
	@Transactional
	public void updateUser(@RequestBody User user, @RequestParam String newPassword) {
		userservice.update(user, newPassword);
	}

	@GetMapping("/user")
	@Transactional
	public ResponseEntity<?> getAllUser() {
		List<User> result = userservice.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@DeleteMapping("/user")
	@Transactional
	public void deleteUser(@RequestBody User user) {
		userservice.delete(user.getUserId());
	}

	@PostMapping("user/login")
	@Transactional
	public User verifyerUser(@RequestBody User user) {
		return userservice.verifyerLogin(user.getAccountName(), user.getPassword());
	}

	@GetMapping("/login-google")
	public String loginGoogle(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ClientProtocolException {
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			return "redirect:/login";
		} else {
			String accessToken = GoogleUtils.getToken(code);
			GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);

			userservice.createOrLogin(googlePojo);
			return "redirect:/user";

		}
	}
}
