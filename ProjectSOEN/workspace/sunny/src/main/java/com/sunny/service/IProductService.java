package com.sunny.service;

import java.util.List;

import com.sunny.model.Product;

public interface IProductService {
	Product create(Product product);
	
	Product updateProduct(Product product);
	
	void deleteProduct(Product product);

	List<Product> getAllProduct();

	List<Product> searchProductWithPtypeAndName(String name, Integer ptype, int pageNumber, int pageSize);

	List<Product> getProducts(int pageNumber, int pageSize, Integer ptype);

	Product getProductById(int id);
}
