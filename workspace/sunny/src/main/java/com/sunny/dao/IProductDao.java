package com.sunny.dao;

import com.sunny.model.Product;
import java.util.List;


public interface IProductDao {
	Product AddProduct(Product product);
	void DeleteProduct(int Pid);
	void EditProduct(Product product);
	Product FindProduct(int Pid);
	List<Product> getAllProduct();
	List<Product> filterProductbyPtype(int Ptype);
	

}
