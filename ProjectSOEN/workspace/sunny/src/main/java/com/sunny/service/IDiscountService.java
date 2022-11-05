package com.sunny.service;

import java.util.List;

import com.sunny.model.Discount;
import com.sunny.service.impl.Result;

public interface IDiscountService {
	Result createDiscount(Discount discount);

	List<Discount> getAllDiscount();

	Result updateDiscount(Discount discount);

	Result deleteDiscount(Discount discount);

	Discount getDiscountById(int id);
}
