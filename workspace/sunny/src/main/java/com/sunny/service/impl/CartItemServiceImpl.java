package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.ICartItemDao;
import com.sunny.dao.impl.CartItemDaoImpl;
import com.sunny.model.CartItem;
import com.sunny.service.ICartItemService;

public class CartItemServiceImpl implements ICartItemService {

	private ICartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public boolean existCartItem(CartItem cartItem) {
		return cartItemDao.existCartItem(cartItem);
	}

	@Override
	public void addToCart(CartItem cartItem) {
		cartItemDao.addToCart(cartItem);
	}

	@Override
	public void removeFromCart(CartItem cartItem) {
		cartItemDao.removeFromCart(cartItem);
	}

	@Override
	public List<CartItem> getAllCartItem(int CartId) {
		return cartItemDao.getAllCartItem(CartId);
	}

	@Override
	public void removeSelectedCartItem(List<CartItem> listCartItem) {
		cartItemDao.removeSelectedCartItem(listCartItem);
	}

}
