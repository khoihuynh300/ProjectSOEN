package com.sunny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.dao.ICartDao;
import com.sunny.dao.impl.CartDaoImpl;
import com.sunny.model.Cart;
import com.sunny.service.ICartService;

public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartDao cartDao = new CartDaoImpl();

	@Override
	public Cart create(Cart cart) {
		return cartDao.create(cart);
	}

	@Override
	public List<Cart> getAllCart() {
		return cartDao.getAllCart();
	}

	@Override
	public Cart getCartById(int id) {
		return cartDao.getCartById(id);
	}

}
