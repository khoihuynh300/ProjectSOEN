package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.UserDaoImpl;
import com.sunny.model.User;
import com.sunny.service.IUserService;

public class UserServiceImpl implements  IUserService {

	
	@Override
	public User create(User user) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		return  userDaoImpl.create(user);
	}

	@Override
	public void update(User catery) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
