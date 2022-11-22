package com.sunny.dao.impl;

import java.util.List;

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

	@Override
	public List<Role> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Role> result = session.createQuery("FROM Role", Role.class).getResultList();
			session.close();
			return result;
		}
	}
}
