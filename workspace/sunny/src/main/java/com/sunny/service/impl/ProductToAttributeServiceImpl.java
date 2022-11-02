package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductToAttributeDao;
import com.sunny.dao.impl.ProductToAttributeImpl;
import com.sunny.model.ProductToAttribute;
import com.sunny.service.IProductToAttributeService;

public class ProductToAttributeServiceImpl implements IProductToAttributeService {
	private IProductToAttributeDao productToAttributeDao = new ProductToAttributeImpl();

	@Override
	public Result addProductToAttribute(ProductToAttribute productToAttribute) throws Exception {
		productToAttributeDao.addProductToAttribute(productToAttribute);
		return new Result(true, "Create ProductToAttribute successfully!!!");
	}

	@Override
	public Result deleteProductToAttribute(int id) {
		productToAttributeDao.deleteProductToAttribute(id);
		return new Result(true, "Delete ProductToAttribute successfully!!!");
	}

	@Override
	public Result editProductToAttribute(int AtrId) {
		productToAttributeDao.editProductToAttribute(AtrId);
		return new Result(true, "Update ProductToAttribute successfully!!!");
	}

	@Override
	public List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid) {
		return productToAttributeDao.getAllProducttoAttributebyPid(Pid);
	}

}