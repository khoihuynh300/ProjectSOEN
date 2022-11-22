package com.sunny.dao;

import java.util.List;

import com.sunny.model.Invoice;
import com.sunny.model.InvoiceItem;

public interface IInvoiceItemDao {

	InvoiceItem createInvoiceItem(InvoiceItem invoiceItem);

	List<InvoiceItem> getAll();

	List<InvoiceItem> getByInvoiceId(Invoice invoice);

	InvoiceItem getInvoiceItemById(int id);
}