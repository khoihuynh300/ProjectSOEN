package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IPaymentMethodDao;
import com.sunny.model.PaymentMethod;

public class PaymentMethodDaoImpl implements IPaymentMethodDao {
	@Override
	public List<PaymentMethod> getAllPaymentMethod() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<PaymentMethod> query = session.createQuery("From PaymentMethod", PaymentMethod.class);
			List<PaymentMethod> result = query.getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public PaymentMethod getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			PaymentMethod result = (PaymentMethod) session.get(PaymentMethod.class, id);
			session.close();
			return result;
		}
	}
}
