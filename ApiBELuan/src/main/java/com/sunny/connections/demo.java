package com.sunny.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sunny.model.User;

public class demo {
//	public static void main(String[] args) {
//		StandardServiceRegistry ssr =
//				new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
//
//		SessionFactory factory=meta.getSessionFactoryBuilder().build();  
//		Session session=factory.openSession();  
//
//		Transaction t=session.beginTransaction();
//		
//		User user = new User();
//		user.setAccountName("aaaaaaaaa");
//		user.setPassword("123456");
//		user.setRole(0);
//		session.persist(user);
//		
//		t.commit();    
//		session.close();    
//		System.out.println("success");
//	}
}
