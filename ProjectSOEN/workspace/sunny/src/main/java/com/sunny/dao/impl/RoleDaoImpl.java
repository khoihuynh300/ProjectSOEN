package com.sunny.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IRoleDao;
import com.sunny.model.Role;

@Repository
public class RoleDaoImpl implements IRoleDao {

	@Override
	public Role getRoleById(int roleid) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Role result = session.createNativeQuery("Select * from Role where RoleId=:roleid", Role.class)
					.setParameter("roleid", roleid).getSingleResult();
			t.commit();
			return result;
		}
	}

}
