package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IUserDao;
import com.sunny.model.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public void updateUser(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			session.close();
		}
	}

	@Override
	public void deleteUser(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User userRes = getUserById(user.getUserId());
			userRes.setDeleted(true);
			session.update(userRes);
			t.commit();
			session.close();
		}
	}

	@Override
	public List<User> getAllUser() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<User> query = session.createQuery("From User", User.class);
			List<User> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public User createUser(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(user);
			t.commit();
			session.close();
			return user;
		}
	}

	@Override
	public User getUserById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(User.class, id);
		}
	}

}
