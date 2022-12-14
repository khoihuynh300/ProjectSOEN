package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Customer;
import com.sunny.model.Invoice;
import com.sunny.model.Orders;
import com.sunny.service.IInvoiceService;
import com.sunny.service.impl.InvoiceServiceImpl;
import com.sunny.service.impl.Result;
@CrossOrigin
@RestController
@RequestMapping("/invoice")
public class InvoiceAPI {
	private IInvoiceService invoiceService = new InvoiceServiceImpl();

	@GetMapping("/get-by-orderId")
	@Transactional
	public Invoice getInvoiceByOrderId(@RequestBody Orders order) {
		return invoiceService.getInvoiceByOrderId(order);
	}

	@GetMapping("/get-by-customerId")
	@Transactional
	public List<Invoice> getInvoiceByCustomerId(@RequestBody Customer customer) {
		return invoiceService.getInvoiceByCustomerId(customer);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> getAllInvoice(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(invoiceService.getAllInvoice())
				: ResponseEntity.status(HttpStatus.OK).body(invoiceService.getInvoiceById(id.intValue()));
	}

	@PostMapping("/create")
	@Transactional
	public Result createInvoice(@RequestBody Orders order) {
		return invoiceService.createInvoice(order);
	}
}
