package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Role;
import com.sunny.service.IRoleService;
import com.sunny.service.impl.RoleServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleAPI {
	IRoleService roleService = new RoleServiceImpl();

	@GetMapping("/get")
	@Transactional
	public List<Role> getAll() {
		return roleService.getAll();
	}
}
