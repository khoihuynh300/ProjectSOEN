package com.sunny.service.impl;

import com.sunny.dao.impl.CartItemDaoImpl;
import com.sunny.model.CartItem;
import com.sunny.service.ICartItemService;

public class CartItemServiceImpl implements ICartItemService {

	CartItemDaoImpl cartItemDaoImpl = new CartItemDaoImpl();

	@Override
	public CartItem create(CartItem cartItem) {
		return cartItemDaoImpl.create(cartItem);
	}

	@Override
	public boolean existCartItem(CartItem cartItem) {
		return cartItemDaoImpl.existCartItem(cartItem);
	}

	@Override
	public void addToCart(CartItem cartItem) {
		cartItemDaoImpl.addToCart(cartItem);
	}

}
