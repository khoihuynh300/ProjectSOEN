package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.ProductTypeDaoImpl;
import com.sunny.model.ProductType;
import com.sunny.service.IProductTypeService;

public class ProductTypeServiceImpl implements IProductTypeService {

	ProductTypeDaoImpl productTypeDaoImpl = new ProductTypeDaoImpl();

	@Override
	public ProductType createProductType(ProductType productType) {
		return productTypeDaoImpl.createProductType(productType);
	}

	@Override
	public List<ProductType> getAllProductType() {
		return productTypeDaoImpl.getAllProductType();
	}

	@Override
	public void updateProductType(ProductType productType) {
		productTypeDaoImpl.updateProductType(productType);
	}

	@Override
	public void deleteProductType(ProductType productType) {
		productTypeDaoImpl.deleteProductType(productType);
	}

	@Override
	public ProductType getProductTypeById(int id) {
		return productTypeDaoImpl.getProductTypeById(id);
	}

}
