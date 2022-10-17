package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductAttributeDao;
import com.sunny.model.ProductAttribute;

@Repository
public class ProductAttributeDaoImpl implements IProductAttributeDao {
	@Override
	public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();

			session.persist(productAttribute);
			transaction.commit();
			session.close();
			return productAttribute;
		}

	}

	@Override
	public List<ProductAttribute> getAllProductAttributes() {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();

			org.hibernate.query.Query<ProductAttribute> query = session.createQuery("From ProductAttribute",
					ProductAttribute.class);
			List<ProductAttribute> result = query.getResultList();

			transaction.commit();
			return result;

		}
	}

	@Override
	public void delete(int AtrId) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();

			ProductAttribute productAttribute = session.get(ProductAttribute.class, AtrId);

			session.remove(productAttribute);

			transaction.commit();
			session.close();
		}
	}
}
