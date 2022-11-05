package com.sunny.api.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Employee;
import com.sunny.model.Orders;
import com.sunny.model.User;
import com.sunny.service.IEmployeeService;
import com.sunny.service.IOrdersService;
import com.sunny.service.IUserService;
import com.sunny.service.impl.EmployeeServiceImpl;
import com.sunny.service.impl.OrdersServiceImpl;
import com.sunny.service.impl.Result;

@RequestMapping("/shipper")
@RestController
public class ShipperAPI {
	@Autowired
	IUserService userService;

	private IEmployeeService emplService = new EmployeeServiceImpl();
	
	private IOrdersService ordersService = new OrdersServiceImpl();

	@GetMapping("")
	public List<Orders> getOrderBeingDilivered(@RequestParam(defaultValue = "2", required = false) Integer status,HttpSession session) {
		List<Orders> result = new ArrayList<>();
		User userReq = (User) session.getAttribute("user");
		Employee shipper = emplService.getEmployeeByUserId(userReq.getUserId());
		result = ordersService.getOrdersByShipperId(shipper, status.intValue());
		return result;
	}
	
	@PutMapping("/update")
	@Transactional
	public Result updateStatus(@RequestBody Orders order) {
		return ordersService.updateStatus(order);
	}
}
