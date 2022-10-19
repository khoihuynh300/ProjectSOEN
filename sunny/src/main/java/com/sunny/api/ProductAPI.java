package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Product;
import com.sunny.service.IProductService;
import com.sunny.service.impl.ProductServiceImpl;

@RestController
public class ProductAPI {
	IProductService productService = new ProductServiceImpl();

	@PostMapping("/product")
	@Transactional
	public Product createProduct(@RequestBody Product product) {
		return productService.create(product);
	}

	@GetMapping("/product")
	@Transactional
	public ResponseEntity<?> getAllProduct() {
		List<Product> result = productService.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/product/search")
	@ResponseBody
	public ResponseEntity<?> searchProductWithPtypeAndName(@RequestParam(required = false) Integer ptype,
			@RequestParam(required = false, defaultValue = "") String keyword) {
		List<Product> result = productService.searchProductWithPtypeAndName(keyword, ptype);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
