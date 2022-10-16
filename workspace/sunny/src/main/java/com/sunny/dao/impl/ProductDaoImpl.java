package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductDao;
import com.sunny.model.Product;


public class ProductDaoImpl implements IProductDao{

	@Override
	public Product AddProduct(Product product) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction transaction=session.beginTransaction()	;
			session.persist(product);
			transaction.commit();
			session.close();
			return product;
		}
	}

	@Override
	public void DeleteProduct(int Pid) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction=session.beginTransaction();
			
			Product product=new Product();
			product=session.get(Product.class, Pid);
			
			session.remove(product);
			transaction.commit();
			session.close();
		}
		
	}

	
	//save or update product
	@Override
	public void EditProduct(Product product) {
		// TODO Auto-generated method stub
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction =session.beginTransaction(); 
			
			session.saveOrUpdate(product);
			transaction.commit();
			session.close();
		}
		
	}

	@Override
	public Product FindProduct(int Pid) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction =session.beginTransaction();
			
			Product product =new Product();
			product=session.get(Product.class, Pid);
			transaction.commit();
			session.close();
			return product;
			
		}
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction transaction=session.beginTransaction();
			
			Query<Product> query= session.createQuery("From Product", Product.class	);
			List<Product> result = query.getResultList();
			transaction.commit();
			return result;
		}
	}

	@Override
	public List<Product> filterProductbyPtype(int Ptype) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction transaction=session.beginTransaction();
			
			String hql="From Product p where ptype= :Ptypeid";
			List<Product> result =session.createQuery(hql, Product.class).setParameter("Ptypeid", Ptype).getResultList();
			transaction.commit();
			return result;
		}
	}

}
