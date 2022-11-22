package com.sunny.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sunny.model.Customer;
import com.sunny.service.impl.Result;

public interface ICustomerService {
	ResponseEntity<?> createCustomer(Customer customer);

	Result deleteCustomer(Customer customer);

	Result updateCustomer(Customer customer);

	List<Customer> getAllCustomers(int pageNumber, int pageSize,int viewdeleted);

	Customer getCustomerbyCusId(int Cid);

	Long count();

	Customer getCustomerByUserId(int intValue);

}
