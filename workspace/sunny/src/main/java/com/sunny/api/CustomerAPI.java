package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Customer;
import com.sunny.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {
	private CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Customer create(@RequestBody Customer customer) {
		return customerServiceImpl.createCustomer(customer);
	}

	@PutMapping("/update")
	@Transactional
	public void update(@RequestBody Customer customer) {
		customerServiceImpl.updateCustomer(customer);
	}

	@DeleteMapping("/delete")
	@Transactional
	public void delete(@RequestBody Customer customer) {
		customerServiceImpl.deleteCustomer(customer);
	}

	@GetMapping("/get-all-customer")
	@Transactional
	public List<Customer> getAll() {
		return customerServiceImpl.getAllCustomers();
	}

	@GetMapping("/get-by-cusid")
	@Transactional
	public Customer getbyCusid(@RequestParam(required = true) int id) {
		return customerServiceImpl.getCustomerbyCusId(id);
	}
}