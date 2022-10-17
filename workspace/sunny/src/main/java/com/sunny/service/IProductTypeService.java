package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductType;

public interface IProductTypeService {
	ProductType createProductType(ProductType productType);

	List<ProductType> getAllProductType();

	void updateProductType(ProductType productType);

	void deleteProductType(ProductType productType);

	ProductType getProductTypeById(int id);
}
