package com.sunny.service.impl;

import com.sunny.dao.impl.DiscountDaoImpl;
import com.sunny.model.Discount;
import com.sunny.service.IDiscountService;

public class DiscountServiceImpl implements IDiscountService {

	@Override
	public Discount create(Discount discount) {
		DiscountDaoImpl discountDaoImpl = new DiscountDaoImpl();
		return discountDaoImpl.create(discount);
	}

}
