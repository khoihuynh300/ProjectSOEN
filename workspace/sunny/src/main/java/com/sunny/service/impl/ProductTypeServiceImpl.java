package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductTypeDao;
import com.sunny.dao.impl.ProductTypeDaoImpl;
import com.sunny.model.ProductType;
import com.sunny.service.IProductTypeService;

public class ProductTypeServiceImpl implements IProductTypeService {

	private IProductTypeDao productTypeDao = new ProductTypeDaoImpl();

	@Override
	public Result createProductType(ProductType productType) {
		productTypeDao.createProductType(productType);
		return new Result(true, "Create ProductType successfully!!!");
	}

	@Override
	public List<ProductType> getAllProductType() {
		return productTypeDao.getAllProductType();
	}

	@Override
	public Result updateProductType(ProductType productType) {
		productTypeDao.updateProductType(productType);
		return new Result(true, "Update ProductType successfully!!!");
	}

	@Override
	public Result deleteProductType(ProductType productType) {
		productTypeDao.deleteProductType(productType);
		return new Result(true, "Delete ProductType successfully!!!");
	}

	@Override
	public ProductType getProductTypeById(int id) {
		return productTypeDao.getProductTypeById(id);
	}

}
