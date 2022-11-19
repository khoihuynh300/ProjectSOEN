package com.sunny.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductTypeDao;
import com.sunny.model.Orders;
import com.sunny.model.Product;
import com.sunny.model.ProductType;

public class ProductTypeDaoImpl implements IProductTypeDao {

	@Override
	public ProductType createProductType(ProductType productType) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			session.save(productType);
			t.commit();
			session.close();
			return productType;
		}
	}

	@Override
	public List<ProductType> getAllProductType() {
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();
			Query<ProductType> query = session.createQuery("From ProductType", ProductType.class);
			List<ProductType> result = query.getResultList();
			t.commit();
			return result;
		}
	}

	@Override
	public void updateProductType(ProductType productType) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(productType);
			transaction.commit();
			session.close();
		}
	}

	@Override
	public void deleteProductType(ProductType productType) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			ProductType productTypeRes = getProductTypeById(productType.getPtype());
			productTypeRes.setDeleted(true);
			session.update(productTypeRes);
			t.commit();
			session.close();
		}
	}

	@Override
	public ProductType getProductTypeById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(ProductType.class, id);
		}
	}

	@Override
	public double totalIncome() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			double result;
			try {
				result = (double) session
						.createNativeQuery(
								"SELECT sum(price * quantity) - sum(discount) FROM orderdetail WHERE status = 6")
						.getSingleResult();
				session.close();
			} catch (NullPointerException ex) {
				session.close();
				return 0;
			}
			return result;
		}
	}

	@Override
	public double totalIncomeinInterval(Date start, Date end) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Orders> listOrders = session
					.createQuery("FROM Orders AS c WHERE c.OrderDate BETWEEN :startDate AND :endDate", Orders.class)
					.setParameter("startDate", start).setParameter("endDate", end).getResultList();
			if (listOrders.isEmpty())
				return 0;
			double result;
			try {
				result = (double) session.createNativeQuery(
						"SELECT sum(price * quantity) - sum(discount) FROM orderdetail WHERE status = 6 AND OrderId IN (:list)")
						.setParameter("list", listOrders).getSingleResult();
				session.close();
			} catch (NullPointerException ex) {
				session.close();
				return 0;
			}
			return result;
		}
	}

	@Override
	public double incomeOfAProductType(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			double result;
			List<Product> listProduct = session.createQuery("FROM Product WHERE Ptype.Ptype = :id", Product.class)
					.setParameter("id", id).getResultList();
			if (listProduct.isEmpty())
				return 0;
			List<Integer> listProductId = new ArrayList<>();
			for (Product product : listProduct) {
				listProductId.add(product.getPid());
			}
			try {
				result = (double) session.createNativeQuery(
						"SELECT sum(price * quantity) - sum(discount) FROM orderdetail WHERE status = 6 AND Pid IN (:list)")
						.setParameter("list", listProductId).getSingleResult();
				session.close();
			} catch (NullPointerException ex) {
				session.close();
				return 0;
			}
			return result;
		}
	}

	@Override
	public double incomeOfAProductTypeinInterval(int id, Date start, Date end) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			double result;
			List<Product> listProduct = session.createQuery("FROM Product WHERE Ptype.Ptype = :id", Product.class)
					.setParameter("id", id).getResultList();
			if (listProduct.isEmpty())
				return 0;
			List<Integer> listProductId = new ArrayList<>();
			for (Product product : listProduct) {
				listProductId.add(product.getPid());
			}
			List<Orders> listOrders = session
					.createQuery("FROM Orders AS c WHERE c.OrderDate BETWEEN :startDate AND :endDate", Orders.class)
					.setParameter("startDate", start).setParameter("endDate", end).getResultList();
			if (listOrders.isEmpty())
				return 0;
			try {
				result = (double) session.createNativeQuery(
						"SELECT sum(price * quantity) - sum(discount) FROM orderdetail WHERE status = 6 AND Pid IN (:list) AND OrderId IN (:listOrder)")
						.setParameter("list", listProductId).setParameter("listOrder", listOrders).getSingleResult();
				session.close();
			} catch (NullPointerException ex) {
				session.close();
				return 0;
			}
			return result;
		}
	}

}
