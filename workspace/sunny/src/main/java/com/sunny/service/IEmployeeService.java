package com.sunny.service;

import java.util.List;

import com.sunny.model.Employee;

public interface IEmployeeService {
	Employee createEmployee(Employee employee);

	void deleteEmployee(Employee employee);

	void updateEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeebyEmpId(int EmpId);
}
