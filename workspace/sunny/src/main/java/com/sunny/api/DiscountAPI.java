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

import com.sunny.model.Discount;
import com.sunny.service.IDiscountService;
import com.sunny.service.impl.DiscountServiceImpl;
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/discount")
public class DiscountAPI {
	private IDiscountService discountService = new DiscountServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result createDiscount(@RequestBody Discount discount) {
		return discountService.createDiscount(discount);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> getAllDiscount(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(discountService.getAllDiscount())
				: ResponseEntity.status(HttpStatus.OK).body(discountService.getDiscountById(id.intValue()));
	}

	@PutMapping("/update")
	@Transactional
	public Result updateDiscount(@RequestBody Discount discount) {
		return discountService.updateDiscount(discount);
	}

	@DeleteMapping("/delete")
	@Transactional
	public Result deleteDiscount(@RequestBody Discount discount) {
		return discountService.deleteDiscount(discountService.getDiscountById(discount.getDiscountId()));
	}
}
