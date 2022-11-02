package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductAttributeDao;
import com.sunny.model.ProductAttribute;

public class ProductAttributeDaoImpl implements IProductAttributeDao {

	@Override
	public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();

			session.save(productAttribute);
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

			Query<ProductAttribute> query = session.createQuery("From ProductAttribute", ProductAttribute.class);
			List<ProductAttribute> result = query.getResultList();

			transaction.commit();
			session.close();
			return result;

		}
	}

	@Override
	public void delete(int AtrId) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();

			Query query = session
					.createQuery("update ProductAttribute set isDeleted = :isDeleted" + " where atrId = :atrId");
			query.setParameter("isDeleted", true);
			query.setParameter("atrId", AtrId);
			query.executeUpdate();

			transaction.commit();
			session.close();
		}
	}

}
