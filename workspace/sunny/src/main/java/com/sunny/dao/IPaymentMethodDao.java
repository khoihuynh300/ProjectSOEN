package com.sunny.dao;

import java.util.List;

import com.sunny.model.PaymentMethod;

public interface IPaymentMethodDao {

	List<PaymentMethod> getAllPaymentMethod();

	PaymentMethod getById(int id);
}