package com.sunny.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.dao.IProductToAttributeDao;
import com.sunny.dao.impl.ProductToAttributeDaoImpl;
import com.sunny.model.ProductToAttribute;
import com.sunny.service.IProductToAttributeService;

@Service
public class ProductToAttributeServiceImpl implements IProductToAttributeService {
	private IProductToAttributeDao iProductToAttributeDao = new ProductToAttributeDaoImpl();

	@Override
	public ProductToAttribute addProductToAttribute(ProductToAttribute productToAttribute) throws Exception {
		// TODO Auto-generated method stub
		if (productToAttribute.getAtrId() != null) {
			return iProductToAttributeDao.addProductToAttribute(productToAttribute);
		} else {
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
