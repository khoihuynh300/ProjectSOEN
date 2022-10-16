package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.ProductType;
import com.sunny.service.impl.ProductTypeServiceImpl;

@RestController
public class ProductTypeAPI {
	ProductTypeServiceImpl productTypeServiceImpl = new ProductTypeServiceImpl();

	@PostMapping(value = { "/addProductType" })
	@ResponseBody
	public ProductType AddProductType(@RequestBody ProductType productType) {
		ProductTypeServiceImpl productTypeServiceImpl = new ProductTypeServiceImpl();
		return productTypeServiceImpl.AddProductType(productType);

	}
	
	@DeleteMapping("/deleteProductType")
	@Transactional
	public void DeleteProductType(@RequestBody ProductType productType) { 
		productTypeServiceImpl.deleteProductType(productType.getPtype());
	}
	
	@GetMapping("/getAllProductType")
	@ResponseBody
	public List<ProductType> getAllProductTypes(){
		return productTypeServiceImpl.getAllProductTypes();
		
	}

}
