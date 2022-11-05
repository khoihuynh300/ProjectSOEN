package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductAttribute;
import com.sunny.service.impl.Result;

public interface IProductAttributeService {
	Result addProductAttribute(ProductAttribute productAttribute);

	List<ProductAttribute> getAllProductAttributes();

	Result delete(int AtrId);

	ProductAttribute getProductAttributeById(int id);
}
