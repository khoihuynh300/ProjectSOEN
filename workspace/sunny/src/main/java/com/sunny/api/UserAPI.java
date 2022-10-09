package com.sunny.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.User;
import com.sunny.service.impl.UserServiceImpl;

@RestController
public class UserAPI {
	
	@PostMapping("/User")
	public User createUser(@RequestBody User user) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		return userServiceImpl.create(user);
	}
}
