package com.userservice.fiegnclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.userservice.entities.Ratings;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

	@GetMapping("/ratings/userid/{userId}")
	List<Ratings> getRatings(@PathVariable long userId);

	// 	PostMapping
	@PostMapping("/addratings")
	Ratings createRating(@RequestBody Ratings ratings);
	
	// PutMapping
	@PutMapping("/ratings/updateratings/ratingid/{ratingId}")
	Ratings updateRatings(@PathVariable long ratingId, @RequestBody Ratings  ratings);
	
	
	//DeleteMapping
	@DeleteMapping("/ratings/deleteratings/ratingid/{ratingId}")
	public void deleteRatings(@PathVariable long ratingId);
	
	
}
