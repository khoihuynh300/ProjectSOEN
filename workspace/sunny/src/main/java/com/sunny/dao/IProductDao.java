package com.sunny.dao;

import java.util.List;

import com.sunny.model.Product;

public interface IProductDao {
	Product create(Product product);

	List<Product> getAllProduct();

	Product getProductById(int id);
}
