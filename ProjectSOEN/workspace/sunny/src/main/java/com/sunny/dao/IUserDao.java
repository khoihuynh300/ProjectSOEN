package com.sunny.dao;

import java.util.List;

import com.sunny.model.User;

//@Component
public interface IUserDao {
	User create(User user);

	User save(User user);

	void update(String accountName, String password);

	void delete(int id);

	User findUser(int userId);

	User findUserByAccountName(String accountName);

	void verifyer(String accountName);

	User findUserByEmail(String email);

	List<User> getAllUser();

}
