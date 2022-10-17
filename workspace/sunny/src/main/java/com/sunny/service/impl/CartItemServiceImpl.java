package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.CartItemDaoImpl;
import com.sunny.model.CartItem;
import com.sunny.service.ICartItemService;

public class CartItemServiceImpl implements ICartItemService {

	CartItemDaoImpl cartItemDaoImpl = new CartItemDaoImpl();

	@Override
	public boolean existCartItem(CartItem cartItem) {
		return cartItemDaoImpl.existCartItem(cartItem);
	}

	@Override
	public void addToCart(CartItem cartItem) {
		cartItemDaoImpl.addToCart(cartItem);
	}

	@Override
	public void removeFromCart(CartItem cartItem) {
		cartItemDaoImpl.removeFromCart(cartItem);
	}

	@Override
	public List<CartItem> getAllCartItem(int CartId) {
		return cartItemDaoImpl.getAllCartItem(CartId);
	}

	@Override
	public void removeSelectedCartItem(List<CartItem> listCartItem) {
		cartItemDaoImpl.removeSelectedCartItem(listCartItem);
	}

}
