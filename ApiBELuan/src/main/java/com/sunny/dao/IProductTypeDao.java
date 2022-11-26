package com.sunny.dao;

import java.util.Date;
import java.util.List;

import com.sunny.model.ProductType;

public interface IProductTypeDao {
	ProductType createProductType(ProductType productType);

	List<ProductType> getAllProductType();

	void updateProductType(ProductType productType);

	void deleteProductType(ProductType productType);

	ProductType getProductTypeById(int id);

	double totalIncome();

	double totalIncomeinInterval(Date start, Date end);

	double incomeOfAProductType(int id);

	double incomeOfAProductTypeinInterval(int id, Date start, Date end);
}
