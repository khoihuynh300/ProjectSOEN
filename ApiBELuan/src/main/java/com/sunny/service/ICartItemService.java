package com.sunny.service;

import java.util.List;

import com.sunny.model.CartItem;
import com.sunny.service.impl.Result;

public interface ICartItemService {

	Result createCartItem(CartItem cartItem);

	Result addToCart(CartItem cartItem);

	Result removeFromCart(CartItem cartItem);

	Result removeSelectedCartItem(List<CartItem> listCartItem);

	List<CartItem> getAllCartItem(int CartId);

	CartItem getCartItem(int cartId, int pId);

	CartItem getCartItemById(int id);

	void updateCartItem(CartItem cartItem);

}
