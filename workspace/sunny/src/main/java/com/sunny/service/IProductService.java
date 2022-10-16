package com.sunny.service;

import java.util.List;

import com.sunny.model.Product;

public interface IProductService {
	Product AddProduct(Product product);
	void DeleteProduct(int Pid);
	void EditProduct(Product product) throws Exception;
	Product FindProduct(int Pid);
	List<Product> getAllProduct();
	List<Product> filterProductbyPtype(int Ptype);

}
