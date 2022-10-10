package com.sunny.dao;

import java.util.List;

import com.sunny.model.User;


public interface IUserDao {
	User create(User user);
	void update(User user);
	void delete(int id);
	List<User> findAll();
}
