package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IEmployeeDao;
import com.sunny.dao.IOrdersDao;
import com.sunny.dao.impl.EmployeeDaoImpl;
import com.sunny.dao.impl.OrdersDaoImpl;
import com.sunny.model.Employee;
import com.sunny.model.Orders;
import com.sunny.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao employeeDao = new EmployeeDaoImpl();
	private IOrdersDao ordersDao = new OrdersDaoImpl();

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
	

	@Override
	public Employee getEmployeebyUserId(int userId) {
		return employeeDao.getEmployeebyUserId(userId);
	}

	@Override
	public boolean getorder(int shipperid, int orderid) {
		Employee emp = employeeDao.getEmployeebyEmpId(shipperid);
		Orders order = ordersDao.getOrderById(orderid);
		if(order.getShipId() != null) {
			System.err.println(order.getShipId());
			return false;
		}
		order.setShipId(emp);
		order.setStatus(order.getStatus()+1);
		return ordersDao.getorder(order);
		
	}

	@Override
	public void sendorder(Integer orderid) throws Exception {
		Orders order = ordersDao.getOrderById(orderid);
		if(order.getStatus() == 3) {
			order.setStatus(4);
			ordersDao.getorder(order);
		}
		else {
			throw new Exception("Bạn không thể làm điều này");
		}
	}

	@Override
	public List<Employee> getAllEmployee(Integer pageNumber, int pageSize, int viewdeleted) {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee(pageNumber,pageSize, viewdeleted );
	}

}