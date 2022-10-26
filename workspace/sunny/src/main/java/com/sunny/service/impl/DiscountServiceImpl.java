package com.sunny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunny.dao.IDiscountDao;
import com.sunny.dao.impl.DiscountDaoImpl;
import com.sunny.model.Discount;
import com.sunny.service.IDiscountService;

public class DiscountServiceImpl implements IDiscountService {

	@Autowired
	private IDiscountDao discountDao = new DiscountDaoImpl();

	@Override
	public Discount createDiscount(Discount discount) {
		return discountDao.createDiscount(discount);
	}

	@Override
	public List<Discount> getAllDiscount() {
		return discountDao.getAllDiscount();
	}

	@Override
	public void updateDiscount(Discount discount) {
		discountDao.updateDiscount(discount);
	}

	@Override
	public void deleteDiscount(Discount discount) {
		discountDao.deleteDiscount(discount);
	}

	@Override
	public Discount getDiscountById(int id) {
		return discountDao.getDiscountById(id);
	}

}
