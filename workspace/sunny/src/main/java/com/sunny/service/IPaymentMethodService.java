package com.sunny.service;

import java.util.List;

import com.sunny.model.PaymentMethod;

public interface IPaymentMethodService {

	List<PaymentMethod> getAllPaymentMethod();

	PaymentMethod getById(int id);

}