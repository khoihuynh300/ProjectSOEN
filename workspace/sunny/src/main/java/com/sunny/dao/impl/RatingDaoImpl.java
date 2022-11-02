package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IRatingDao;
import com.sunny.model.Product;
import com.sunny.model.Rating;
import com.sunny.model.User;

public class RatingDaoImpl implements IRatingDao {
	@Override
	public Rating createRating(Rating rating) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(rating);
			t.commit();
			session.close();
			return rating;
		}
	}

	@Override
	public List<Rating> getAllRating() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Rating> result = session.createQuery("FROM Rating", Rating.class).getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public void deleteRating(Rating rating) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.delete(rating);
			t.commit();
			session.close();
		}
	}

	@Override
	public List<Rating> getByProductId(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			List<Rating> result = session.createQuery("FROM Rating WHERE Pid = :Pid", Rating.class)
					.setParameter("Pid", product).getResultList();
			t.commit();
			session.close();
			return result;
		}
	}

	@Override
	public List<Rating> getByUserId(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			List<Rating> result = session.createQuery("FROM Rating WHERE UserId = :UserId", Rating.class)
					.setParameter("UserId", user).getResultList();
			t.commit();
			session.close();
			return result;
		}
	}

	@Override
	public Rating getRatingById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Rating result = session.get(Rating.class, id);
			session.close();
			return result;
		}
	}
}
