package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.ProductTypeDaoImpl;
import com.sunny.model.ProductType;
import com.sunny.service.IProductTypeService;

public class ProductTypeServiceImpl implements IProductTypeService {

	@Override
	public ProductType create(ProductType productType) {
		ProductTypeDaoImpl productTypeDaoImpl = new ProductTypeDaoImpl();
		return productTypeDaoImpl.create(productType);
	}

	@Override
	public List<ProductType> getAllProductType() {
		ProductTypeDaoImpl productTypeDaoImpl = new ProductTypeDaoImpl();
		return productTypeDaoImpl.getAllProductType();
	}

}
