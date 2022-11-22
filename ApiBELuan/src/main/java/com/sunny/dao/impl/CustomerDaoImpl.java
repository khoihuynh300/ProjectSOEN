package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.ICustomerDao;
import com.sunny.model.Cart;
import com.sunny.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Override
	public Customer createCustomer(Customer customer) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.persist(customer);
			Cart cart = new Cart();
			cart.setCusId(customer);
			session.persist(cart);
			t.commit();
			session.close();
			return customer;
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			userDaoImpl.deleteUser(customer.getUserId());
			t.commit();
			session.close();
		}

	}

	@Override
	public void updateCustomer(Customer customer) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			session.update(customer);
			t.commit();
			session.close();
		}

	}

	@Override
	public List<Customer> getAllCustomers(int pageNumber, int pageSize, int viewdeleted) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			Query<Customer> query = (viewdeleted == 0
					? session.createQuery("From Customer WHERE UserId.isDeleted = false", Customer.class)
					: session.createQuery("From Customer", Customer.class));
			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<Customer> customers = query.getResultList();
			t.commit();
			session.close();
			return customers;
		}
	}

	@Override
	public Customer getCustomerbyCusId(int Cid) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			String hql = "From Customer Where CusId = :Cid";

			Customer customer = session.createQuery(hql, Customer.class).setParameter("Cid", Cid).uniqueResult();
			t.commit();
			session.close();

			return customer;
		}
	}

	@Override
	public Long count() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("select count(*) FROM Customer");
			
			Long count = (Long)query.uniqueResult(); 
			t.commit();
			return count;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public Customer getCustomerByUserId(int userId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Customer> result = session.createQuery("FROM Customer WHERE UserId.UserId = :UserId", Customer.class)
					.setParameter("UserId", userId).getResultList();
			if (result.size() == 0)
				return null;
			session.close();
			return result.get(0);
		}
	}

}