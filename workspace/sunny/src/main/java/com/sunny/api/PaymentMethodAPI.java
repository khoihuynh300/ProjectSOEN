package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.PaymentMethod;
import com.sunny.service.IPaymentMethodService;
import com.sunny.service.impl.PaymentMethodServiceImpl;

@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodAPI {
	private IPaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();

	@GetMapping("/get-all-payment-method")
	@Transactional
	public List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodService.getAllPaymentMethod();
	}
}
