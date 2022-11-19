package com.sunny.service;

import java.util.Date;
import java.util.List;

import com.sunny.model.ProductType;
import com.sunny.service.impl.Result;

public interface IProductTypeService {
	Result createProductType(ProductType productType);

	List<ProductType> getAllProductType();

	Result updateProductType(ProductType productType);

	Result deleteProductType(ProductType productType);

	ProductType getProductTypeById(int id);

	double totalIncome();

	double totalIncomeinInterval(Date start, Date end);

	double incomeOfAProductType(int id);

	double incomeOfAProductTypeinInterval(int id, Date start, Date end);
}
