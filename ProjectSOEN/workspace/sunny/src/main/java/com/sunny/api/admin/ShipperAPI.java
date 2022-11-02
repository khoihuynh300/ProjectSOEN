package com.sunny.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunny.service.IUserService;

@RequestMapping("/shipper")
public class ShipperAPI {
	@Autowired
	IUserService userService;
	
}
