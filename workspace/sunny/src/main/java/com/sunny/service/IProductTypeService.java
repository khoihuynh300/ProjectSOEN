package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductType;

public interface IProductTypeService {
	ProductType AddProductType(ProductType productType);
	void deleteProductType(int id);
	List<ProductType> getAllProductTypes();
}
