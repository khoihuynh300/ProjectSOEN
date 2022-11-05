package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.ICustomerDao;
import com.sunny.dao.impl.CustomerDaoImpl;
import com.sunny.model.Customer;
import com.sunny.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public Result createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
		return new Result(true, "Create Customer successfully!!!");
	}

	@Override
	public Result deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		return new Result(true, "Delete Customer successfully!!!");
	}

	@Override
	public Result updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		return new Result(true, "Update Customer successfully!!!");
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomerbyCusId(int Cid) {
		return customerDao.getCustomerbyCusId(Cid);
	}

}
