package com.sunny.service;

import java.util.List;

import com.sunny.model.Customer;
import com.sunny.model.Invoice;
import com.sunny.model.Orders;

public interface IInvoiceService {
	Invoice getInvoiceByOrderId(Orders order);

	List<Invoice> getInvoiceByCustomerId(Customer customer);

	List<Invoice> getAllInvoice();
}
