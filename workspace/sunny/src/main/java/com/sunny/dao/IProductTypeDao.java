package com.sunny.dao;

import java.util.List;

import com.sunny.model.ProductType;

public interface IProductTypeDao {
	ProductType createProductType(ProductType productType);

	List<ProductType> getAllProductType();

	void updateProductType(ProductType productType);

	void deleteProductType(ProductType productType);

	ProductType getProductTypeById(int id);
}
