package com.sunny.dao;

import java.util.List;

import com.sunny.model.Product;

public interface IProductDao {
	Product create(Product product);

	List<Product> getAllProduct(int pageNumber, int pageSize);

	List<Product> searchProductWithPtypeAndName(String name, Integer ptype, int pageNumber, int pageSize);

	Product updateProduct(Product product);
	
	void deletedProduct(Product product);
	
	List<Product> getRecords(int start, int total, Integer ptype);

	Product getProductById(int id);
}
