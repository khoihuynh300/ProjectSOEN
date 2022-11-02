package com.sunny.service;

import java.util.List;

import com.sunny.model.Invoice;
import com.sunny.model.InvoiceItem;
import com.sunny.service.impl.Result;

public interface IInvoiceItemService {
	Result createInvoiceItem(InvoiceItem invoiceItem);

	List<InvoiceItem> getAll();

	List<InvoiceItem> getByInvoiceId(Invoice invoice);
}
