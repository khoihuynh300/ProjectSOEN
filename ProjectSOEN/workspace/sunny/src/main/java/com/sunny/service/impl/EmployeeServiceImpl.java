package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IEmployeeDao;
import com.sunny.dao.impl.EmployeeDaoImpl;
import com.sunny.model.Employee;
import com.sunny.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public Result createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
		return new Result(true, "Create Employee successfully!!!");
	}

	@Override
	public Result deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
		return new Result(true, "Delete Employee successfully!!!");
	}

	@Override
	public Result updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		return new Result(true, "Update Employee successfully!!!");
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeebyEmpId(int EmpId) {
		return employeeDao.getEmployeebyEmpId(EmpId);
	}

	@Override
	public Employee getEmployeeByUserId(int userId) {
		return employeeDao.getEmployeeByUserId(userId);
	}

}