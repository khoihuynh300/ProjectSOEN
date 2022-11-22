package com.sunny.dao;

import java.util.List;

import com.sunny.model.User;

//@Component
public interface IUserDao {
	User create(User user);

	User save(User user);

	void update(String accountName, String password);
	
	void updateUser(User user);

	void delete(int id);
	
	void deleteUser(User user);
	
	User getUserById(int id);

	User findUser(int userId);

	User findUserByAccountName(String accountName);

	void verifyer(String accountName);

	List<User> findUserByEmail(String email);

	List<User> getAllUser(int pageNumber, int pageSize, int viewdeleted);
	
	boolean checkUserInfo(int userId);
	
	Long count(int viewdeleted, String table);
}
