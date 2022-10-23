package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Product;
import com.sunny.service.IProductService;

@RestController
public class ProductAPI {
	@Autowired
	IProductService productService;

	@PostMapping("/product")
	@Transactional
	public Product createProduct(@RequestBody Product product) {
		return productService.create(product);
	}

//	@GetMapping("/product")
//	@Transactional
//	public ResponseEntity<?> getAllProduct() {
//		List<Product> result = productService.getAllProduct();
//		return ResponseEntity.status(HttpStatus.OK).body(result);
//	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/product")
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
	}

	@GetMapping(value = {"/product", "/product/search"})
	@ResponseBody
	public ResponseEntity<?> searchProductWithPtypeAndName(@RequestParam(required = false) Integer ptype,
			@RequestParam(required = false, defaultValue = "") String keyword) {
		List<Product> result = productService.searchProductWithPtypeAndName(keyword, ptype);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
