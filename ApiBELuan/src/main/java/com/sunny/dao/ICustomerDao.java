package com.sunny.dao;

import java.util.List;

import com.sunny.model.Customer;

public interface ICustomerDao {
	Customer createCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	void updateCustomer(Customer customer);

	List<Customer> getAllCustomers(int pageNumber, int pageSize);

	Customer getCustomerbyCusId(int Cid);

	Long count();

	Customer getCustomerByUserId(int userId);

}
