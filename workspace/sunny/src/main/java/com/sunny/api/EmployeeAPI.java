package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Employee;
import com.sunny.service.IEmployeeService;
import com.sunny.service.impl.EmployeeServiceImpl;
import com.sunny.service.impl.Result;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
	private IEmployeeService employeeService = new EmployeeServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Result create(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/update")
	@Transactional
	public Result update(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/delete")
	@Transactional
	public Result delete(@RequestBody Employee employee) {
		return employeeService.deleteEmployee(employeeService.getEmployeebyEmpId(employee.getEmpId()));
	}

	@GetMapping("/get-all-employee")
	@Transactional
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/get")
	@Transactional
	public Employee getbyEmpid(@RequestParam(required = true) Integer id) {
		return employeeService.getEmployeebyEmpId(id.intValue());
	}

	@GetMapping("/get-by-user-id")
	@Transactional
	public Employee getEmployeeByUserId(@RequestParam(required = true) Integer userId) {
		return employeeService.getEmployeebyUserId(userId.intValue());
	}
}