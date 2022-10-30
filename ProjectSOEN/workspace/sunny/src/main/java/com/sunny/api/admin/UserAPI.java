package com.sunny.api.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController(value = "UserControllerOfAdmin")
@RequestMapping("/admin")
public class UserAPI {

	@Autowired
	IUserService userServiceImpl;
	
	private static final int PAGE_SIZE = 10;

	@PostMapping("/user")
	@Transactional
	public User createUser(@RequestBody User user, HttpSession session) throws Exception {
//		User currentUser = (User) session.getAttribute("user");
//		if (userServiceImpl.checkRoles(currentUser) == 1)
//			return userServiceImpl.createUser(user);
//		else
//			throw new Exception("Bạn không có quyền");
		return userServiceImpl.createUser(user);
	}

	@DeleteMapping("/user")
	@Transactional
	public void deleteUser(@RequestBody User user, HttpSession session) throws Exception {
//		User currentUser = (User) session.getAttribute("user");
//		if (userServiceImpl.checkRoles(currentUser) == 1)
//			userServiceImpl.deleteUser(user);
//		else
//			throw new Exception("Bạn không có quyền");
		userServiceImpl.deleteUser(user);

	}

	@GetMapping("/user")
	@Transactional
	public ResponseEntity<?> get(@RequestParam(required = false) Integer id, @RequestParam(defaultValue = "1") Integer pageNumber, HttpSession session) throws Exception {
//		User currentUser = (User) session.getAttribute("user");
//		if (userServiceImpl.checkRoles(currentUser) == 1)
//			return id == null ? ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getAllUser(pageNumber.intValue(), PAGE_SIZE))
//					: ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUserById(id));
//		else
//			throw new Exception("Bạn không có quyền");
		return id == null ? ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getAllUser(pageNumber.intValue(), PAGE_SIZE))
				: ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.getUserById(id));
	}

	@PutMapping("/user")
	@Transactional
	public void updateUser(@RequestBody User user, String newPassword, HttpSession session) throws Exception {
//		User currentUser = (User) session.getAttribute("user");
//		if (userServiceImpl.checkRoles(currentUser) == 1)
//			userServiceImpl.updateUser(user, newPassword);
//		else
//			throw new Exception("Bạn không có quyền");
		userServiceImpl.updateUser(user, newPassword);
	}

}
