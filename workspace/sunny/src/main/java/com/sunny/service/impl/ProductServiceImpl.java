package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.ProductDaoImpl;
import com.sunny.model.Product;
import com.sunny.service.IProductService;

public class ProductServiceImpl implements IProductService{
	private ProductDaoImpl productDaoImpl=new ProductDaoImpl();

	@Override
	public Product AddProduct(Product product) {
		// TODO Auto-generated method stub
		return productDaoImpl.AddProduct(product);
	}

	@Override
	public void DeleteProduct(int Pid) {
		// TODO Auto-generated method stub
		productDaoImpl.DeleteProduct(Pid);
	}

	@Override
	public void EditProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		Product updateProduct=productDaoImpl.FindProduct(product.getPid());
		if(updateProduct!=null) {		
			updateProduct.setPname(product.getPname());
			updateProduct.setDiscountId(product.getDiscountId());
			updateProduct.setDescription(product.getDescription());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setPtype(product.getPtype());	
			productDaoImpl.EditProduct(updateProduct);
		}else {
			throw new Exception("Product does not exist!");
		}
		
	}

	@Override
	public Product FindProduct(int Pid) {
		// TODO Auto-generated method stub
		return productDaoImpl.FindProduct(Pid);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDaoImpl.getAllProduct();
	}

	@Override
	public List<Product> filterProductbyPtype(int Ptype) {
		// TODO Auto-generated method stub
		return productDaoImpl.filterProductbyPtype(Ptype);
	}

}
