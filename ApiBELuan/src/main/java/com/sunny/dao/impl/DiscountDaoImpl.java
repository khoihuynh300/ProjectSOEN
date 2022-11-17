package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IDiscountDao;
import com.sunny.model.Discount;

public class DiscountDaoImpl implements IDiscountDao {

	@Override
	public Discount createDiscount(Discount discount) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(discount);
			t.commit();
			session.close();
			return discount;
		}
	}

	@Override
	public List<Discount> getAllDiscount() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<Discount> query = session.createQuery("From Discount", Discount.class);
			List<Discount> result = query.getResultList();
			t.commit();
			return result;
		}

	}

	@Override
	public void updateDiscount(Discount discount) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(discount);
			transaction.commit();
			session.close();
		}
	}

	@Override
	public void deleteDiscount(Discount discount) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Discount discountRes = getDiscountById(discount.getDiscountId());
			discountRes.setDeleted(true);
			session.update(discountRes);
			t.commit();
			session.close();
		}
	}

	@Override
	public Discount getDiscountById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Discount.class, id);
		}
	}

}
