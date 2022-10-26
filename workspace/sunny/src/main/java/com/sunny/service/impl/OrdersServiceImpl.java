package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IOrdersDao;
import com.sunny.dao.impl.OrdersDaoImpl;
import com.sunny.model.CartItem;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;
import com.sunny.service.IOrdersService;

public class OrdersServiceImpl implements IOrdersService {
	private IOrdersDao ordersDao = new OrdersDaoImpl();

	@Override
	public Orders createOrder(String address, PaymentMethod paymentMethod, List<CartItem> listCartItem) {
		return ordersDao.createOrder(address, paymentMethod, listCartItem);
	}

	@Override
	public List<Orders> getAllOrders() {
		return ordersDao.getAllOrders();
	}

	@Override
	public void updateStatus(Orders order) {
		ordersDao.updateStatus(order);
	}
}
