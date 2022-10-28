package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Rating;
import com.sunny.service.IProductService;
import com.sunny.service.IRatingService;
import com.sunny.service.IUserService;
import com.sunny.service.impl.ProductServiceImpl;
import com.sunny.service.impl.RatingServiceImpl;
import com.sunny.service.impl.UserServiceImpl;

@RequestMapping("/rating")
@RestController
public class RatingAPI {
	private IRatingService ratingService = new RatingServiceImpl();
	private IProductService productService = new ProductServiceImpl();
	private IUserService userService = new UserServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Rating createRating(@RequestBody Rating rating) {
		return ratingService.createRating(rating);
	}

	@GetMapping("/get")
	@Transactional
	public List<Rating> getAllRating(@RequestParam(required = false) Integer pid,
			@RequestParam(required = false) Integer userid) {
		if (pid != null) {
			if (userid != null)
				throw new IllegalArgumentException("Only one parameter allowed.");
			return ratingService.getByProductId(productService.getProductById(pid.intValue()));
		}
		return userid == null ? ratingService.getAllRating()
				: ratingService.getByUserId(userService.getUserById(userid.intValue()));
	}

	@DeleteMapping("/delete")
	@Transactional
	public void deleteRating(@RequestBody Rating rating) {
		ratingService.deleteRating(rating);
	}
}
