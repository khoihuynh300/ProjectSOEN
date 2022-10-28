package com.sunny.service;

import java.util.List;

import com.sunny.model.User;
import com.sunny.service.impl.Result;

public interface IUserService {
	Result createUser(User user); // C

	void updateUser(User user); // U

	void deleteUser(User user); // D

	List<User> getAllUser(); // R

	User getUserById(int id);
}
