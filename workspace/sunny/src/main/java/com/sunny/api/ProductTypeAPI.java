package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.ProductType;
import com.sunny.service.impl.ProductTypeServiceImpl;

@RestController
@RequestMapping("/producttype")
public class ProductTypeAPI {
	ProductTypeServiceImpl productTypeServiceImpl = new ProductTypeServiceImpl();

	@PostMapping("/create")
	@Transactional
	public ProductType createProductType(@RequestBody ProductType productType) {
		return productTypeServiceImpl.createProductType(productType);
	}

	@GetMapping("/get-all-producttype")
	@Transactional
	public ResponseEntity<?> getAllProductType(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(productTypeServiceImpl.getAllProductType())
				: ResponseEntity.status(HttpStatus.OK).body(productTypeServiceImpl.getProductTypeById(id.intValue()));
	}

	@DeleteMapping("/delete")
	@Transactional
	public void deleteProductType(@RequestBody ProductType productType) {
		productTypeServiceImpl.deleteProductType(productType);
	}

	@PutMapping("/update")
	@Transactional
	public void updateProductType(@RequestBody ProductType productType) {
		productTypeServiceImpl.updateProductType(productType);
	}

}
