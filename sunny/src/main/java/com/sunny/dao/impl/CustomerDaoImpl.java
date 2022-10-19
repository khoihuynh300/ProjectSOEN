package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.ICustomerDao;
import com.sunny.model.Customer;

public class CustomerDaoImpl implements ICustomerDao{

	@Override
	public Customer createCustomer(Customer customer) {
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t =session.beginTransaction();
			
			session.save(customer);
			t.commit();
			session.close();
			return customer;
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t=session.beginTransaction();
			
			session.delete(customer);
			t.commit();
			session.close();
		}
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t=session.beginTransaction();
			
			session.update(customer);
			t.commit();
			session.close();
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t=session.beginTransaction();
			
			Query<Customer>query=session.createQuery("From Customer", Customer.class);
			List<Customer> customers=query.getResultList();
			t.commit();
			session.close();
			return customers;
		}
	}

	@Override
	public Customer getCustomerbyCusId(int Cid) {
		try(Session session=HibernateUtil.getSessionFactory().getCurrentSession()){
			Transaction t=session.beginTransaction();
			
			String hql ="From Customer Where EmpId= :Cid";
			
			Customer customer=session.createQuery(hql, Customer.class).setParameter("Cid", Cid).uniqueResult();
			t.commit();
			session.close();
			
			return customer;
		}
	}

}
