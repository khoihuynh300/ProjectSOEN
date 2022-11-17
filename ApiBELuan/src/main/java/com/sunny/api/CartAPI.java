package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Cart;
import com.sunny.service.ICartService;
import com.sunny.service.impl.CartServiceImpl;
@CrossOrigin
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

	@GetMapping("/get-amount-unique-item")
	@Transactional
	public int getAmountUniqueItem(@RequestBody Cart cart) {
		return cart.getAmountUniqueItem();
	}

	@GetMapping("/get")
	@Transactional
	public Cart getCartById(@RequestParam(required = true) Integer id) {
		return cartService.getCartById(id.intValue());
	}
	
	@GetMapping("/get-by-customer-id")
	@Transactional
	public Cart getByCustomerId(@RequestParam(required = true) Integer id) {
		return cartService.getCartByCustomerId(id.intValue());
	}
}
