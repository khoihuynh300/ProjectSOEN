package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IProductToAttributeDao;
import com.sunny.dao.impl.ProductToAttributeImpl;
import com.sunny.model.ProductToAttribute;
import com.sunny.service.IProductToAttributeService;

public class ProductToAttributeServiceImpl implements IProductToAttributeService{
	private IProductToAttributeDao iProductToAttributeDao=new ProductToAttributeImpl();

	@Override
	public ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute) throws Exception {
		// TODO Auto-generated method stub
		if( productToAttribute.getAtrId()!=null ) {
			return iProductToAttributeDao.addProductToAttribute(productToAttribute);
		}else {
			throw new Exception("Er");
		}
		
	}

	@Override
	public void deleteProductToAttribute(int id) {
		// TODO Auto-generated method stub
		iProductToAttributeDao.deleteProductToAttribute(id);
	}

	@Override
	public void editProductToAttribute(int AtrId) {
		// TODO Auto-generated method stub
		iProductToAttributeDao.editProductToAttribute(AtrId);
	}

	@Override
	public List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid) {
		// TODO Auto-generated method stub
		return iProductToAttributeDao.getAllProducttoAttributebyPid(Pid);
	}


	
}
