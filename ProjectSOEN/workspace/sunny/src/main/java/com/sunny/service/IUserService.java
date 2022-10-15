package com.sunny.service;

import java.util.List;

import com.sunny.model.GooglePojo;
import com.sunny.model.User;

//@Service
public interface IUserService {
	User create(User user) throws Exception;

	void createOrLogin(GooglePojo googlePojo);

	void update(User user);

	void resetPassword(User user, int code) throws Exception;

	void delete(int id);

	List<User> getAllUser();

	User verifyerLogin(String accountName, String password);

	boolean verifyerRegister(User user, int verifyerCode) throws Exception;

	void sendEmailVerify(User user) throws Exception;
}
