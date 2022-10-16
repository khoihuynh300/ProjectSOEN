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
	public ProductType AddProductType(ProductType productType) {
		// TODO Auto-generated method stub
		try (Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction transaction=session.beginTransaction();
			session.persist(productType);
			transaction.commit();
			session.close();
			return productType;
		}
	
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction=session.beginTransaction()	;
			ProductType productType=new ProductType();
			productType=session.get(ProductType.class	, id);
			if(productType!= null) {
				session.remove(productType);
				
			}
			transaction.commit();
		}
	}

	@Override
	public List<ProductType> getAllProductTypes() {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction transaction=session.beginTransaction();
			
			Query<ProductType> query=session.createQuery("From ProductType", ProductType.class);
			List<ProductType> result =query.getResultList();
			transaction.commit();
			return result;
		}
		
	}

}
