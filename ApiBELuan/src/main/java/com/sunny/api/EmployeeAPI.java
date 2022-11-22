package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
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
	public ResponseEntity<?> getbyEmpid(@RequestParam(required = false) Integer id,
			@RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(required = false) Integer viewdeleted) {
		
		if (viewdeleted == null)
			viewdeleted = 0;
		if (viewdeleted != 0 && viewdeleted != 1) {
			throw new IllegalArgumentException("delted should be null or 1 or 0");
		}
		
		return id == null
				? ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee(pageNumber,10,viewdeleted.intValue()))
				: ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeebyEmpId(id.intValue()));
		//return employeeService.getEmployeebyEmpId(id.intValue());
	}
	
	@GetMapping("/get-by-user-id")
	@Transactional
	public Employee getEmployeeByUserId(@RequestParam(required = true) Integer userId) {
		return employeeService.getEmployeebyUserId(userId.intValue());
	}
	
	@GetMapping("/shipper/get-order")
	@Transactional
	public ResponseEntity<?> getorder(@RequestParam(required = true) Integer orderid, @RequestParam(required = true) Integer shipperid) {
		System.err.println("1234");
		
		if(employeeService.getorder(shipperid.intValue(), orderid.intValue()) == false) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Đơn hàng đã có người nhận!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Nhận đơn thành công");
	}
	
	@GetMapping("/shipper/send-to-customer")
	@Transactional
	public ResponseEntity<?> sendtocustomer(@RequestParam(required = true) Integer orderid) {
		
		
		try {
			employeeService.sendorder(orderid);
			return ResponseEntity.status(HttpStatus.OK).body("Thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.OK).body("Thất bại");
		}
		
		
	}
}