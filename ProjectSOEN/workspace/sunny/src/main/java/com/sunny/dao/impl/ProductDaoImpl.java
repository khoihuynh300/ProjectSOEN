package com.sunny.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sunny.connections.HibernateUtil;
import com.sunny.dao.IProductDao;
import com.sunny.model.Image;
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
}
