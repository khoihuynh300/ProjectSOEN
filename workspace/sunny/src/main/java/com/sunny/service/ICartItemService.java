package com.sunny.service;

import java.util.List;

import com.sunny.model.CartItem;
import com.sunny.service.impl.Result;

public interface ICartItemService {
	boolean existCartItem(CartItem cartItem);

	Result addToCart(CartItem cartItem);

	Result removeFromCart(CartItem cartItem);

	Result removeSelectedCartItem(List<CartItem> listCartItem);

	List<CartItem> getAllCartItem(int CartId);

	CartItem getCartItem(int cartId, int pId);

}
