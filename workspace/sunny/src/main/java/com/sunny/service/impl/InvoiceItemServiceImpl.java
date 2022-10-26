package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IInvoiceItemDao;
import com.sunny.dao.impl.InvoiceItemDaoImpl;
import com.sunny.model.Invoice;
import com.sunny.model.InvoiceItem;
import com.sunny.service.IInvoiceItemService;

public class InvoiceItemServiceImpl implements IInvoiceItemService {

	private IInvoiceItemDao invoiceItemDao = new InvoiceItemDaoImpl();

	@Override
	public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
		return invoiceItemDao.createInvoiceItem(invoiceItem);
	}

	@Override
	public List<InvoiceItem> getAll() {
		return invoiceItemDao.getAll();
	}

	@Override
	public List<InvoiceItem> getByInvoiceId(Invoice invoice) {
		return invoiceItemDao.getByInvoiceId(invoice);
	}
}
