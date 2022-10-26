package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IUserDao;
import com.sunny.dao.impl.UserDaoImpl;
import com.sunny.model.User;
import com.sunny.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User createUser(User user) {
		return userDao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

}
