package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Product;
import com.sunny.service.impl.ProductServiceImpl;

@RestController
//API for Admin
public class ProductAPI {
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();

	@PostMapping("/product")
	@Transactional
	public Product createProduct(@RequestBody Product product) {
		return productServiceImpl.createProduct(product);
	}

	@GetMapping("/product")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer ptype) {
		return ptype == null ? ResponseEntity.status(HttpStatus.OK).body(productServiceImpl.getAllProduct())
				: ResponseEntity.status(HttpStatus.OK).body(productServiceImpl.getAllProductByPtype(ptype.intValue()));
	}

	@PutMapping("/product")
	@Transactional
	public void updateProduct(@RequestBody Product product) {
		productServiceImpl.updateProduct(product);
	}

	@DeleteMapping("/product")
	@Transactional
	public void deleteProduct(@RequestBody Product product) {
		productServiceImpl.deleteProduct(product);
	}
}
