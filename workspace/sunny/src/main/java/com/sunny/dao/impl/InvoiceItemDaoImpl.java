package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IInvoiceItemDao;
import com.sunny.model.Invoice;
import com.sunny.model.InvoiceItem;

public class InvoiceItemDaoImpl implements IInvoiceItemDao {
	@Override
	public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(invoiceItem);
			t.commit();
			session.close();
			return invoiceItem;
		}
	}

	@Override
	public List<InvoiceItem> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<InvoiceItem> result = session.createQuery("FROM InvoiceItem", InvoiceItem.class).getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public List<InvoiceItem> getByInvoiceId(Invoice invoice) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<InvoiceItem> result = session
					.createQuery("FROM InvoiceItem WHERE InvoiceId.InvoiceId = :InvoiceId", InvoiceItem.class)
					.getResultList();
			session.close();
			return result;
		}
	}
}
