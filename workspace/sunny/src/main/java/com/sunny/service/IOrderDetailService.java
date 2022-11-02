package com.sunny.service;

import java.util.List;

import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.service.impl.Result;

public interface IOrderDetailService {

	List<OrderDetail> getAllOrdersDetail(Orders ordersId);

	Result updateStatus(OrderDetail Id);

}