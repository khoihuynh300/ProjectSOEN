package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductAttribute;

public interface IProductAttributeService {
	ProductAttribute addProductAttribute(ProductAttribute productAttribute);

	List<ProductAttribute> getAllProductAttributes();

	void delete(int AtrId);
}
