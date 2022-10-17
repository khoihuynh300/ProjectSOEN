package com.sunny.dao;

import java.util.List;

import com.sunny.model.ProductToAttribute;

public interface IProductToAttributeDao {
	ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute);

	void deleteProductToAttribute(int id);

	void editProductToAttribute(int AtrId);

	List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid);

}
