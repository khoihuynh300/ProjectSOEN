package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.UserDaoImpl;
import com.sunny.model.User;
import com.sunny.service.IUserService;

public class UserServiceImpl implements IUserService {

	UserDaoImpl userDaoImpl = new UserDaoImpl();

	@Override
	public User createUser(User user) {
		return userDaoImpl.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDaoImpl.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.deleteUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDaoImpl.getAllUser();
	}

	@Override
	public User getUserById(int id) {
		return userDaoImpl.getUserById(id);
	}

}
