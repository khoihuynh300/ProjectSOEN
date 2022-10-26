package com.sunny.service;

import java.util.List;

import com.sunny.model.Invoice;
import com.sunny.model.InvoiceItem;

public interface IInvoiceItemService {
	InvoiceItem createInvoiceItem(InvoiceItem invoiceItem);

	List<InvoiceItem> getAll();

	List<InvoiceItem> getByInvoiceId(Invoice invoice);
}
