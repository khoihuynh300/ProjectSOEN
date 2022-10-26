package com.sunny.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.model.Product;
import com.sunny.model.Rating;
import com.sunny.model.User;
import com.sunny.service.IRatingService;
import com.sunny.service.impl.RatingServiceImpl;

@RequestMapping("/rating")
@RestController
public class RatingAPI {
	private IRatingService ratingService = new RatingServiceImpl();

	@PostMapping("/create")
	@Transactional
	public Rating createRating(@RequestBody Rating rating) {
		return ratingService.createRating(rating);
	}

	@GetMapping("/get")
	@Transactional
	public List<Rating> getAllRating() {
		return ratingService.getAllRating();
	}

	@DeleteMapping("/delete")
	@Transactional
	public void deleteRating(@RequestBody Rating rating) {
		ratingService.deleteRating(rating);
	}

	@GetMapping("/get-by-productId")
	@Transactional
	public List<Rating> getByProductId(@RequestBody Product product) {
		return ratingService.getByProductId(product);
	}

	@GetMapping("/get-by-userId")
	@Transactional
	public List<Rating> getByUserId(@RequestBody User user) {
		return ratingService.getByUserId(user);
	}

}
