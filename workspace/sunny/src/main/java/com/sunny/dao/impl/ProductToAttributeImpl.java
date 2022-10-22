package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductToAttributeDao;
import com.sunny.model.ProductAttribute;
import com.sunny.model.ProductToAttribute;

public class ProductToAttributeImpl implements IProductToAttributeDao {

	@Override
	public ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();

			session.save(productToAttribute);
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

			session.delete(productToAttribute);
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

			session.update(productToAttribute);
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
			Query<ProductToAttribute> query = session.createQuery(hql, ProductToAttribute.class).setParameter("Pid",
					Pid);
			List<ProductToAttribute> productToAttributes = query.getResultList();
			transaction.commit();
			return productToAttributes;
		}
	}

	@Override
	public List<ProductToAttribute> addAllAttributeToProductbyPid(int Pid,
			List<ProductAttribute> listAllProductAttributes) {
		// TODO Auto-generated method stub
//		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
//			Transaction transaction=session.beginTransaction();
//			
//		}
		return null;
	}

	@Override
	public List<ProductToAttribute> editAllAttributeToProductbyPid(int Pid,
			List<ProductAttribute> listAllProductAttributes) {
		// TODO Auto-generated method stub
		return null;
	}

}