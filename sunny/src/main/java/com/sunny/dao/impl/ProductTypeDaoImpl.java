package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductTypeDao;
import com.sunny.model.ProductType;

public class ProductTypeDaoImpl implements IProductTypeDao {

	@Override
	public ProductType create(ProductType productType) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(productType);
			t.commit();
			session.close();
			return productType;
		}
	}

	@Override
	public List<ProductType> getAllProductType() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<ProductType> query = session.createQuery("From ProductType", ProductType.class);
			List<ProductType> result = query.getResultList();
			t.commit();
			return result;
		}
	}

}
