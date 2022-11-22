package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerAPI {
	private static final int PAGE_SIZE = 10;
	private ICustomerService customerService = new CustomerServiceImpl();

	@PostMapping("/create")
	@Transactional
	public ResponseEntity<?> create(@RequestBody Customer customer) {
		System.err.println(customer.getDateofBirth());
		return customerService.createCustomer(customer);
	}

	@PutMapping("/update")
	@Transactional
	public Result update(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/delete")
	@Transactional
	public Result delete(@RequestBody Customer customer) {
		return customerService.deleteCustomer(customerService.getCustomerbyCusId(customer.getCusId()));
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
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id, 
			@RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(required = false) Integer viewdeleted,
			@RequestParam(required = false) String Field,
			@RequestParam(required = false) String string,
			@RequestParam(required = false) Integer value,
			@RequestParam(required = false) String sd,
			@RequestParam(required = false) String ed) {
		
		if (viewdeleted == null)
			viewdeleted = 0;
		if (viewdeleted != 0 && viewdeleted != 1) {
			throw new IllegalArgumentException("delted should be null or 1 or 0");
		}
		
		return id == null
				? ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers(pageNumber,PAGE_SIZE,viewdeleted.intValue()))
				: ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerbyCusId(id.intValue()));
	}
	
	@GetMapping("/count")
	@Transactional
	public ResponseEntity<?> count() throws Exception {	
		return ResponseEntity.status(HttpStatus.OK).body(customerService.count());
	}
	
	@GetMapping("/get-by-user-id")
	@Transactional
	public Customer getCustomerByUserId(@RequestParam(required = true) Integer userId) {
		return customerService.getCustomerByUserId(userId.intValue());
	}
}