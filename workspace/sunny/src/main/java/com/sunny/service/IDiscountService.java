package com.sunny.service;

import java.util.List;

import com.sunny.model.Discount;

public interface IDiscountService {
	Discount createDiscount(Discount discount);

	List<Discount> getAllDiscount();

	void updateDiscount(Discount discount);

	void deleteDiscount(Discount discount);

	Discount getDiscountById(int id);
}
