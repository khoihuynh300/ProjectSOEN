package com.sunny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunny.dao.IProductDao;
import com.sunny.dao.impl.ProductDaoImpl;
import com.sunny.model.Product;
import com.sunny.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductDao productDao = new ProductDaoImpl();

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public List<Product> getAllProduct(int pageNumber, int pageSize) {
		return productDao.getAllProduct(pageNumber, pageSize);
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public List<Product> searchProductWithPtypeAndName(String name, Integer ptype, int pageNumber, int pageSize) {
		List<Product> result = productDao.searchProductWithPtypeAndName(name, ptype, pageNumber, pageSize);
		return result;
	}
	
	@Override
	public List<Product> getProductByPrice(Double start, Double end) {
		List<Product> result = productDao.getProductByPrice(start, end);
		return result;
	}

	@Override
	public List<Product> getProducts(int pageNumber, int pageSize, Integer ptype) {
		return productDao.getRecords(pageNumber, pageSize, ptype);
	}

	@Override
	public Product updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.deletedProduct(product);
	}

	@Override
	public List<Product> getRecommendedProducts(int ptype, int size) {
		return productDao.getRecommendedProducts(ptype, size);
	}

	@Override
	public List<Product> getTopItemByPtype(int Ptype) {
		return productDao.getTopItemByPtype(Ptype);
	}
	
	public List<Product> getAllProductByPtype(int Ptype, int pageNumber, int pageSize) {
		return productDao.getAllProductByPtype(Ptype,pageNumber,pageSize);
	}
}
