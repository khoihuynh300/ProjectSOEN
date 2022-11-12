package com.sunny.service;

import java.util.List;

import com.sunny.model.Customer;
import com.sunny.service.impl.Result;

public interface ICustomerService {
	Result createCustomer(Customer customer);

	Result deleteCustomer(Customer customer);

	Result updateCustomer(Customer customer);

	List<Customer> getAllCustomers(int viewdeleted);

	Customer getCustomerbyCusId(int Cid);
}
