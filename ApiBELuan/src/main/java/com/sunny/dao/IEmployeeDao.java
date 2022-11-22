package com.sunny.dao;

import java.util.List;

import com.sunny.model.Employee;
import com.sunny.model.Orders;

public interface IEmployeeDao {
	Employee createEmployee(Employee employee);

	void deleteEmployee(Employee employee);

	void updateEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeebyEmpId(int EmpId);
	
	Employee getEmployeeByUserId(int userid);

	Employee getEmployeebyUserId(int userId);

	List<Employee> getAllEmployee(Integer pageNumber, int pageSize, int viewdeleted);

	
}
