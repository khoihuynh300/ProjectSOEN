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
	public Result createDiscount(Discount discount) {
		discountDao.createDiscount(discount);
		return new Result(true, "Create Discount successfully!!!");
	}

	@Override
	public List<Discount> getAllDiscount() {
		return discountDao.getAllDiscount();
	}

	@Override
	public Result updateDiscount(Discount discount) {
		discountDao.updateDiscount(discount);
		return new Result(true, "Update Discount successfully!!!");
	}

	@Override
	public Result deleteDiscount(Discount discount) {
		discountDao.deleteDiscount(discount);
		return new Result(true, "Delete Discount successfully!!!");
	}

	@Override
	public Discount getDiscountById(int id) {
		return discountDao.getDiscountById(id);
	}

}
