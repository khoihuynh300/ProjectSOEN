package com.sunny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.dao.impl.ProductDaoImpl;
import com.sunny.model.Product;
import com.sunny.service.IProductService;

public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	@Override
	public Product create(Product product) {
		return productDaoImpl.create(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDaoImpl.getAllProduct();
	}

	@Override
	public Product getProductById(int id) {
		return productDaoImpl.getProductById(id);
	}

}
