package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.CartItem;
import com.sunny.service.ICartItemService;
import com.sunny.service.impl.CartItemServiceImpl;
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/cartitem")
public class CartItemAPI {
	private ICartItemService cartItemService = new CartItemServiceImpl();

	@PostMapping("/add-to-cart")
	@Transactional
	public Result addToCart(@RequestBody CartItem cartItem) {
		return cartItemService.addToCart(
				cartItemService.getCartItem(cartItem.getCartId().getCartId(), cartItem.getProductId().getPid()));
	}

	@PostMapping("/remove-item")
	@Transactional
	public Result removeFromCart(@RequestBody CartItem cartItem) {
		return cartItemService.removeFromCart(
				cartItemService.getCartItem(cartItem.getCartId().getCartId(), cartItem.getProductId().getPid()));
	}

	@GetMapping("/get-all-cartitem")
	@Transactional
	public List<CartItem> getAllCartItem(@RequestParam(required = true) Integer id) {
		return cartItemService.getAllCartItem(id.intValue());
	}

	@DeleteMapping("/remove-list")
	@Transactional
	public Result removeSelectedCartItem(@RequestBody List<CartItem> listCartItem) {
		return cartItemService.removeSelectedCartItem(listCartItem);
	}
}
