package com.sunny.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IDiscountDao;
import com.sunny.model.Discount;

public class DiscountDaoImpl implements IDiscountDao {

	@Override
	public Discount create(Discount discount) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(discount);
			t.commit();
			session.close();
			return discount;
		}
	}

}
