package com.sunny.service;

import java.util.List;

import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;

public interface IOrderDetailService {

	List<OrderDetail> getAllOrdersDetail(Orders ordersId);

	void updateStatus(OrderDetail Id);

}