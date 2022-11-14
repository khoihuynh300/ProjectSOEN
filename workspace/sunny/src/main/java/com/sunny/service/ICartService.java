package com.sunny.service;

import java.util.List;

import com.sunny.model.Cart;

public interface ICartService {
	Cart create(Cart cart);

	List<Cart> getAllCart();

	Cart getCartById(int id);

	Cart getCartByCustomerId(int id);
}
