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
import com.sunny.service.impl.CartItemServiceImpl;
import com.sunny.service.impl.CartServiceImpl;
import com.sunny.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/cartitem")
public class CartItemAPI {
	CartItemServiceImpl cartItemServiceImpl = new CartItemServiceImpl();

	@PostMapping("/add-to-cart")
	@Transactional
	public void addToCart(@RequestBody CartItem cartItem) {
		CartServiceImpl cartServiceImpl = new CartServiceImpl();
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		cartItem.setCartId(cartServiceImpl.getCartById(cartItem.getCartId().getCartId()));
		cartItem.setProductId(productServiceImpl.getProductById(cartItem.getProductId().getPid()));
		cartItemServiceImpl.addToCart(cartItem);
	}

	@PostMapping("/remove-item")
	@Transactional
	public void removeFromCart(@RequestBody CartItem cartItem) {
//		CartServiceImpl cartServiceImpl = new CartServiceImpl();
//		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
//		cartItem.setCartId(cartServiceImpl.getCartById(cartItem.getCartId().getCartId()));
//		cartItem.setProductId(productServiceImpl.getProductById(cartItem.getProductId().getPid()));
		cartItemServiceImpl.removeFromCart(cartItem);
	}

	@GetMapping("/get-all-cartitem")
	@Transactional
	public List<CartItem> getAllCartItem(@RequestParam(required = true) Integer id) {
		return cartItemServiceImpl.getAllCartItem(id.intValue());
	}

	@DeleteMapping("/remove-list")
	@Transactional
	public void removeSelectedCartItem(@RequestBody List<CartItem> listCartItem) {
		cartItemServiceImpl.removeSelectedCartItem(listCartItem);
	}
}