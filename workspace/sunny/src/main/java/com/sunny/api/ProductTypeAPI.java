package com.sunny.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.sunny.service.IProductTypeService;
import com.sunny.service.impl.ProductTypeServiceImpl;
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/producttype")
public class ProductTypeAPI {
	private IProductTypeService productTypeService = new ProductTypeServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result createProductType(@RequestBody ProductType productType) {
		return productTypeService.createProductType(productType);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(productTypeService.getAllProductType())
				: ResponseEntity.status(HttpStatus.OK).body(productTypeService.getProductTypeById(id.intValue()));
	}

	@DeleteMapping("/delete")
	@Transactional
	public Result deleteProductType(@RequestBody ProductType productType) {
		return productTypeService.deleteProductType(productTypeService.getProductTypeById(productType.getPtype()));
	}

	@PutMapping("/update")
	@Transactional
	public Result updateProductType(@RequestBody ProductType productType) {
		return productTypeService.updateProductType(productType);
	}

	@GetMapping("/total-income")
	@Transactional
	public double totalIncome() {
		return productTypeService.totalIncome();
	}

	@GetMapping("/total-income-in-interval")
	@Transactional
	public double totalIncomeinInterval(@RequestParam(required = true) String startDate,
			@RequestParam(required = true) String endDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date stDate = format.parse(startDate);
		Date edDate = format.parse(endDate);
		return productTypeService.totalIncomeinInterval(stDate, edDate);
	}

	@GetMapping("/income")
	@Transactional
	public double getIncome(@RequestParam(required = true) Integer id) {
		return productTypeService.incomeOfAProductType(id.intValue());
	}

	@GetMapping("/income-in-interval")
	@Transactional
	public double getIncomeinInterval(@RequestParam(required = true) Integer id,
			@RequestParam(required = true) String startDate, @RequestParam(required = true) String endDate)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date stDate = format.parse(startDate);
		Date edDate = format.parse(endDate);
		return productTypeService.incomeOfAProductTypeinInterval(id.intValue(), stDate, edDate);
	}
}
