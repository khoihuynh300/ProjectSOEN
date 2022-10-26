package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.ICustomerDao;
import com.sunny.dao.impl.CustomerDaoImpl;
import com.sunny.model.Customer;
import com.sunny.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);

	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);

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
