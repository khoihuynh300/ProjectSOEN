package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IInvoiceDao;
import com.sunny.dao.impl.InvoiceDaoImpl;
import com.sunny.model.Customer;
import com.sunny.model.Invoice;
import com.sunny.model.Orders;
import com.sunny.service.IInvoiceService;

public class InvoiceServiceImpl implements IInvoiceService {

	private IInvoiceDao invoiceDao = new InvoiceDaoImpl();

	@Override
	public Invoice getInvoiceByOrderId(Orders order) {
		return invoiceDao.getInvoiceByOrderId(order);
	}

	@Override
	public List<Invoice> getInvoiceByCustomerId(Customer customer) {
		return invoiceDao.getInvoiceByCustomerId(customer);
	}

	@Override
	public List<Invoice> getAllInvoice() {
		return invoiceDao.getAllInvoice();
	}

	@Override
	public Result createInvoice(Orders order) {
		invoiceDao.createInvoice(order);
		return new Result(true, "Create Invoice successfully!!!");
	}

}
