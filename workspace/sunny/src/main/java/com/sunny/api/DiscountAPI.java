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

import com.sunny.model.Discount;
import com.sunny.service.impl.DiscountServiceImpl;

@RestController

public class DiscountAPI {
	DiscountServiceImpl discountServiceImpl = new DiscountServiceImpl();

	@PostMapping("/discount")
	@Transactional
	public Discount createDiscount(@RequestBody Discount discount) {
		return discountServiceImpl.createDiscount(discount);
	}

	@GetMapping("/discount")
	@Transactional
	public ResponseEntity<?> getAllDiscount(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(discountServiceImpl.getAllDiscount())
				: ResponseEntity.status(HttpStatus.OK).body(discountServiceImpl.getDiscountById(id.intValue()));
	}

	@PutMapping("/discount")
	@Transactional
	public void updateDiscount(@RequestBody Discount discount) {
		discountServiceImpl.updateDiscount(discount);
	}

	@DeleteMapping("/discount")
	@Transactional
	public void deleteDiscount(@RequestBody Discount discount) {
		discountServiceImpl.deleteDiscount(discount);
	}
}
