package com.sunny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.dao.impl.CartDaoImpl;
import com.sunny.model.Cart;
import com.sunny.service.ICartService;

public class CartServiceImpl implements ICartService {

	@Autowired
	CartDaoImpl cartDaoImpl = new CartDaoImpl();

	@Override
	public Cart create(Cart cart) {
		return cartDaoImpl.create(cart);
	}

	@Override
	public List<Cart> getAllCart() {
		return cartDaoImpl.getAllCart();
	}

	@Override
	public Cart getCartById(int id) {
		return cartDaoImpl.getCartById(id);
	}

}
