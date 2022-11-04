package com.sunny.dao;

import java.util.List;

import com.sunny.model.CartItem;

public interface ICartItemDao {
	void createCartItem(CartItem cartItem);

	void addToCart(CartItem cartItem);

	void removeFromCart(CartItem cartItem);

	void removeSelectedCartItem(List<CartItem> listCartItem);

	List<CartItem> getAllCartItem(int CartId);

	CartItem getCartItem(int cartId, int pId);

	CartItem getCartItemById(int id);
}
