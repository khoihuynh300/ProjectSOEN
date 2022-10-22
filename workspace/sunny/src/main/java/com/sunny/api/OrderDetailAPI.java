package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.service.impl.OrderDetailServiceImpl;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailAPI {
	OrderDetailServiceImpl orderDetailServiceImpl = new OrderDetailServiceImpl();

	@GetMapping("/get-all-order-detail")
	@Transactional
	public List<OrderDetail> getAllOrderDetail(@RequestBody Orders Id) {
		return orderDetailServiceImpl.getAllOrdersDetail(Id);
	}

	@PutMapping("/update")
	@Transactional
	public void updateStatus(@RequestBody OrderDetail orderDetail) {
		orderDetailServiceImpl.updateStatus(orderDetail);
	}
}
