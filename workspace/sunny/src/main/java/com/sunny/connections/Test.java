package com.sunny.connections;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sunny.model.Product;
import com.sunny.model.ProductType;
import com.sunny.model.User;

public class Test {
	
	public static void main(String[] args) {
		
		
		int Ptype=9;
		
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction transaction=session.beginTransaction();
			
			String hql="From Product p where ptype= :Ptypeid";
			List<Product> result =session.createQuery(hql, Product.class).setParameter("Ptypeid", Ptype).getResultList();
			transaction.commit();
		}
	}
}
