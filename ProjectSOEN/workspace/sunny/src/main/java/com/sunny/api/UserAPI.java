package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

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

import com.sunny.model.User;
import com.sunny.service.IUserService;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userservice;

	@PutMapping("/user/register/verifyer")
	@Transactional
	public void verifyerRegister(@RequestBody User user, @RequestParam(defaultValue = "") Integer code) {
		userservice.verifyerRegister(user, code.intValue());
	}

	@PostMapping("/user/register")
	@Transactional
	public String createUser(@Validated @RequestBody User user) throws Exception {
		userservice.sendEmailVerify(user);

		userservice.create(user);
		return "redirect:/user/register/verifyer";

		// return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PutMapping("/user")
	@Transactional
	public void updateUser(@RequestBody User user) {
		userservice.update(user);
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
	public boolean verifyerUser(@RequestBody User user) {
		return userservice.verifyerUser(user.getAccountName(), user.getPassword());
	}
}
