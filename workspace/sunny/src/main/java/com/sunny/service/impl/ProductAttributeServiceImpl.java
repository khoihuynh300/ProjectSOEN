package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductAttributeDao;
import com.sunny.dao.impl.ProductAttributeDaoImpl;
import com.sunny.model.ProductAttribute;
import com.sunny.model.ProductToAttribute;
import com.sunny.service.IProductAttributeService;

public class ProductAttributeServiceImpl implements IProductAttributeService{
	private IProductAttributeDao iProductAttribute= new ProductAttributeDaoImpl();

	@Override
	public ProductAttribute addProductAttribute(ProductAttribute productAttribute) {
		// TODO Auto-generated method stub
		return iProductAttribute.addProductAttribute(productAttribute);
	}

	@Override
	public List<ProductAttribute> getAllProductAttributes() {
		// TODO Auto-generated method stub
		return iProductAttribute.getAllProductAttributes();
	}

	@Override
	public void delete(int AtrId) {
		// TODO Auto-generated method stub
		iProductAttribute.delete(AtrId);
		
	}



}
