package com.sunny.service;

import java.util.List;

import com.sunny.model.Product;
import com.sunny.service.impl.Result;

public interface IProductService {
	Result createProduct(Product product);

	List<Product> getAllProductByPtype(int Ptype);

	List<Product> getAllProduct();

	Result updateProduct(Product product);

	Result deleteProduct(Product product);

	Product getProductById(int id);

	List<Product> getRecommendedProducts(int size);

	List<Product> getTopItemByPtype(int Ptype);
}
