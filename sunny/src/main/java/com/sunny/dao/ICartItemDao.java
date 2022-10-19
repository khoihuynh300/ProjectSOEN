package com.sunny.dao;

import com.sunny.model.CartItem;

public interface ICartItemDao {
	CartItem create(CartItem cartItem);

	boolean existCartItem(CartItem cartItem);

	void addToCart(CartItem cartItem);
}
