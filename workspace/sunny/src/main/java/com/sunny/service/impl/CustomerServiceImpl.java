package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.CustomerDaoImpl;
import com.sunny.model.Customer;
import com.sunny.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDaoImpl.createCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDaoImpl.deleteCustomer(customer);

	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDaoImpl.updateCustomer(customer);

	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDaoImpl.getAllCustomers();
	}

	@Override
	public Customer getCustomerbyCusId(int Cid) {
		return customerDaoImpl.getCustomerbyCusId(Cid);
	}

}
