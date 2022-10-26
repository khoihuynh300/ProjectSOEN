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

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
	private IEmployeeService employeeService = new EmployeeServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Employee create(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/update")
	@Transactional
	public void update(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/delete")
	@Transactional
	public void delete(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);
	}

	@GetMapping("/get-all-employee")
	@Transactional
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/get-by-empid")
	@Transactional
	public Employee getbyEmpid(@RequestParam(required = true) int id) {
		return employeeService.getEmployeebyEmpId(id);
	}
}