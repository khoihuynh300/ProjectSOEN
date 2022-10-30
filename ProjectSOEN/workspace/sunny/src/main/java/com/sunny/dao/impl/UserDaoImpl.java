package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IUserDao;
import com.sunny.dao.IRoleDao;
import com.sunny.model.Role;
import com.sunny.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	IRoleDao roleDao;
	
	@Override
	public void update(String accountName, String password) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(4));
			Transaction t = session.beginTransaction();
			User user = findUserByAccountName(accountName);
			user.setPassword(hashPassword);
			session.saveOrUpdate(user);
			t.commit();
			session.close();
		}
	}

	@Override
	public void delete(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User user = findUser(id);
			session.saveOrUpdate(user);
			user.setDeleted(true);
			t.commit();
			session.close();

		}

	}

	@Override
	public User findUser(int userId) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			t.commit();
			return user;
		}
	}

	@Override
	public User create(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(user);
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
			user.setRoleId(roleDao.getRoleById(2));
			user.setEnable(false);
			String[] email = user.getEmail().split("@");
			user.setEmail(email[0]+ "+" + BCrypt.hashpw("", BCrypt.gensalt(4)) + "@" + email[1]);
			t.commit();
			session.close();
			return user;
		}
	}

	@Override
	public List<User> getAllUser(int pageNumber, int pageSize) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<User> query = session.createQuery("From User", User.class);
			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<User> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public User findUserByAccountName(String accountName) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			String hql = "FROM User where AccountName = :accountName";
			User user = session.createQuery(hql, User.class).setParameter("accountName", accountName).uniqueResult();
			t.commit();
			session.close();
			return user;
		}
	}

	@Override
	public List<User> findUserByEmail(String email) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			String[] result = email.split("@", 2);
			String hql = "select * from User where email like :email and email like :domain";
			List<User> user = session.createNativeQuery(hql, User.class).setParameter("email", result[0] + "+%" )
					.setParameter("domain", "%@" + result[1]).getResultList();
			t.commit();
			session.close();
			return user;
		}
	}

	@Override
	public void verifyer(String accountName) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User user = findUserByAccountName(accountName);
			user.setEnable(true);
			session.saveOrUpdate(user);
			t.commit();
			session.close();
		}
	}

	@Override
	public User save(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(user);
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(4)));
			user.setRoleId(roleDao.getRoleById(2));
			t.commit();
			session.close();
			return user;
		}
	}
}
