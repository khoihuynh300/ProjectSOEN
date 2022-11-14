package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.CartItem;
import com.sunny.service.ICartItemService;
import com.sunny.service.ICartService;
import com.sunny.service.IProductService;
import com.sunny.service.impl.CartItemServiceImpl;
import com.sunny.service.impl.CartServiceImpl;
import com.sunny.service.impl.ProductServiceImpl;
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/cartitem")
public class CartItemAPI {
	private ICartItemService cartItemService = new CartItemServiceImpl();
	private ICartService cartService = new CartServiceImpl();
	private IProductService productService = new ProductServiceImpl();

	@PostMapping("/add-to-cart")
	@Transactional
	public Result addToCart(@RequestBody CartItem cartItem) {
		CartItem temp = cartItemService.getCartItem(cartItem.getCartId().getCartId(), cartItem.getProductId().getPid());
		if (temp == null) {
			temp = new CartItem();
			temp.setCartId(cartService.getCartById(cartItem.getCartId().getCartId()));
			temp.setProductId(productService.getProductById(cartItem.getProductId().getPid()));
			temp.setQuantity(1);
			return cartItemService.createCartItem(temp);
		}
		return cartItemService.addToCart(temp);
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

	@GetMapping("/get")
	@Transactional
	public CartItem getCartItemById(@RequestParam(required = true) Integer id) {
		return cartItemService.getCartItemById(id.intValue());
	}

	@PutMapping("/update")
	@Transactional
	public void updateCartItem(@RequestBody CartItem cartItem) {
		CartItem cartItemRes = cartItemService.getCartItemById(cartItem.getId());
		cartItemRes.setQuantity(cartItem.getQuantity());
		cartItemService.updateCartItem(cartItemRes);
	}
}
