package com.sunny.service;

import java.util.List;

import com.sunny.model.CartItem;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;
import com.sunny.service.impl.Result;

public interface IOrdersService {

	Result createOrder(String address, PaymentMethod paymentMethod, List<CartItem> listCartItem);

	List<Orders> getAllOrders();

	Result updateStatus(Orders order);

	Orders getOrderById(int id);

}