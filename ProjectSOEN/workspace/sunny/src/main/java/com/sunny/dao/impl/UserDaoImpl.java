package com.sunny.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IUserDao;
import com.sunny.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	@Transactional
	public User update(int userId, String password) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User user = findUser(userId);
//			String qryString = "update User u set u.Password=:newPassword where u.UserId=:id";
//			int query = session.createQuery(qryString).setString("newPassword", user.getPassword())
//					.setLong("id", user.getUserId()).executeUpdate();
			session.saveOrUpdate(user);
			user.setPassword(password);
			t.commit();
			return user;

		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User user = findUser(id);
			session.saveOrUpdate(user);
			user.setDeleted(true);
			t.commit();

		}

	}

	@Override
	public User findUser(int userId) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			User user = (User) session.get(User.class, userId);
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
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
			t.commit();
			session.close();
			return user;
		}
	}

	@Override
	public List<User> getAllUser() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<User> query = session.createQuery("From User");
			List<User> result = query.getResultList();
			return result;
		}
	}

	@Override
	public User findUserByAccountName(String accountName) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Transaction t = session.beginTransaction();
//			String hql = "FROM User where accountName = " + accountName;
//			Query query = session.createQuery(hql);
//			User results = (User) query.getSingleResult();
//			return results;
//		}
			Transaction t = session.beginTransaction();
			String hql = "FROM User where AccountName = :accountName";
			User user = session.createQuery(hql, User.class).setParameter("accountName", accountName).uniqueResult();
			return user;
		}
	}
}
