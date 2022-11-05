package com.sunny.api;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.service.IPaymentMethodService;
import com.sunny.service.impl.PaymentMethodServiceImpl;

@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodAPI {
	private IPaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(paymentMethodService.getAllPaymentMethod())
				: ResponseEntity.status(HttpStatus.OK).body(paymentMethodService.getById(id.intValue()));
	}
}
