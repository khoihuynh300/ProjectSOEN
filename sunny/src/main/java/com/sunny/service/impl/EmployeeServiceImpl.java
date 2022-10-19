package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.EmployeeDaoImpl;
import com.sunny.model.Employee;
import com.sunny.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeDaoImpl.createEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDaoImpl.deleteEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDaoImpl.updateEmployee(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDaoImpl.getAllEmployees();
	}

	@Override
	public Employee getEmployeebyEmpId(int EmpId) {
		return employeeDaoImpl.getEmployeebyEmpId(EmpId);
	}

}
