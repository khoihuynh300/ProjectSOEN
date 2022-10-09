package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sunny.dao.IUserDao;
import com.sunny.model.User;

public class UserDaoImpl implements IUserDao {

	

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User create(User user) {
		StandardServiceRegistry ssr =
				new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build();  
		Session session=factory.openSession();  

		Transaction t=session.beginTransaction();
		
//		User user1 = new User();
//		user1.setAccountName("KhoiHT");
//		user1.setPassword("123456");
//		user1.setRole(0);
		session.persist(user);
		
		t.commit();    
		session.close(); 
		
		return user;
	}
	
}
