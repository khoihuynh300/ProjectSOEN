package com.sunny.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductDao;
import com.sunny.model.Product;

@Repository
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

	@Override
	public List<Product> searchProductWithPtypeAndName(String name, Integer ptype) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			List<Product> result = new ArrayList<>();
			if (name == null) {
				Query<Product> query = session
						.createNativeQuery("Select * from Product where Ptype =:ptype", Product.class)
						.setParameter("ptype", ptype.intValue());
				result = query.getResultList();
			} else if (ptype == null) {
				Query<Product> query = session
						.createNativeQuery("Select * From Product where Pname like :name", Product.class)
						.setParameter("name", "%" + name + "%");
				result = query.getResultList();
			} else {
				Query<Product> query = session
						.createNativeQuery("Select * from Product where Ptype =:ptype and Pname like :name",
								Product.class)
						.setParameter("ptype", ptype.intValue()).setParameter("name", "%" + name + "%");
				result = query.getResultList();
			}
			t.commit();
			return result;
		}

	}
}
