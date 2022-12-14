package com.sunny.service;

import java.util.List;

import com.sunny.model.Employee;
import com.sunny.service.impl.Result;

public interface IEmployeeService {
	Result createEmployee(Employee employee);

	Result deleteEmployee(Employee employee);

	Result updateEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeebyEmpId(int EmpId);
	
	Employee getEmployeeByUserId(int userId);

	Employee getEmployeebyUserId(int intValue);

	boolean getorder(int shipperid, int orderid);

	void sendorder(Integer orderid) throws Exception;

	List<Employee> getAllEmployee(Integer pageNumber, int pageSize, int viewdeleted);
}
