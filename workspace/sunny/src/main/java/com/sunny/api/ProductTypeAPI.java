package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.ProductType;
import com.sunny.service.impl.ProductTypeServiceImpl;

@RestController
public class ProductTypeAPI {
	ProductTypeServiceImpl productTypeServiceImpl = new ProductTypeServiceImpl();

	@PostMapping("/producttype")
	@Transactional
	public ProductType createProductType(@RequestBody ProductType productType) {
		return productTypeServiceImpl.create(productType);
	}

	@GetMapping("/producttype")
	@Transactional
	public ResponseEntity<?> getAllProductType() {
		List<ProductType> result = productTypeServiceImpl.getAllProductType();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
