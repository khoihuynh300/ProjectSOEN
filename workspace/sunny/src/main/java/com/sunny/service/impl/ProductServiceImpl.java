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
	public Product createProduct(Product product) {
		return productDaoImpl.createProduct(product);
	}

	@Override
	public List<Product> getAllProductByPtype(int Ptype) {
		return productDaoImpl.getAllProductByPtype(Ptype);
	}

	@Override
	public Product getProductById(int id) {
		return productDaoImpl.getProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDaoImpl.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productDaoImpl.deleteProduct(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDaoImpl.getAllProduct();
	}

	@Override
	public List<Product> getRecommendedProducts(int size) {
		return productDaoImpl.getRecommendedProducts(size);
	}

	@Override
	public List<Product> getTopItemByPtype(int Ptype) {
		return productDaoImpl.getTopItemByPtype(Ptype);
	}

}
