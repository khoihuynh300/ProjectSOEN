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
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/productAttribute")
public class ProductAttributeAPI {
	private IProductAttributeService productAttributeService = new ProductAttributeServiceImpl();

	@PostMapping("/add")
	@ResponseBody
	public Result addProductAttribute(@RequestBody ProductAttribute productAttribute) {
		return productAttributeService.addProductAttribute(productAttribute);
	}

	@GetMapping("/get")
	@ResponseBody
	public List<ProductAttribute> getAllProductAttribute() {
		return productAttributeService.getAllProductAttributes();
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public Result deleteProductAttribute(@RequestBody ProductAttribute productAttribute) {
		return productAttributeService.delete(productAttribute.getAtrId());
	}

}