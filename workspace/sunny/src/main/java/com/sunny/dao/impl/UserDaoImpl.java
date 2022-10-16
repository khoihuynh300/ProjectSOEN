package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IUserDao;
import com.sunny.model.Cart;
import com.sunny.model.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User user = getUserById(id);
			user.setDeleted(true);
			session.saveOrUpdate(user);
			t.commit();
			session.close();
		}
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User create(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(user);
			t.commit();
			session.close();

			// Tạo cart cho user
			Cart cart = new Cart();
			cart.setUserId(user);
			CartDaoImpl cartDaoImpl = new CartDaoImpl();
			cartDaoImpl.create(cart);
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
