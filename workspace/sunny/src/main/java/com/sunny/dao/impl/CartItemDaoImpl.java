package com.sunny.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.ICartItemDao;
import com.sunny.model.Cart;
import com.sunny.model.CartItem;

public class CartItemDaoImpl implements ICartItemDao {

	@Override
	public boolean existCartItem(CartItem cartItem) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			String hql = "FROM CartItem where CartId = :cartId AND Pid = : pid";
			CartItem cartItemRes = session.createQuery(hql, CartItem.class).setParameter("cartId", cartItem.getCartId())
					.setParameter("pid", cartItem.getProductId()).uniqueResult();
			t.commit();
			session.close();
			return cartItemRes != null;
		}
	}

	@Override
	public void addToCart(CartItem cartItem) {
		if (existCartItem(cartItem) == true) {
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				Transaction t = session.beginTransaction();
				cartItem.setQuantity(1 + cartItem.getQuantity());
				session.update(cartItem);
				t.commit();
				session.close();
			}
		} else {
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				Transaction t = session.beginTransaction();
				session.persist(cartItem);
				Cart cart = cartItem.getCartId();
				cart.setAmountUniqueItem(cart.getAmountUniqueItem() + 1);
				session.update(cart);
				t.commit();
				session.close();
			}
		}
	}

	@Override
	public List<CartItem> getAllCartItem(int CartId) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			CartDaoImpl cartDaoImpl = new CartDaoImpl();
			Cart cart = cartDaoImpl.getCartById(CartId);
			Query<CartItem> query = session.createQuery("From CartItem where CartId = :CartId", CartItem.class)
					.setParameter("CartId", cart);
			List<CartItem> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public void removeFromCart(CartItem cartItem) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (cartItem.getQuantity() == 1) {
				session.delete(cartItem);
				Cart cart = cartItem.getCartId();
				cart.setAmountUniqueItem(cart.getAmountUniqueItem() - 1);
				session.update(cart);
			} else {
				cartItem.setQuantity(cartItem.getQuantity() - 1);
				session.update(cartItem);
			}
			t.commit();
			session.close();
		}
	}

	@Override
	public void removeSelectedCartItem(List<CartItem> listCartItem) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			List<Integer> listPid = new ArrayList<Integer>();
			for (CartItem cartItem : listCartItem) {
				listPid.add(cartItem.getProductId().getPid());
			}
			Query<?> query = session
					.createQuery("DELETE CartItem cartItem WHERE CartId = :CartId AND ProductId.Pid IN (:list)");
			query.setParameter("CartId", listCartItem.get(0).getCartId());
			query.setParameter("list", listPid);
			query.executeUpdate();
			Cart cart = listCartItem.get(0).getCartId();
			cart.setAmountUniqueItem(cart.getAmountUniqueItem() - listCartItem.size());
			session.update(cart);
			t.commit();
			session.close();
		}
	}

	@Override
	public CartItem getCartItem(int cartId, int pId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM CartItem where CartId.CartId = :cartId AND ProductId.Pid = : pid";
			CartItem cartItemRes = session.createQuery(hql, CartItem.class).setParameter("cartId", cartId)
					.setParameter("pid", pId).uniqueResult();
			session.close();
			return cartItemRes;
		}
	}
}
