package com.sunny.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IOrdersDao;
import com.sunny.model.CartItem;
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
			session.save(result);
			t.commit();
			CartItemDaoImpl cartItemDaoImpl = new CartItemDaoImpl();
			cartItemDaoImpl.removeSelectedCartItem(listCartItem);
			OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
			for (CartItem item : listCartItem) {
				orderDetailDaoImpl.createOrderDetail(result, item);
			}
			session.close();
			return result;
		}
	}

	@Override
	public List<Orders> getAllOrders() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Orders> query = session.createQuery("FROM Orders", Orders.class);
			List<Orders> result = query.getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public void updateStatus(Orders order) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.update(order);
			t.commit();
			session.close();
		}
	}
}
