package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductAttributeDao;
import com.sunny.dao.impl.ProductAttributeDaoImpl;
import com.sunny.model.ProductAttribute;
import com.sunny.service.IProductAttributeService;

public class ProductAttributeServiceImpl implements IProductAttributeService {
	private IProductAttributeDao ProductAttributeDao = new ProductAttributeDaoImpl();

	@Override
	public Result addProductAttribute(ProductAttribute productAttribute) {
		ProductAttributeDao.addProductAttribute(productAttribute);
		return new Result(true, "Create ProductAttribute successfully!!!");
	}

	@Override
	public List<ProductAttribute> getAllProductAttributes() {
		return ProductAttributeDao.getAllProductAttributes();
	}

	@Override
	public Result delete(int AtrId) {
		ProductAttributeDao.delete(AtrId);
		return new Result(true, "Delete ProductAttribute successfully!!!");
	}

	@Override
	public ProductAttribute getProductAttributeById(int id) {
		return ProductAttributeDao.getProductAttributeById(id);
	}

}