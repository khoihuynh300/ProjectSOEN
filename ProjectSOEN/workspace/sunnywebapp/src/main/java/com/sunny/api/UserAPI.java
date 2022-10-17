package com.sunny.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
