package com.sunny.dao;

import java.util.List;

import com.sunny.model.CartItem;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;

public interface IOrderDetailDao {

	List<OrderDetail> getAllOrdersDetail(Orders ordersId);

	void updateStatus(OrderDetail Id);

	OrderDetail createOrderDetail(Orders orderId, CartItem item);

}