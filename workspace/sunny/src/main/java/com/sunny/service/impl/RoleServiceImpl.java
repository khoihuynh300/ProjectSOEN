package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IRoleDao;
import com.sunny.dao.impl.RoleDaoImpl;
import com.sunny.model.Role;
import com.sunny.service.IRoleService;

public class RoleServiceImpl implements IRoleService {
	IRoleDao roleDao = new RoleDaoImpl();

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

}
