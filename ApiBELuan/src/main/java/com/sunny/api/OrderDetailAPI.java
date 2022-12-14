package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.service.IOrderDetailService;
import com.sunny.service.IOrdersService;
import com.sunny.service.impl.OrderDetailServiceImpl;
import com.sunny.service.impl.OrdersServiceImpl;
import com.sunny.service.impl.Result;
@CrossOrigin
@RestController
@RequestMapping("/orderdetail")
public class OrderDetailAPI {
	private IOrderDetailService orderDetailService = new OrderDetailServiceImpl();
	private IOrdersService ordersService = new OrdersServiceImpl();
	@GetMapping("/get-all-order-detail")
	@Transactional
	public List<OrderDetail> getAllOrderDetail(@RequestParam Integer orderid) {
		Orders Id = ordersService.getOrderById(orderid);
		return orderDetailService.getAllOrdersDetail(Id);
	}

	@PutMapping("/update")
	@Transactional
	public Result updateStatus(@RequestBody OrderDetail orderDetail) {
		return orderDetailService.updateStatus(orderDetail);
	}

	@GetMapping("/get")
	@Transactional
	public OrderDetail getOrderDetailById(@RequestParam(required = true) Integer id) {
		return orderDetailService.getOrderDetailById(id.intValue());
	}
}
