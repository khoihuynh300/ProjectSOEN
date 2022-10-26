package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IInvoiceDao;
import com.sunny.model.Customer;
import com.sunny.model.Invoice;
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
}
