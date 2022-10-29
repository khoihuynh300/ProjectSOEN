package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Product;
import com.sunny.service.IProductService;

@RestController
public class HomeController {
	@Autowired
	private IProductService productService;

	private static final int PAGE_SIZE = 10;

	@GetMapping(value = {"/home", ""})
	@Transactional
	public ResponseEntity<?> pagingProduct(@RequestParam(required = false, defaultValue = "1") Integer pageNumber, @RequestParam(required = false) Integer ptype) {
		List<Product> result = productService.getProducts(pageNumber.intValue(), PAGE_SIZE, ptype);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping(value = { "/product", "/product/search" })
	@ResponseBody
	public ResponseEntity<?> searchProductWithPtypeAndName(@RequestParam(required = false) Integer ptype,
			@RequestParam(required = false, defaultValue = "") String keyword, @RequestParam(defaultValue = "1") Integer pageNumber ) {
		List<Product> result = productService.searchProductWithPtypeAndName(keyword, ptype, pageNumber.intValue(), PAGE_SIZE);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
