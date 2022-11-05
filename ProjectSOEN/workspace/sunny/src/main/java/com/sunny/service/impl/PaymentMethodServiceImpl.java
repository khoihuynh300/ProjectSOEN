package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IPaymentMethodDao;
import com.sunny.dao.impl.PaymentMethodDaoImpl;
import com.sunny.model.PaymentMethod;
import com.sunny.service.IPaymentMethodService;

public class PaymentMethodServiceImpl implements IPaymentMethodService {
	private IPaymentMethodDao paymentMethodDao = new PaymentMethodDaoImpl();

	@Override
	public List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodDao.getAllPaymentMethod();
	}

	@Override
	public PaymentMethod getById(int id) {
		return paymentMethodDao.getById(id);
	}
}
