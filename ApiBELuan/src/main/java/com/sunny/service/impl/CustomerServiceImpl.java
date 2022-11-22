package com.sunny.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sunny.dao.ICustomerDao;
import com.sunny.dao.impl.CustomerDaoImpl;
import com.sunny.model.Customer;
import com.sunny.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	private static final int PAGE_SIZE = 10;
	private ICustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public ResponseEntity<?> createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.OK).body(new Result(true, "Create customer successfully!!!"));
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
	public List<Customer> getAllCustomers(int pageNumber, int pageSize, int viewdeleted) {
		return customerDao.getAllCustomers(pageNumber, pageSize, viewdeleted);
	}

	@Override
	public Customer getCustomerbyCusId(int Cid) {
		return customerDao.getCustomerbyCusId(Cid);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return customerDao.count();
	}
	

	@Override
	public Customer getCustomerByUserId(int userId) {
		return customerDao.getCustomerByUserId(userId);
	}


}
