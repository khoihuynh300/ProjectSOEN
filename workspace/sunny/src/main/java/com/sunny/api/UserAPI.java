package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.User;
import com.sunny.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserAPI {

	UserServiceImpl userServiceImpl = new UserServiceImpl();

	@PostMapping("/create")
	@Transactional
	public User createUser(@RequestBody User user) {
		return userServiceImpl.createUser(user);
	}

	@DeleteMapping("/delete")
	@Transactional
	public void deleteUser(@RequestBody User user) {
		userServiceImpl.deleteUser(user);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getAllUser())
				: ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUserById(id.intValue()));
	}

	@PutMapping("/update")
	@Transactional
	public void updateUser(@RequestBody User user) {
		userServiceImpl.updateUser(user);
	}

}
