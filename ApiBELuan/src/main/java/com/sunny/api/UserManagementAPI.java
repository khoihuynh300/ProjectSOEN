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

import com.sunny.model.User;
import com.sunny.service.IUserService;
import com.sunny.service.impl.Result;
import com.sunny.service.impl.UserServiceImpl;


@CrossOrigin
@RestController
@RequestMapping("/usermanagement")
public class UserManagementAPI {
	@Autowired
	private IUserService userService;
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
		System.err.println("nammoadidaphat");
		return ResponseEntity.status(HttpStatus.OK).body("Xóa thành công");
	}

	@GetMapping("/get")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id, @RequestParam(defaultValue = "1") Integer pageNumber, HttpSession session) throws Exception {
//		User currentUser = (User) session.getAttribute("user");
//		if (userServiceImpl.checkRoles(currentUser) == 1)
//			return id == null ? ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getAllUser(pageNumber.intValue(), PAGE_SIZE))
//					: ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUserById(id));
//		else
//			throw new Exception("Bạn không có quyền");
	
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser(pageNumber.intValue(), PAGE_SIZE))
				: ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}
	
	@GetMapping("/count")
	@Transactional
	public ResponseEntity<?> count() throws Exception {	
		return ResponseEntity.status(HttpStatus.OK).body(userService.count());
	}

	@PutMapping("/update")
	@Transactional
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.OK).body("Sửa thành công");
	}
}
