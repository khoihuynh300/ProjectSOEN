package com.sunny.dao;

import java.util.List;

import com.sunny.model.User;

//@Component
public interface IUserDao {
	User create(User user);

	User update(int UserId, String password);

	void delete(int id);

	List<User> findAll();

	User findUser(int userId);

	User findUserByAccountName(String accountName);

	List<User> getAllUser();

}
