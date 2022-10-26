package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Customer;
import com.sunny.service.ICustomerService;
import com.sunny.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {
	private ICustomerService customerService = new CustomerServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Customer create(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@PutMapping("/update")
	@Transactional
	public void update(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@DeleteMapping("/delete")
	@Transactional
	public void delete(@RequestBody Customer customer) {
		customerService.deleteCustomer(customer);
	}

//	@GetMapping("/get-all-customer")
//	@Transactional
//	public List<Customer> getAll() {
//		return customerService.getAllCustomers();
//	}
//
//	@GetMapping("/get-by-cusid")
//	@Transactional
//	public Customer getbyCusid(@RequestParam(required = true) int id) {
//		return customerService.getCustomerbyCusId(id);
//	}
	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers())
				: ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerbyCusId(id.intValue()));
	}
}