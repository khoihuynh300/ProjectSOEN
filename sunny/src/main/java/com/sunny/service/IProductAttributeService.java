package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductAttribute;
import com.sunny.model.ProductToAttribute;

public interface IProductAttributeService {
	ProductAttribute addProductAttribute(ProductAttribute productAttribute);
	List<ProductAttribute> getAllProductAttributes();
	void delete(int AtrId);

}
