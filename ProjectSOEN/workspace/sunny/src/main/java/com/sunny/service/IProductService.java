package com.sunny.service;

import java.util.List;

import com.sunny.model.Product;

public interface IProductService {
	Product create(Product product);

	List<Product> getAllProduct();

	List<Product> searchProductWithPtypeAndName(String name, Integer ptype);

	List<Product> getProducts(int pageNumber, int pageSize);

	Product getProductById(int id);
}
