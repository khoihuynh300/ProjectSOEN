package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Cart;
import com.sunny.service.ICartService;
import com.sunny.service.impl.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartAPI {
	private ICartService cartService = new CartServiceImpl();

	@GetMapping("/get-all-cart")
	@Transactional
	public ResponseEntity<?> getAllCart() {
		List<Cart> result = cartService.getAllCart();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
