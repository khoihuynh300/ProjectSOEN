package com.sunny.service;

import java.util.List;

import com.sunny.model.User;

//@Service
public interface IUserService {
	User create(User user) throws Exception;

	void update(User user);

	void delete(int id);

	List<User> getAllUser();

	boolean verifyerUser(String accountName, String password);

	void verifyerRegister(User user, int verifyerCode);

	void sendEmailVerify(User user) throws Exception;
}
