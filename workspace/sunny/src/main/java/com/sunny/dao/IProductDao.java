package com.sunny.dao;

import java.util.List;

import com.sunny.model.Product;

public interface IProductDao {
	Product createProduct(Product product);

	List<Product> getAllProductByPtype(int Ptype);

	List<Product> getAllProduct();

	void updateProduct(Product product);

	void deleteProduct(Product product);

	Product getProductById(int id);

	List<Product> getRecommendedProducts(int size);

	List<Product> getTopItemByPtype(int Ptype);
}
