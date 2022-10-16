package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Product;
import com.sunny.service.impl.ProductServiceImpl;

@RestController
public class ProductAPI {
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();

	@PostMapping("/product")
	@Transactional
	public Product createProduct(@RequestBody Product product) {
		return productServiceImpl.create(product);
	}

	@GetMapping("/product")
	@Transactional
	public ResponseEntity<?> getAllProduct() {
		List<Product> result = productServiceImpl.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
