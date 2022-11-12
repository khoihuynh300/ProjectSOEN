package com.sunny.service;

import java.util.List;

import com.sunny.model.ProductToAttribute;
import com.sunny.service.impl.Result;

public interface IProductToAttributeService {
	Result addProductToAttribute(ProductToAttribute productToAttribute) throws Exception;

	Result deleteProductToAttribute(int id);

	Result updateProductToAttribute(ProductToAttribute productToAttribute);

	List<ProductToAttribute> getAllProducttoAttributebyPid(int Pid);

	ProductToAttribute getProductToAttributeById(int id);
}
