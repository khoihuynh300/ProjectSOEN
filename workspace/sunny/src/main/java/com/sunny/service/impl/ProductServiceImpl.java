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
	public Result createProduct(Product product) {
		productDao.createProduct(product);
		return new Result(true, "Create Product successfully!!!");
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
	public Result updateProduct(Product product) {
		productDao.updateProduct(product);
		return new Result(true, "Update Product successfully!!!");
	}

	@Override
	public Result deleteProduct(Product product) {
		productDao.deleteProduct(product);
		return new Result(true, "Delete Product successfully!!!");
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	public List<Product> getRecommendedProducts(int ptype, int size) {
		return productDao.getRecommendedProducts(ptype, size);
	}

	@Override
	public List<Product> getTopItemByPtype(int Ptype) {
		return productDao.getTopItemByPtype(Ptype);
	}

}
