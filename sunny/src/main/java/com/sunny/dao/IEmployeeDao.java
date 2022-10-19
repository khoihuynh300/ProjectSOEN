package com.sunny.dao;

import java.util.List;


import com.sunny.model.Employee;

public interface IEmployeeDao {
	Employee createEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	void updateEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeebyEmpId(int EmpId);
}
