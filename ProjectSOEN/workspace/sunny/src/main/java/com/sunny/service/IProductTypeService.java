package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductType;

public interface IProductTypeService {
	ProductType create(ProductType productType);

	List<ProductType> getAllProductType();
}
