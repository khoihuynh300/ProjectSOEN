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
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public List<Product> searchProductWithPtypeAndName(String name, Integer ptype) {
		List<Product> result = productDao.searchProductWithPtypeAndName(name, ptype);
		return result;
	}

	@Override
	public List<Product> getProducts(int pageNumber, int pageSize) {
		return productDao.getRecords(pageNumber, pageSize);
	}

}
