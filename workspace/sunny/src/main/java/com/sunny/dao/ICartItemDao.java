package com.sunny.dao;

import java.util.List;

import com.sunny.model.CartItem;

public interface ICartItemDao {
	boolean existCartItem(CartItem cartItem);

	void addToCart(CartItem cartItem);

	void removeFromCart(CartItem cartItem);

	void removeSelectedCartItem(List<CartItem> listCartItem);

	List<CartItem> getAllCartItem(int CartId);

}
