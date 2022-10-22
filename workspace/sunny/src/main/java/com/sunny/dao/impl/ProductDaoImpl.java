package com.sunny.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductDao;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.model.Product;
import com.sunny.model.ProductType;

public class ProductDaoImpl implements IProductDao {

	@Override
	public Product createProduct(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(product);
			t.commit();
			session.close();
			return product;
		}
	}

	@Override
	public List<Product> getAllProductByPtype(int Ptype) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			ProductTypeDaoImpl productDaoImpl = new ProductTypeDaoImpl();
			ProductType productType = productDaoImpl.getProductTypeById(Ptype);
			Transaction t = session.beginTransaction();
			Query<Product> query = session.createQuery("From Product where Ptype =:Ptype", Product.class)
					.setParameter("Ptype", productType);
			List<Product> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public List<Product> getAllProduct() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<Product> query = session.createQuery("From Product", Product.class);
			List<Product> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public Product getProductById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Product product = (Product) session.get(Product.class, id);
			t.commit();
			return product;
		}
	}

	@Override
	public void updateProduct(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(product);
			transaction.commit();
			session.close();
		}
	}

	@Override
	public void deleteProduct(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			Product productRes = getProductById(product.getPid());
			productRes.setDeleted(true);
			session.update(productRes);
			t.commit();
			session.close();
		}
	}

	@Override
	public List<Product> getRecommendedProducts(int size) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			Query<Orders> query_order = session
//					.createQuery("FROM Orders WHERE OrderDate < DATE_SUB(NOW(),INTERVAL 3 MONTH)", Orders.class);
			Query<Orders> query_order = session.createNativeQuery(
					"SELECT * FROM Orders WHERE OrderDate >= DATE_SUB(NOW(),INTERVAL 3 MONTH)", Orders.class);
			List<Orders> listOrders = query_order.getResultList();
			List<Integer> listOrderId = new ArrayList<>();
			for (Orders order : listOrders) {
				listOrderId.add(order.getOrderId());
			}
			Query<OrderDetail> query_orderDetail = session
					.createQuery("FROM OrderDetail WHERE OrderId.OrderId IN (:list)", OrderDetail.class)
					.setParameter("list", listOrderId);
			List<OrderDetail> listOrderDetail = query_orderDetail.getResultList();
			Map<Product, Integer> mp = new HashMap<>();
			for (OrderDetail orderDetail : listOrderDetail) {
				if (mp.containsKey(orderDetail.getProductId())) {
					int old = mp.get(orderDetail.getProductId());
					mp.replace(orderDetail.getProductId(), old + orderDetail.getQuantity());
				} else {
					mp.put(orderDetail.getProductId(), orderDetail.getQuantity());
				}
			}
			size = Math.min(size, mp.size());
			List<Pair<Integer, Product>> sort_by_quantity = new ArrayList<>();
			for (Product it : mp.keySet()) {
				sort_by_quantity.add(new Pair<>(mp.get(it), it));
			}
			Collections.sort(sort_by_quantity, Comparator.comparing(e -> -e.left));
			List<Product> result = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				result.add(sort_by_quantity.get(i).right);
			}
			session.close();
			return result;
		}
	}

	@Override
	public List<Product> getTopItemByPtype(int Ptype) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Product> query = session.createQuery("FROM Product WHERE Ptype.Ptype = :Ptype", Product.class)
					.setParameter("Ptype", Ptype);
			List<Product> result = query.getResultList();
			Collections.sort(result, Comparator.comparing(ele -> -ele.getPrice()));
			session.close();
			return result.subList(0, Math.min(8, result.size()));
		}
	}
}
