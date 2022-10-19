package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Discount;
import com.sunny.service.impl.DiscountServiceImpl;

@RestController

public class DiscountAPI {
	@PostMapping("/discount")
	@Transactional
	public Discount createDiscount(@RequestBody Discount discount) {
		DiscountServiceImpl discountServiceImpl = new DiscountServiceImpl();
		return discountServiceImpl.create(discount);
	}
}
