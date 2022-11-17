package com.sunny.dao;

import java.util.List;

import com.sunny.model.CartItem;
import com.sunny.model.Employee;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;

public interface IOrdersDao {

	Orders createOrder(String address, PaymentMethod paymentMethod, List<CartItem> listCartItem);

	List<Orders> getAllOrders();

	List<Orders> getOrdersByShipperId(Employee id, int status);
	
	void updateStatus(Orders order);

	Orders getOrderById(int id);
	
}