package com.sunny.dao;

import java.util.List;

import com.sunny.model.Customer;
import com.sunny.model.Invoice;
import com.sunny.model.Orders;

public interface IInvoiceDao {

	Invoice getInvoiceByOrderId(Orders order);

	List<Invoice> getInvoiceByCustomerId(Customer customer);

	List<Invoice> getAllInvoice();

}