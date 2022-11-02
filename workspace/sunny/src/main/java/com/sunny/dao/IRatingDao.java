package com.sunny.dao;

import java.util.List;

import com.sunny.model.Product;
import com.sunny.model.Rating;
import com.sunny.model.User;

public interface IRatingDao {

	Rating createRating(Rating rating);

	List<Rating> getAllRating();

	void deleteRating(Rating rating);

	List<Rating> getByProductId(Product product);

	List<Rating> getByUserId(User user);

	Rating getRatingById(int id);

}