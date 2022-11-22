package com.sunny.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.ICartItemDao;
import com.sunny.dao.IInvoiceDao;
import com.sunny.dao.IOrdersDao;
import com.sunny.model.CartItem;
import com.sunny.model.Discount;
import com.sunny.model.Employee;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;

public class OrdersDaoImpl implements IOrdersDao {

	@Override
	public Orders createOrder(String address, PaymentMethod paymentMethod, List<CartItem> listCartItem) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Orders result = new Orders();
			result.setCusId(listCartItem.get(0).getCartId().getCusId());
			result.setOrderDate(Calendar.getInstance().getTime());
			result.setPaymentMethod(paymentMethod);
			result.setShipAddress(address);
			session.persist(result);
			ICartItemDao cartItemDao = new CartItemDaoImpl();
			cartItemDao.removeSelectedCartItem(listCartItem);
			for (CartItem item : listCartItem) {
				// orderDetailDaoImpl.createOrderDetail(result, item);
				OrderDetail res = new OrderDetail();
				res.setOrderId(result);
				res.setProductId(item.getProductId());
				res.setPrice(item.getProductId().getPrice());
				res.setQuantity(item.getQuantity());
				Discount discount = item.getProductId().getDiscountId();
				if (discount != null)
					res.setDiscount(Math.min(res.getPrice(), discount.getAmount() * res.getQuantity()
							+ res.getQuantity() * res.getPrice() * discount.getPercent()));
				else
					res.setDiscount(0);
				session.persist(res);
			}
			t.commit();
			session.close();
			IInvoiceDao invoiceDao = new InvoiceDaoImpl();
			invoiceDao.createInvoice(result);
			return result;
		}
	}

	@Override
	public List<Orders> getAllOrders(int cusid,int shipid) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Orders> query;
			if(shipid != 0) {
				query = session.createQuery("FROM Orders where EmpId = " +shipid+ " ORDER BY OrderId DESC ", Orders.class);
			}
			else if(cusid != 0) {
				query = session.createQuery("FROM Orders where CusId = " +cusid+ " ORDER BY OrderId DESC ", Orders.class);
			}
			else {
				
				query = session.createQuery("FROM Orders ORDER BY OrderId DESC", Orders.class);
			}
			List<Orders> result = query.getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public void updateStatus(Orders order) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Orders temporder = session.get(Orders.class, order.getOrderId());
			// temporder = session.get(Orders.class, order.getOrderId());
			temporder.setStatus(order.getStatus());

			session.update(temporder);
			t.commit();
			session.close();
		}
	}

	@Override
	public Orders getOrderById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Orders result = session.get(Orders.class, id);
			session.close();
			return result;
		}
	}

	@Override
	public List<Orders> getOrdersByShipperId(Employee id, int status) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Orders> query = session
					.createQuery("FROM Orders where ShipId = :id AND Status = :status", Orders.class)
					.setParameter("id", id).setParameter("status", status);
			List<Orders> result = query.getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public List<Orders> getAllOrdersDescendingId(int pageNumber, int pageSize) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Orders> query = session.createQuery("FROM Orders ORDER BY OrderId DESC", Orders.class)
					.setFirstResult((pageNumber - 1) * pageSize).setMaxResults(pageSize);
			List<Orders> result = query.getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public boolean getorder(Orders order) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			session.update(order);
			t.commit();
			session.close();
			return true;
		}
	}
}
