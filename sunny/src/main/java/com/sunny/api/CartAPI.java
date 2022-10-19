package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Cart;
import com.sunny.service.impl.CartServiceImpl;

@RestController

public class CartAPI {
	CartServiceImpl cartServiceImpl = new CartServiceImpl();

	@GetMapping("/cart")
	@Transactional
	public ResponseEntity<?> getAllCart() {
		List<Cart> result = cartServiceImpl.getAllCart();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
