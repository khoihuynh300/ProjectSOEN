package com.sunny.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IRoleDao;
import com.sunny.dao.IUserDao;
import com.sunny.model.Customer;
import com.sunny.model.Employee;
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
			User user = getUserById(id);
			session.saveOrUpdate(user);
			user.setDeleted(true);
			t.commit();
			session.close();

		}

	}
	
	@Override
	public void deleteUser(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User userRes = getUserById(user.getUserId());
			userRes.setDeleted(true);
			session.update(userRes);
			t.commit();
			session.close();
		}
	}
	
	@Override
	public User getUserById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(User.class, id);
		}
	}

	@Override
	public User findUser(int userId) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			TypedQuery<User> query = session.createQuery(
					"Select NEW com.sunny.model.User(u.UserId, u.AccountName, u.email, u.Phone, u.RoleId, u.isDeleted, u.enable) From User u where u.UserId = :userId",
					User.class).setParameter("userId", userId);
			User user = (User) query.getSingleResult();
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
			if(user.getRoleId() == null) {
				user.setRoleId(roleDao.getRoleById(2));				
				user.setEnable(false);
			}
			
			String[] email = user.getEmail().split("@");
			user.setEmail(user.getEmail());
			t.commit();
			session.close();
			return user;
		}
	}

	@Override
	public List<User> getAllUser(int pageNumber, int pageSize, int viewdeleted) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			//Query<User> query = session.createQuery("FROM User", User.class);
			Query<User> query = (viewdeleted == 0
					? session.createQuery("From User WHERE UserId.isDeleted = false", User.class)
					: session.createQuery("From User", User.class));
			if(pageNumber > 0) {
				query.setFirstResult((pageNumber - 1) * pageSize);
				query.setMaxResults(pageSize);
				
			}
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
			List<User> user = session.createNativeQuery(hql, User.class).setParameter("email", result[0] + "+%")
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

	@Override
	public boolean checkUserInfo(int userId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			User user = findUser(userId);
			Customer customer = null;
			Employee employee = null;
			if (user.getRoleId().getRoleId() == 2) {
				try {
					customer = session
							.createNativeQuery("Select * from customer where UserId = :userId", Customer.class)
							.setParameter("userId", userId).getSingleResult();
				} catch (Exception e) {
				}
				if (customer == null)
					return false;
				return true;
			} else if (user.getRoleId().getRoleId() == 3) {
				try {
					employee = session.createNativeQuery(
							"Select * from User, Employee where User.UserId = Employee.UserId and User.UserId = :userId",
							Employee.class).setParameter("userId", userId).getSingleResult();
				} catch (Exception e) {
				}
				if (employee == null)
					return false;
				return true;
			}
			t.commit();
			return true;
		}
	}

	@Override
	public void updateUser(User user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			session.close();
		}
	}

	@Override
	public Long count(int viewdeleted, String table) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query query;
			if(viewdeleted == 1) {
				query = session.createQuery("select count(*) FROM " + table);

			}else {
				
				query = session.createQuery("select count(*) FROM " +table+ " WHERE UserId.isDeleted = false");
			}
			
			Long count = (Long)query.uniqueResult(); 
			t.commit();
			return count;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	
}
