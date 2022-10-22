package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.impl.PaymentMethodDaoImpl;
import com.sunny.model.PaymentMethod;
import com.sunny.service.IPaymentMethodService;

public class PaymentMethodServiceImpl implements IPaymentMethodService {
	PaymentMethodDaoImpl paymentMethodDaoImpl = new PaymentMethodDaoImpl();

	@Override
	public List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodDaoImpl.getAllPaymentMethod();
	}
}
