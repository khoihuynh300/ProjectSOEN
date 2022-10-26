package com.sunny.dao.impl;

import java.math.BigInteger;
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
				String hql = "FROM CartItem where CartId = :cartId AND Pid = : pid";
				CartItem cartItemRes = session.createQuery(hql, CartItem.class)
						.setParameter("cartId", cartItem.getCartId()).setParameter("pid", cartItem.getProductId())
						.uniqueResult();
				cartItemRes.setQuantity(1 + cartItemRes.getQuantity());
				session.update(cartItemRes);
				t.commit();
				session.close();
			}
		} else {
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				Transaction t = session.beginTransaction();
				session.save(cartItem);
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
			String hql = "FROM CartItem where CartId = :cartId AND Pid = : pid";
			CartItem cartItemRes = session.createQuery(hql, CartItem.class).setParameter("cartId", cartItem.getCartId())
					.setParameter("pid", cartItem.getProductId()).uniqueResult();
			cartItemRes.setQuantity(cartItemRes.getQuantity() - 1);
			session.update(cartItemRes);
			if (cartItemRes.getQuantity() == 0)
				session.delete(cartItemRes);
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
			t.commit();
			session.close();
		}
	}

	@Override
	public Long getAmountDistinctCartItem(int CartId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query query = session.createNativeQuery("SELECT COUNT(Id) FROM CartItem WHERE CartId = :CartId")
					.setParameter("CartId", CartId);
			Long result = ((BigInteger) query.uniqueResult()).longValue();
			session.close();
			return result;
		}
	}

}
