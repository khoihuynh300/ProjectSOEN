package com.sunny.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunny.model.CartItem;
import com.sunny.model.Orders;
import com.sunny.model.PaymentMethod;
import com.sunny.model.Product;
import com.sunny.service.IOrdersService;
import com.sunny.service.impl.OrdersServiceImpl;
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersAPI {
	private IOrdersService ordersService = new OrdersServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result createOrder(@RequestParam String address, @RequestParam String paymentMethod,
			@RequestParam String listCartItem) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		PaymentMethod paymentMethodResp = mapper.readValue(paymentMethod, PaymentMethod.class);
		List<CartItem> listCartItemResp = new ArrayList<>() ;
		while(listCartItem.length() >0){
			
			listCartItemResp.add( mapper.readValue(listCartItem.substring(1,listCartItem.indexOf("]")), CartItem.class));
		    //System.out.println();
		    listCartItem = listCartItem.substring(listCartItem.indexOf("]")+1);
		    //System.out.println(listCartItem);
		    }
		/*
		 * for (String c : listCartItem) { System.err.println(c); CartItem ci =
		 * mapper.readValue(c, CartItem.class); listCartItemResp.add(ci); }
		 */
		return ordersService.createOrder(address, paymentMethodResp, listCartItemResp);
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id,
			@RequestParam(defaultValue = "0") Integer shipid,
			@RequestParam(defaultValue = "0") Integer cusid) {
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(ordersService.getAllOrders(cusid,shipid))
				: ResponseEntity.status(HttpStatus.OK).body(ordersService.getOrderById(id.intValue()));
	}

	@PutMapping("/update")
	@Transactional
	public Result updateStatus(@RequestBody Orders order) {
		return ordersService.updateStatus(order);
	}
	
	@GetMapping("/get-desc-id")
	@Transactional
	public ResponseEntity<?> getOrderByDescendingId(@RequestParam(required = true) Integer pagenumber) {
		return ResponseEntity.status(HttpStatus.OK).body(ordersService.getAllOrdersDescendingId(pagenumber.intValue(), 10));
	}
}
