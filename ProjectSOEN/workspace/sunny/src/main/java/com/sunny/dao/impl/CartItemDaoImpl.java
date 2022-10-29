package com.sunny.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.ICartItemDao;
import com.sunny.model.CartItem;

public class CartItemDaoImpl implements ICartItemDao {

	@Override
	public CartItem create(CartItem cartItem) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(cartItem);
			t.commit();
			session.close();
			return cartItem;
		}
	}

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
//			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//				Transaction t = session.beginTransaction();
//				String hql = "FROM CartItem where CartId = :cartId AND Pid = : pid";
//				CartItem cartItemRes = session.createQuery(hql, CartItem.class)
//						.setParameter("cartId", cartItem.getCartId()).setParameter("pid", cartItem.getProductId())
//						.uniqueResult();
//				cartItemRes.setPrice(cartItem.getProductId().getPrice() + cartItemRes.getPrice());
//				cartItemRes.setQuantity(cartItem.getQuantity() + cartItemRes.getQuantity());
//				cartItemRes.setDiscount(cartItem.getDiscount() + cartItemRes.getDiscount());
//				session.saveOrUpdate(cartItemRes);
//				t.commit();
//				session.close();
//			}
//		} else {
//			create(cartItem);
//		}
		}
	}
}
