package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Invoice;
import com.sunny.model.InvoiceItem;
import com.sunny.service.IInvoiceItemService;
import com.sunny.service.impl.InvoiceItemServiceImpl;
import com.sunny.service.impl.Result;
@CrossOrigin
@RequestMapping("/invoiceItem")
@RestController
public class InvoiceItemAPI {
	private IInvoiceItemService invoiceItemService = new InvoiceItemServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result createInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
		return invoiceItemService.createInvoiceItem(invoiceItem);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(invoiceItemService.getAll())
				: ResponseEntity.status(HttpStatus.OK).body(invoiceItemService.getInvoiceItemById(id.intValue()));
	}

	@GetMapping("/get-by-invoiceId")
	@Transactional
	public List<InvoiceItem> getByInvoiceId(@RequestBody Invoice invoice) {
		return invoiceItemService.getByInvoiceId(invoice);
	}
}
