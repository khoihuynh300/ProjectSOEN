package com.sunny.service.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunny.dao.IUserDao;
import com.sunny.dao.impl.UserDaoImpl;
import com.sunny.model.User;
import com.sunny.service.IUserService;

@Component
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao userdao;

	@Override
	public User create(User user) throws Exception {
		userdao = new UserDaoImpl();
		if (checkAccountName(user))
			return userdao.create(user);
		else
			throw new Exception("User exist !!");
	}

	private boolean checkAccountName(User user) {
		return true;
//		return userdao.findUser(user) != null ? true : false;
	}

	@Override
	public User update(User user) {
		userdao = new UserDaoImpl();
		return userdao.update(user.getUserId(), user.getPassword());

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userdao = new UserDaoImpl();
		userdao.delete(id);
	}

	@Override
	public List<User> getAllUser() {
		return userdao.getAllUser();
	}

	@Override
	public boolean verifyerUser(String accountName, String password) {
		User user = userdao.findUserByAccountName(accountName);
		if (user != null) {
			return BCrypt.checkpw(password, user.getPassword());
		}
		return false;
	}

}
