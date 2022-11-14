package com.sunny.dao;

import java.util.List;

import com.sunny.model.Cart;

public interface ICartDao {
	Cart create(Cart cart);

	List<Cart> getAllCart();

	Cart getCartById(int id);

	Cart getCartByCustomerId(int id);
}
