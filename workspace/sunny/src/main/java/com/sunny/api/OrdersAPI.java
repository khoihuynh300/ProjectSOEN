package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.CartItem;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;
import com.sunny.service.IOrdersService;
import com.sunny.service.impl.OrdersServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrdersAPI {
	private IOrdersService ordersService = new OrdersServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Orders createOrder(@RequestPart String address, @RequestPart PaymentMethod paymentMethod,
			@RequestPart List<CartItem> listCartItem) {
		return ordersService.createOrder(address, paymentMethod, listCartItem);
	}

	@GetMapping("/get-all-orders")
	@Transactional
	public List<Orders> getAllOrders() {
		return ordersService.getAllOrders();
	}

	@PutMapping("/update")
	@Transactional
	public void updateStatus(@RequestBody Orders order) {
		ordersService.updateStatus(order);
	}
}
