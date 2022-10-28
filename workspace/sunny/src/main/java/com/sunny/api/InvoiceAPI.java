package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.dao.IInvoiceDao;
import com.sunny.dao.impl.InvoiceDaoImpl;
import com.sunny.model.Customer;
import com.sunny.model.Invoice;
import com.sunny.model.Orders;

@RestController
@RequestMapping("/invoice")
public class InvoiceAPI {
	private IInvoiceDao invoiceDao = new InvoiceDaoImpl();

	@GetMapping("/get-by-orderId")
	@Transactional
	public Invoice getInvoiceByOrderId(@RequestBody Orders order) {
		return invoiceDao.getInvoiceByOrderId(order);
	}

	@GetMapping("/get-by-customerId")
	@Transactional
	public List<Invoice> getInvoiceByCustomerId(@RequestBody Customer customer) {
		return invoiceDao.getInvoiceByCustomerId(customer);
	}

	@GetMapping("/get")
	@Transactional
	public List<Invoice> getAllInvoice() {
		return invoiceDao.getAllInvoice();
	}

	@PostMapping("/create")
	@Transactional
	public Invoice createInvoice(@RequestBody Orders order) {
		return invoiceDao.createInvoice(order);
	}
}
