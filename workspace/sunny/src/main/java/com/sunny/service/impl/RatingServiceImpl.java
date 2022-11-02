package com.sunny.service.impl;

import java.util.List;

import com.sunny.dao.IRatingDao;
import com.sunny.dao.impl.RatingDaoImpl;
import com.sunny.model.Product;
import com.sunny.model.Rating;
import com.sunny.model.User;
import com.sunny.service.IRatingService;

public class RatingServiceImpl implements IRatingService {

	private IRatingDao ratingDao = new RatingDaoImpl();

	@Override
	public Result createRating(Rating rating) {
		ratingDao.createRating(rating);
		return new Result(true, "Create Rating successfully!!!");
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingDao.getAllRating();
	}

	@Override
	public Result deleteRating(Rating rating) {
		ratingDao.deleteRating(rating);
		return new Result(true, "Delete Rating successfully!!!");
	}

	@Override
	public List<Rating> getByProductId(Product product) {
		return ratingDao.getByProductId(product);
	}

	@Override
	public List<Rating> getByUserId(User user) {
		return ratingDao.getByUserId(user);
	}

	@Override
	public Rating getRatingById(int id) {
		return ratingDao.getRatingById(id);
	}

}
