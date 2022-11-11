package com.sunny.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IRoleDao;
import com.sunny.model.Role;

@Repository
public class RoleDaoImpl implements IRoleDao {
	public Role getRoleById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Role result = session.get(Role.class, id);
			session.close();
			return result;
		}
	}
}