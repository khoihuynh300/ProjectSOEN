package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IEmployeeDao;
import com.sunny.model.Employee;

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

}