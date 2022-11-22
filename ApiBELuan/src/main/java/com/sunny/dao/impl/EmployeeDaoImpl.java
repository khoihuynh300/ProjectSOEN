package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IEmployeeDao;
import com.sunny.model.Customer;
import com.sunny.model.Employee;
import com.sunny.model.Orders;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public Employee createEmployee(Employee employee) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			session.save(employee);
			t.commit();
			session.close();
			return employee;
		}
	}

	@Override
	public void deleteEmployee(Employee employee) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			userDaoImpl.deleteUser(employee.getUserId());
			t.commit();
			session.close();
		}

	}

	@Override
	public void updateEmployee(Employee employee) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			session.update(employee);
			t.commit();
			session.close();
		}

	}

	@Override
	public List<Employee> getAllEmployees() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			Query<Employee> query = session.createQuery("From Employee", Employee.class);
			List<Employee> employees = query.getResultList();
			t.commit();
			session.close();
			return employees;
		}
	}

	@Override
	public Employee getEmployeebyEmpId(int EmpId) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			String hql = "From Employee Where EmpId.EmpId= :Empid";

			Employee employee = session.createQuery(hql, Employee.class).setParameter("Empid", EmpId).uniqueResult();
			t.commit();
			session.close();

			return employee;
		}
	}

	@Override
	public Employee getEmployeeByUserId(int userid) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			String hql = "From Employee e Where UserId.UserId = :userid";

			Employee employee = session.createQuery(hql, Employee.class).setParameter("userid", userid).uniqueResult();
			t.commit();
			session.close();

			return employee;
		}
	}
	
	@Override
	public Employee getEmployeebyUserId(int userId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Employee> result = session.createQuery("FROM Employee WHERE UserId.UserId = :UserId", Employee.class)
					.setParameter("UserId", userId).getResultList();
			if (result.size() == 0)
				return null;
			session.close();
			return result.get(0);
		}
	}

	@Override
	public List<Employee> getAllEmployee(Integer pageNumber, int pageSize, int viewdeleted) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			Query<Employee> query = (viewdeleted == 0
					? session.createQuery("From Employee WHERE UserId.isDeleted = false", Employee.class)
					: session.createQuery("From Employee", Employee.class));
			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
			List<Employee> customers = query.getResultList();
			t.commit();
			session.close();
			return customers;
		}
	}

	


}