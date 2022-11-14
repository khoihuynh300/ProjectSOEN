package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.ICartDao;
import com.sunny.model.Cart;

@Repository
public class CartDaoImpl implements ICartDao {

	@Override
	public Cart create(Cart cart) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.getTransaction();
			session.save(cart);
			return cart;
		}
	}

	@Override
	public List<Cart> getAllCart() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Query<Cart> query = session.createQuery("From Cart", Cart.class);
			List<Cart> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public Cart getCartById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Cart.class, id);
		}
	}

	@Override
	public Cart getCartByCustomerId(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Cart result = session.createQuery("FROM Cart WHERE CusId.CusId = :CusId", Cart.class)
					.setParameter("CusId", id).getSingleResult();
			session.close();
			return result;
		}
	}
}
