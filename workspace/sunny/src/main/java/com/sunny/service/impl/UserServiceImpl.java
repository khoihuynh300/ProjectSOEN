package com.sunny.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import com.sunny.dao.IUserDao;
import com.sunny.dao.impl.UserDaoImpl;
import com.sunny.model.User;
import com.sunny.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();

	@Override
	public Result createUser(User user) {
		user.setAccountName(user.getAccountName().trim());
		if (user.getAccountName().length() == 0) {
			return new Result(false, "Tài khoản không được bỏ trống!");
		}
		if (userDao.existAccountName(user.getAccountName())) {
			return new Result(false, "Tài khoản đã tổn tại!");
		}
		user.setPassword(user.getPassword().trim());
		if (user.getPassword().length() == 0) {
			return new Result(false, "Mật khẩu không được bỏ trống!");
		}
		if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
				user.getPassword())) {
			return new Result(false,
					"Mật khẩu hợp lệ phải:\n+Có ít nhất 8 ký tự\n+Có ít nhất 1 chữ thường\n+Có ít nhất 1 chữ hoa\n+Có ít nhất 1 chữ số\n+Có ít nhất 1 ký tự đặc biệt.");
		}
		userDao.createUser(user);
		return new Result(true, "Tạo tài khoản thành công!");
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
