package com.sunny.dao;

import java.util.List;

import com.sunny.model.ProductType;

public interface IProductTypeDao {
	ProductType create(ProductType productType);

	List<ProductType> getAllProductType();
}
