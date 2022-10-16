package com.sunny.service;

import com.sunny.model.CartItem;

public interface ICartItemService {
	CartItem create(CartItem cartItem);

	boolean existCartItem(CartItem cartItem);

	void addToCart(CartItem cartItem);
}
