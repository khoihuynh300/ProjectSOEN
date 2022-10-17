package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IUserDao;
import com.sunny.model.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			String qryString = "update User u set u.Password=:newPassword where u.UserId=:id";
			int query = session.createQuery(qryString).setString("newPassword", user.getPassword())
					.setLong("id", user.getUserId()).executeUpdate();
			session.save(user);
			t.commit();
			return user;

		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUser(User user) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Query<User> query = session.createQuery("from User where UserId =" + user.getAccountName());
			List<User> r = query.list();
			if (r.isEmpty())
				return null;
			return user;
		}
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User create(User user) {
//		StandardServiceRegistry ssr =
//				new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
//
//		SessionFactory factory=meta.getSessionFactoryBuilder().build(); 
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
//		Session session=factory.openSession();  

			Transaction t = session.beginTransaction();

//			User user1 = new User();
//			user1.setAccountName("KhoiHT");
//			user1.setPassword("123456");
//			user1.setRole(0);
			session.persist(user);

			t.commit();
			session.close();
			return user;
		}
	}
}
