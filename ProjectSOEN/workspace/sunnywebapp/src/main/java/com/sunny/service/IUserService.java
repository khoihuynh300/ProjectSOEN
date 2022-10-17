package com.sunny.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.User;

@Service
public interface IUserService {
	User create(User user) throws Exception;

	User update(User user);

	void delete(int id);

	List<User> findAll();
}
