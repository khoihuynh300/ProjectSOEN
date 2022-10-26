package com.sunny.service;

import java.util.List;

import com.sunny.model.Product;
import com.sunny.model.Rating;
import com.sunny.model.User;

public interface IRatingService {
	Rating createRating(Rating rating);

	List<Rating> getAllRating();

	void deleteRating(Rating rating);

	List<Rating> getByProductId(Product product);

	List<Rating> getByUserId(User user);
}
