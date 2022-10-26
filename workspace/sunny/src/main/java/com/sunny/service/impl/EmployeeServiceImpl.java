package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IEmployeeDao;
import com.sunny.dao.impl.EmployeeDaoImpl;
import com.sunny.model.Employee;
import com.sunny.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeDao.createEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);

	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeebyEmpId(int EmpId) {
		return employeeDao.getEmployeebyEmpId(EmpId);
	}

}