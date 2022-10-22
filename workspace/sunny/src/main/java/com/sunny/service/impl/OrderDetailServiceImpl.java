package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.OrderDetailDaoImpl;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.service.IOrderDetailService;

public class OrderDetailServiceImpl implements IOrderDetailService {
	OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();

	@Override
	public List<OrderDetail> getAllOrdersDetail(Orders ordersId) {
		return orderDetailDaoImpl.getAllOrdersDetail(ordersId);
	}

	@Override
	public void updateStatus(OrderDetail Id) {
		orderDetailDaoImpl.updateStatus(Id);
	}
}
