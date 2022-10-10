package com.sunny.service;

import java.util.List;

import com.sunny.model.User;


public interface IUserService {
	User create(User user);
	void update(User user);
	void delete(int id);
	List<User> findAll();
}
