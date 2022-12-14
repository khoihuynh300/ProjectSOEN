package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductToAttributeDao;
import com.sunny.model.ProductAttribute;
import com.sunny.model.ProductToAttribute;

@Repository
public class ProductToAttributeDaoImpl implements IProductToAttributeDao {
	@Override
	public ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();

			session.persist(productToAttribute);
			transaction.commit();
			session.close();
			return productToAttribute;
		}
	}

	@Override
	public void deleteProductToAttribute(int id) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();

			ProductToAttribute productToAttribute = session.get(ProductToAttribute.class, id);

			session.remove(productToAttribute);
			transaction.commit();
			session.close();
		}
	}

	@Override
	public void editProductToAttribute(int AtrId) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();

			ProductToAttribute productToAttribute = session.get(ProductToAttribute.class, AtrId);

			session.saveOrUpdate(productToAttribute);
			transaction.commit();
			session.close();
		}

	}

	@Override
	public List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			String hql = "From ProductToAttribute Where pid= :Pid";
			org.hibernate.query.Query<ProductToAttribute> query = session.createQuery(hql, ProductToAttribute.class)
					.setParameter("Pid", Pid);
			List<ProductToAttribute> productToAttributes = query.getResultList();
			transaction.commit();
			return productToAttributes;

		}
	}

	@Override
	public ProductToAttribute getProductToAttributeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductToAttribute> addAllAttributeToProductbyPid(int Pid,
			List<ProductAttribute> listAllProductAttributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductToAttribute> editAllAttributeToProductbyPid(int Pid,
			List<ProductAttribute> listAllProductAttributes) {
		// TODO Auto-generated method stub
		return null;
	}
}
