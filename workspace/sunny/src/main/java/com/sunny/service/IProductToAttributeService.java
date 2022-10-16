package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductToAttribute;

public interface IProductToAttributeService {
	ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute) throws Exception;
	void deleteProductToAttribute(int id);
	void editProductToAttribute(int AtrId);
	List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid);
}
