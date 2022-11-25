package com.sunny.api;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sunny.model.Shipper;
import com.sunny.model.User;
import com.sunny.service.IShipperService;
import com.sunny.service.IUserService;
import com.sunny.service.impl.Result;
import com.sunny.service.impl.ShipperServiceImpl;
import com.sunny.service.impl.UserServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("/usermanagement")
public class UserManagementAPI {
	@Autowired
	private IUserService userService;
	private IShipperService shipperService = new ShipperServiceImpl();
	private static final int PAGE_SIZE = 10;
	@PostMapping("/create")
	@Transactional
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		try {
			
			if( userService.createUser(user) != null ) {
				return ResponseEntity.status(HttpStatus.OK).body("Tạo tài khoản mới thành công");
			}
			
		} catch (Exception e) {
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tạo tài khoản không thành công");
		
	}

	@DeleteMapping("/delete")
	@Transactional
	public ResponseEntity<?> deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body("Xóa thành công");
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id, 
			@RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(required = false) Integer viewdeleted,
			HttpSession session) throws Exception {
//		User currentUser = (User) session.getAttribute("user");
//		if (userServiceImpl.checkRoles(currentUser) == 1)
//			return id == null ? ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getAllUser(pageNumber.intValue(), PAGE_SIZE))
//					: ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUserById(id));
//		else
//			throw new Exception("Bạn không có quyền");
		
		if (viewdeleted == null)
			viewdeleted = 0;
		if (viewdeleted != 0 && viewdeleted != 1) {
			throw new IllegalArgumentException("delted should be null or 1 or 0");
		}
		
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser(pageNumber,PAGE_SIZE,viewdeleted.intValue()))
				: ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}
	
	@GetMapping("/count")
	@Transactional
	public ResponseEntity<?> count(@RequestParam(defaultValue = "0") Integer viewdeleted, @RequestParam String table) throws Exception {
		if (viewdeleted != 0 && viewdeleted != 1) {
			throw new IllegalArgumentException("delted should be null or 1 or 0");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userService.count(viewdeleted,table));
	}

	@PutMapping("/update")
	@Transactional
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.OK).body("Sửa thành công");
	}
	
	@GetMapping("/shipper/get-by-user-id")
	@Transactional
	public Employee getShipperByUserId(@RequestParam(required = true) Integer userId) {
		
		return shipperService.getShipperByUserId(userId.intValue());
	}
}
