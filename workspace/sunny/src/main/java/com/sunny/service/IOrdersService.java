package com.sunny.service;

import java.util.List;

import com.sunny.model.CartItem;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;

public interface IOrdersService {

	Orders createOrder(String address, PaymentMethod paymentMethod, List<CartItem> listCartItem);

	List<Orders> getAllOrders();

	void updateStatus(Orders order);

}