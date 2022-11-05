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
	public Result createOrder(String address, PaymentMethod paymentMethod, List<CartItem> listCartItem) {
		ordersDao.createOrder(address, paymentMethod, listCartItem);
		return new Result(true, "Create Order successfully!!!");
	}

	@Override
	public List<Orders> getAllOrders() {
		return ordersDao.getAllOrders();
	}

	@Override
	public Result updateStatus(Orders order) {
		ordersDao.updateStatus(order);
		return new Result(true, "Update Order successfully!!!");
	}

	@Override
	public Orders getOrderById(int id) {
		return ordersDao.getOrderById(id);
	}
}
