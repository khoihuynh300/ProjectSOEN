package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.CartItem;
import com.sunny.service.impl.CartItemServiceImpl;

@RestController
public class CartItemAPI {
	@PostMapping("/add-to-cart")
	@Transactional
	public void addToCart(@RequestBody CartItem cartItem) {
		CartItemServiceImpl cartItemServiceImpl = new CartItemServiceImpl();
		cartItemServiceImpl.addToCart(cartItem);
	}
}
