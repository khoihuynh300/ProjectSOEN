package com.sunny.service;

import java.util.List;

import com.sunny.model.Product;
import com.sunny.model.Rating;
import com.sunny.model.User;
import com.sunny.service.impl.Result;

public interface IRatingService {
	Result createRating(Rating rating);

	List<Rating> getAllRating();

	Result deleteRating(Rating rating);

	List<Rating> getByProductId(Product product);

	List<Rating> getByUserId(User user);

	Rating getRatingById(int id);
}
