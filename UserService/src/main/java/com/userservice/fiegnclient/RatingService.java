package com.userservice.fiegnclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entities.Ratings;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

	@GetMapping("/ratings/userid/{userId}")
	List<Ratings> getRatings(@PathVariable long userId);
	
	
}
