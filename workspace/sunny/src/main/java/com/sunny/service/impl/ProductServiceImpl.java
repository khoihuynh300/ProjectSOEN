package com.sunny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.dao.IProductDao;
import com.sunny.dao.impl.ProductDaoImpl;
import com.sunny.model.Product;
import com.sunny.service.IProductService;

public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao productDao = new ProductDaoImpl();

	@Override
	public Product createProduct(Product product) {
		return productDao.createProduct(product);
	}

	@Override
	public List<Product> getAllProductByPtype(int Ptype) {
		return productDao.getAllProductByPtype(Ptype);
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	public List<Product> getRecommendedProducts(int size) {
		return productDao.getRecommendedProducts(size);
	}

	@Override
	public List<Product> getTopItemByPtype(int Ptype) {
		return productDao.getTopItemByPtype(Ptype);
	}

}
