package com.sunny.dao;

import java.util.List;

import com.sunny.model.ProductAttribute;

public interface IProductAttributeDao {
	ProductAttribute addProductAttribute(ProductAttribute productAttribute);

	List<ProductAttribute> getAllProductAttributes();

	void delete(int AtrId);
}
