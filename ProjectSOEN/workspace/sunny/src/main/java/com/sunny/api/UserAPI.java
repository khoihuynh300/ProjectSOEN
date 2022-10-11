package com.sunny.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.User;
import com.sunny.service.IUserService;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userservice;

	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {
		userservice.create(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		userservice.update(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@GetMapping("/user")
	public ResponseEntity<?> getAllUser() {
		List<User> result = userservice.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@DeleteMapping("/user")
	public void deleteUser(@RequestBody User user) {
		userservice.delete(user.getUserId());
	}

	@PostMapping("user/login")
	public boolean verifyerUser(@RequestBody User user) {
		return userservice.verifyerUser(user.getAccountName(), user.getPassword());
	}
}
