package com.sunny.dao;

import java.util.List;

import com.sunny.model.Role;

public interface IRoleDao {
	Role getRoleById(int id);
	List<Role> getAll();
}