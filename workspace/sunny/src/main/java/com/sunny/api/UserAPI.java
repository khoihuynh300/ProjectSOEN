package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.User;
import com.sunny.service.impl.UserServiceImpl;

@RestController
public class UserAPI {

	@PostMapping("/user")
	@Transactional
	public User createUser(@RequestBody User user) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		return userServiceImpl.create(user);
	}

	@DeleteMapping("/user/delete")
	@Transactional
	public void deleteUser(@RequestBody User user) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.delete(user.getUserId());
	}
}
