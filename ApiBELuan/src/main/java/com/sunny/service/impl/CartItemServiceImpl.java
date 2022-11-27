package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.ICartItemDao;
import com.sunny.dao.impl.CartItemDaoImpl;
import com.sunny.model.CartItem;
import com.sunny.service.ICartItemService;

public class CartItemServiceImpl implements ICartItemService {

	private ICartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public Result addToCart(CartItem cartItem) {
		cartItemDao.addToCart(cartItem);
		return new Result(true, "Add to cart successfully!!!");
	}

	@Override
	public Result removeFromCart(CartItem cartItem) {
		cartItemDao.removeFromCart(cartItem);
		return new Result(true, "Remove from cart successfully!!!");
	}

	@Override
	public List<CartItem> getAllCartItem(int CartId) {
		return cartItemDao.getAllCartItem(CartId);
	}

	@Override
	public Result removeSelectedCartItem(List<CartItem> listCartItem) {
		cartItemDao.removeSelectedCartItem(listCartItem);
		return new Result(true, "Remove from cart successfully!!!");
	}

	@Override
	public CartItem getCartItem(int cartId, int pId) {
		return cartItemDao.getCartItem(cartId, pId);
	}

	@Override
	public CartItem getCartItemById(int id) {
		return cartItemDao.getCartItemById(id);
	}

	@Override
	public Result createCartItem(CartItem cartItem) {
		cartItemDao.createCartItem(cartItem);
		return new Result(true, "Add to cart successfully!!!");
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		cartItemDao.updateCartItem(cartItem);
	}
}
