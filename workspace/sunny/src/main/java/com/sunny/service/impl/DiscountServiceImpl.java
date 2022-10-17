package com.sunny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.dao.impl.DiscountDaoImpl;
import com.sunny.model.Discount;
import com.sunny.service.IDiscountService;

public class DiscountServiceImpl implements IDiscountService {

	@Autowired
	DiscountDaoImpl discountDaoImpl = new DiscountDaoImpl();

	@Override
	public Discount createDiscount(Discount discount) {
		return discountDaoImpl.createDiscount(discount);
	}

	@Override
	public List<Discount> getAllDiscount() {
		return discountDaoImpl.getAllDiscount();
	}

	@Override
	public void updateDiscount(Discount discount) {
		discountDaoImpl.updateDiscount(discount);
	}

	@Override
	public void deleteDiscount(Discount discount) {
		discountDaoImpl.deleteDiscount(discount);
	}

	@Override
	public Discount getDiscountById(int id) {
		return discountDaoImpl.getDiscountById(id);
	}

}
