package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.CartItem;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;
import com.sunny.service.IOrdersService;
import com.sunny.service.impl.OrdersServiceImpl;
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/orders")
public class OrdersAPI {
	private IOrdersService ordersService = new OrdersServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result createOrder(@RequestPart String address, @RequestPart PaymentMethod paymentMethod,
			@RequestPart List<CartItem> listCartItem) {
		return ordersService.createOrder(address, paymentMethod, listCartItem);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(ordersService.getAllOrders())
				: ResponseEntity.status(HttpStatus.OK).body(ordersService.getOrderById(id.intValue()));
	}

	@PutMapping("/update")
	@Transactional
	public Result updateStatus(@RequestBody Orders order) {
		return ordersService.updateStatus(order);
	}
}
