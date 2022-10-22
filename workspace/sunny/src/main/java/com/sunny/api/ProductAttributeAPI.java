package com.sunny.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.ProductAttribute;
import com.sunny.service.IProductAttributeService;
import com.sunny.service.impl.ProductAttributeServiceImpl;

@RestController
@RequestMapping("/productAttribute")
public class ProductAttributeAPI {
	private IProductAttributeService iProductAttributeService = new ProductAttributeServiceImpl();

	@PostMapping("/addProductAttribute")
	@ResponseBody
	public ProductAttribute addProductAttribute(@RequestBody ProductAttribute productAttribute) {
		return iProductAttributeService.addProductAttribute(productAttribute);
	}

	@GetMapping("/getAllProductAttribute")
	@ResponseBody
	public List<ProductAttribute> getAllProductAttribute() {
		return iProductAttributeService.getAllProductAttributes();
	}

	@DeleteMapping("/deleteProductAttribute")
	@ResponseBody
	public void deleteProductAttribute(@RequestBody ProductAttribute productAttribute) {
		iProductAttributeService.delete(productAttribute.getAtrId());
	}

}