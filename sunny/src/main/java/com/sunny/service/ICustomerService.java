package com.sunny.service;

import java.util.List;

import com.sunny.model.Customer;

public interface ICustomerService {
	
	Customer createCustomer(Customer customer);
	
	void deleteCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerbyCusId(int Cid);

}
