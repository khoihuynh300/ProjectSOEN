package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductDao;
import com.sunny.model.Product;

public class ProductDaoImpl implements IProductDao {

	@Override
	public Product create(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(product);
			t.commit();
			session.close();
			return product;
		}
	}

	@Override
	public List<Product> getAllProduct() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<Product> query = session.createQuery("From Product", Product.class);
			List<Product> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public Product getProductById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Product product = (Product) session.get(Product.class, id);
			t.commit();
			return product;
		}
	}
}
