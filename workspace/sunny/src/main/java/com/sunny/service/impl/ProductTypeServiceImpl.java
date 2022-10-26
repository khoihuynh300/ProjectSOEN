package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductTypeDao;
import com.sunny.dao.impl.ProductTypeDaoImpl;
import com.sunny.model.ProductType;
import com.sunny.service.IProductTypeService;

public class ProductTypeServiceImpl implements IProductTypeService {

	private IProductTypeDao productTypeDao = new ProductTypeDaoImpl();

	@Override
	public ProductType createProductType(ProductType productType) {
		return productTypeDao.createProductType(productType);
	}

	@Override
	public List<ProductType> getAllProductType() {
		return productTypeDao.getAllProductType();
	}

	@Override
	public void updateProductType(ProductType productType) {
		productTypeDao.updateProductType(productType);
	}

	@Override
	public void deleteProductType(ProductType productType) {
		productTypeDao.deleteProductType(productType);
	}

	@Override
	public ProductType getProductTypeById(int id) {
		return productTypeDao.getProductTypeById(id);
	}

}
