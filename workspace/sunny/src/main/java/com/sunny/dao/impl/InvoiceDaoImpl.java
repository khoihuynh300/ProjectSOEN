package com.sunny.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IInvoiceDao;
import com.sunny.model.Customer;
import com.sunny.model.Invoice;
import com.sunny.model.InvoiceItem;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;

public class InvoiceDaoImpl implements IInvoiceDao {
	@Override
	public Invoice getInvoiceByOrderId(Orders order) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Invoice result = session.createQuery("FROM Invoice WHERE OrderId = :OrderId", Invoice.class)
					.setParameter("OrderId", order).uniqueResult();
			session.close();
			return result;
		}
	}

	@Override
	public List<Invoice> getInvoiceByCustomerId(Customer customer) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Invoice> result = session.createQuery("FROM Invoice WHERE CusId = :CusId", Invoice.class)
					.setParameter("CusId", customer).getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public List<Invoice> getAllInvoice() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Invoice> result = session.createQuery("FROM Invoice", Invoice.class).getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public Invoice createInvoice(Orders order) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Invoice invoice = new Invoice();
			invoice.setOrderId(order);
			invoice.setCreationDate(Calendar.getInstance().getTime());
			invoice.setCusomerName(order.getCusId().getName());
			invoice.setPaymentMethod(order.getPaymentMethod());
			List<OrderDetail> result = session
					.createQuery("FROM OrderDetail WHERE OrderId = :OrderId ", OrderDetail.class)
					.setParameter("OrderId", order).getResultList();
			double total = 0;
			for (OrderDetail od : result) {
				total += od.getPrice() - od.getDiscount();
			}
			invoice.setTotal(total);
			session.persist(invoice);
			for (OrderDetail od : result) {
				InvoiceItem invoiceItem = new InvoiceItem();
				invoiceItem.setInvoiceId(invoice);
				invoiceItem.setOrderDetailId(od);
				invoiceItem.setPrice(od.getPrice() - od.getDiscount());
				invoiceItem.setQuantity(od.getQuantity());
				session.persist(invoiceItem);
			}
			t.commit();
			session.close();
			return invoice;
		}
	}
}
