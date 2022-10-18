package com.sunny.dao;

import java.util.List;

import com.sunny.model.Product;

public interface IProductDao {
	Product create(Product product);

	List<Product> getAllProduct();

	List<Product> searchProductWithPtypeAndName(String name, Integer ptype);

	List<Product> getRecords(int start, int total);

	Product getProductById(int id);
}
