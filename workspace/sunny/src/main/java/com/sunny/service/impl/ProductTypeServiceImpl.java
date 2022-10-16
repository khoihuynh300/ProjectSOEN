package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.ProductTypeDaoImpl;
import com.sunny.model.ProductType;
import com.sunny.service.IProductTypeService;

public class ProductTypeServiceImpl implements IProductTypeService{
	ProductTypeDaoImpl productTypeDaoImpl=new ProductTypeDaoImpl();

	@Override
	public ProductType AddProductType(ProductType productType) {
		// TODO Auto-generated method stub
		ProductTypeDaoImpl productTypeDaoImpl=new ProductTypeDaoImpl();
		
		return productTypeDaoImpl.AddProductType(productType);
	}

	@Override
	public void deleteProductType(int id) {
		// TODO Auto-generated method stub
		ProductTypeDaoImpl productTypeDaoImpl=new ProductTypeDaoImpl();
		productTypeDaoImpl.Delete(id);
	}

	@Override
	public List<ProductType> getAllProductTypes() {
		// TODO Auto-generated method stub
		return productTypeDaoImpl.getAllProductTypes();
	}

}
