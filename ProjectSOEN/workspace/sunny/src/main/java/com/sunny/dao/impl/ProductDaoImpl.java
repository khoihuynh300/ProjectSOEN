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
import org.springframework.stereotype.Repository;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;
import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductDao;
import com.sunny.model.OrderDetail;
import com.sunny.model.Orders;
import com.sunny.model.Product;

@Repository
public class ProductDaoImpl implements IProductDao {

	@Override
	public Product create(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(product);
			t.commit();
			session.close();
			return product;
		}
	}

	@Override
	public List<Product> getAllProduct(int pageNumber, int pageSize) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<Product> query = session.createQuery("From Product", Product.class);
			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
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
	public List<Product> searchProductWithPtypeAndName(String name, Integer ptype, int pageNumber, int pageSize) {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			List<Product> result = new ArrayList<>();
			if (name == null) {
				Query<Product> query = session
						.createNativeQuery("Select * from Product where Ptype =:ptype LIMIT :pageNumber, :pageSize",
								Product.class)
						.setParameter("pageNumber", (pageNumber - 1) * pageSize).setParameter("pageSize", pageSize)
						.setParameter("ptype", ptype.intValue());
				result = query.getResultList();
			} else if (ptype == null) {
				Query<Product> query = session
						.createNativeQuery("Select * From Product where Pname like :name LIMIT :pageNumber, :pageSize",
								Product.class)
						.setParameter("pageNumber", (pageNumber - 1) * pageSize).setParameter("pageSize", pageSize)
						.setParameter("name", "%" + name + "%");
				result = query.getResultList();
			} else {
				Query<Product> query = session.createNativeQuery(
						"Select * from Product where Ptype =:ptype and Pname like :name LIMIT :pageNumber, :pageSize",
						Product.class).setParameter("pageNumber", (pageNumber - 1) * pageSize)
						.setParameter("pageSize", pageSize).setParameter("ptype", ptype.intValue())
						.setParameter("name", "%" + name + "%");
				result = query.getResultList();
			}
			t.commit();
			return result;
		}
	}
	
	@Override
	public List<Product> getProductByPrice(Double start, Double end){
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			List<Product> result = new ArrayList<>();
			if (start != null && end == null) {
				Query<Product> query = session
						.createQuery("From Product p WHERE p.Price >= :start ORDER BY p.Price",
								Product.class)
						.setParameter("start", start.doubleValue());
				result = query.getResultList();
			} else if (start == null && end != null) {
				Query<Product> query = session
						.createQuery("From Product p WHERE p.Price <= :end ORDER BY p.Price DESC",
								Product.class)
						.setParameter("end", end.doubleValue());
				result = query.getResultList();
			} else if (start != null && end != null) {
				Query<Product> query = session
						.createQuery("FROM Product p WHERE p.Price BETWEEN :start AND :end ORDER BY p.Price",
								Product.class)
						.setParameter("start", start.doubleValue())
						.setParameter("end", end.doubleValue());
				result = query.getResultList();
			}
			t.commit();
			return result;
		}
	}

	@Override
	public List<Product> getRecords(int pageNumber, int pageSize, Integer ptype) {
		List<Product> result = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (ptype != null) {
				Query<Product> query = session.createNativeQuery(
						"SELECT * FROM Product WHERE isDeleted = 0 and Ptype=:ptype ORDER BY Pid LIMIT :pageNumber, :pageSize",
						Product.class).setParameter("pageNumber", (pageNumber - 1) * pageSize)
						.setParameter("pageSize", pageSize).setParameter("ptype", ptype.intValue());
				result = query.getResultList();
			} else {
				Query<Product> query = session
						.createNativeQuery(
								"SELECT * FROM Product WHERE isDeleted = 0 ORDER BY Pid LIMIT :pageNumber, :pageSize",
								Product.class)
						.setParameter("pageNumber", (pageNumber - 1) * pageSize).setParameter("pageSize", pageSize);
				result = query.getResultList();
			}
			t.commit();
			return result;
		}
	}

	@Override
	public Product updateProduct(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();

			session.createNativeQuery(
					"update Product set Ptype=:ptype, Pname=:pname, Image=:image, Pin=:pin, Waranty=:waranty, Quantity=:quantity, "
							+ "Price=:price, Description=:description, isDeleted=:isDeleted, DiscountId=:discountId"
							+ " where Pid=:pid",
					Product.class).setParameter("ptype", product.getPtype().getPtype())
					.setParameter("pname", product.getPname()).setParameter("price", product.getPrice())
					.setParameter("description", product.getDescription())
					.setParameter("quantity", product.getQuantity()).setParameter("isDeleted", product.isDeleted())
					.setParameter("discountId", product.getDiscountId()).setParameter("pid", product.getPid())
					.setParameter("image", product.getImage().getId()).setParameter("pin", product.isPin())
					.setParameter("waranty", product.getWaranty());
			session.update(product);
			t.commit();
			return product;
		}
	}

	@Override
	public void deletedProduct(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			product.setDeleted(true);
			session.update(product);
			t.commit();
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
//			Query<Product> query = session
//					.createQuery("FROM Product WHERE Ptype.Ptype = :Ptype ORDER BY Price DESC LIMIT 8", Product.class)
//					.setParameter("Ptype", Ptype);
			Query<Product> query = session
					.createNativeQuery("SELECT * FROM Product WHERE Ptype = :Ptype ORDER BY Price DESC LIMIT 8",
							Product.class)
					.setParameter("Ptype", Ptype);
			List<Product> result = query.getResultList();
			session.close();
			return result;
		}
	}
}
