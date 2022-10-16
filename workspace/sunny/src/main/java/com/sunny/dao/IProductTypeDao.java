package com.sunny.dao;

import java.util.List;

import com.sunny.model.ProductType;

public interface IProductTypeDao {
	ProductType AddProductType(ProductType productType);
	void Delete (int id);
	List<ProductType> getAllProductTypes();
}
