package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductToAttributeDao;
import com.sunny.dao.impl.ProductToAttributeImpl;
import com.sunny.model.ProductToAttribute;
import com.sunny.service.IProductToAttributeService;

public class ProductToAttributeServiceImpl implements IProductToAttributeService {
	private IProductToAttributeDao productToAttributeDao = new ProductToAttributeImpl();

	@Override
	public ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute) throws Exception {
		return productToAttributeDao.addProductToAttribute(productToAttribute);
	}

	@Override
	public void deleteProductToAttribute(int id) {
		productToAttributeDao.deleteProductToAttribute(id);
	}

	@Override
	public void editProductToAttribute(int AtrId) {
		productToAttributeDao.editProductToAttribute(AtrId);
	}

	@Override
	public List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid) {
		return productToAttributeDao.getAllProducttoAttributebyPid(Pid);
	}

}