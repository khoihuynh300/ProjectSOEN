package com.sunny.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IOrderDetailDao;
import com.sunny.model.CartItem;
import com.sunny.model.Discount;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;

public class OrderDetailDaoImpl implements IOrderDetailDao {
	@Override
	public List<OrderDetail> getAllOrdersDetail(Orders ordersId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<OrderDetail> query = session
					.createQuery("From OrderDetail Where OrderId = :orderId", OrderDetail.class)
					.setParameter("orderId", ordersId);
			List<OrderDetail> result = query.getResultList();
			session.close();
			return result;
		}
	}

	@Override
	public void updateStatus(OrderDetail Id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.update(Id);
			t.commit();
			session.close();
		}
	}

	@Override
	public OrderDetail createOrderDetail(Orders orderId, CartItem item) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			OrderDetail result = new OrderDetail();
			result.setOrderId(orderId);
			result.setProductId(item.getProductId());
			result.setPrice(item.getProductId().getPrice());
			result.setQuantity(item.getQuantity());
			Discount discount = item.getProductId().getDiscountId();
			if (discount != null)
				result.setDiscount(
						Math.min(result.getPrice(), discount.getAmount() + result.getPrice() * discount.getPercent()));
			else
				result.setDiscount(0);
			session.save(result);
			t.commit();
			session.close();
			return result;
		}
	}
}
