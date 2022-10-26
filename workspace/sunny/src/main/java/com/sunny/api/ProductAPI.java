package com.sunny.api;

import java.util.List;

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

import com.sunny.model.Product;
import com.sunny.service.IProductService;
import com.sunny.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
//API for Admin
public class ProductAPI {
	private IProductService productService = new ProductServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer ptype) {
		return ptype == null ? ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct())
				: ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductByPtype(ptype.intValue()));
	}

	@PutMapping("/update")
	@Transactional
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}

	@DeleteMapping("/delete")
	@Transactional
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
	}

	@GetMapping("/recommended")
	@Transactional
	public List<Product> getRecommendedProducts(@RequestParam(required = true) Integer size) {
		return productService.getRecommendedProducts(size.intValue());
	}

	@GetMapping("/topitem")
	@Transactional
	public List<Product> getTopItemByPtype(@RequestParam(required = true) Integer ptype) {
		return productService.getTopItemByPtype(ptype.intValue());
	}
}
