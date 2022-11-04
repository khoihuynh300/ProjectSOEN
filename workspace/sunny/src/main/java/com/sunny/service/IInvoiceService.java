package com.sunny.service;

import java.util.List;

import com.sunny.model.Customer;
import com.sunny.model.Invoice;
import com.sunny.model.Orders;
import com.sunny.service.impl.Result;

public interface IInvoiceService {
	Invoice getInvoiceByOrderId(Orders order);

	List<Invoice> getInvoiceByCustomerId(Customer customer);

	List<Invoice> getAllInvoice();

	Result createInvoice(Orders order);

	Invoice getInvoiceById(int id);
}
