package com.sunny.service;

import java.util.List;

import com.sunny.model.GooglePojo;
import com.sunny.model.User;

//@Service
public interface IUserService {
	User createUser(User user) throws Exception;

	User getUserById(int id);

	User createOrLogin(GooglePojo googlePojo) throws Exception;

	User getUser(User user);
	
	User getUserByAccountName(User user);

	boolean checkUserInfo(User user);
	
	void updateUser(User user);
	
	void updateUser(User user, String newPassword);

	void resetPassword(User user, int code) throws Exception;

	void deleteUser(User user);

	List<User> getAllUser(int pageNumber, int pageSize);

	User verifyerLogin(String accountName, String password);

	boolean verifyerRegister(User user, int verifyerCode) throws Exception;
	
	int checkRoles(User user);

	void sendEmailVerify(User user) throws Exception;
	Long count();
}
