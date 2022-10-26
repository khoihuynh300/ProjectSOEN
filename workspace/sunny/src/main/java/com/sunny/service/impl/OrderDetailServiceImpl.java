package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IOrderDetailDao;
import com.sunny.dao.impl.OrderDetailDaoImpl;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.service.IOrderDetailService;

public class OrderDetailServiceImpl implements IOrderDetailService {
	private IOrderDetailDao orderDetailDao = new OrderDetailDaoImpl();

	@Override
	public List<OrderDetail> getAllOrdersDetail(Orders ordersId) {
		return orderDetailDao.getAllOrdersDetail(ordersId);
	}

	@Override
	public void updateStatus(OrderDetail Id) {
		orderDetailDao.updateStatus(Id);
	}
}
