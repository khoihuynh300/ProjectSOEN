package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductAttributeDao;
import com.sunny.dao.impl.ProductAttributeDaoImpl;
import com.sunny.model.ProductAttribute;
import com.sunny.service.IProductAttributeService;

public class ProductAttributeServiceImpl implements IProductAttributeService {
	private IProductAttributeDao ProductAttributeDao = new ProductAttributeDaoImpl();

	@Override
	public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
		return ProductAttributeDao.addProductAttribute(productAttribute);
	}

	@Override
	public List<ProductAttribute> getAllProductAttributes() {
		return ProductAttributeDao.getAllProductAttributes();
	}

	@Override
	public void delete(int AtrId) {
		ProductAttributeDao.delete(AtrId);

	}

}