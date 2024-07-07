package com.ratings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ratings.entities.Ratings;
import com.ratings.services.RatingsService;


@RestController
public class RatingsController {

	@Autowired
	private RatingsService ratingsService;

	@GetMapping("/test")
	public String test() {
		return "hello ratinggs..";
	}

	@PostMapping("/addratings")
	public Ratings addRatings(@RequestBody Ratings ratings) {
		return ratingsService.addRatings(ratings);
	}

	@GetMapping("/ratingid/{ratingId}")
	public Ratings getRatingsById(@PathVariable long ratingId) {
		return ratingsService.findById(ratingId);
	}

	@GetMapping("/ratings")
	public List<Ratings> getAllRatings() {
		return ratingsService.getAllRatings();
	}

	@GetMapping("/ratings/userid/{userId}")
	public List<Ratings> getRatingsByUserId(@PathVariable long userId){
		return ratingsService.findRatingsByUserId(userId);
	}

	@GetMapping("/ratings/restaurantid/{restaurantId}")
	public List<Ratings> getRatingsByRestaurantId(@PathVariable long restaurantId){
		return ratingsService.findRatingsByRestaurantId(restaurantId);
	}

}
