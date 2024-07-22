package com.userservice.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.userservice.entities.Ratings;
import com.userservice.entities.Restaurants;

import feign.RequestLine;

@FeignClient(name = "RESTAURANTSERVICE")
public interface RestaurantService {

	@GetMapping("/restaurants/restaurantid/{restaurantId}")
	Restaurants getRestaurant(@PathVariable long restaurantId);
	
	@PostMapping("/restaurants/addrestaurant")
	public Restaurants addRestaurant(@RequestBody Restaurants restaurants);
	
	// PutMapping
	@PutMapping("/restaurants/updaterestaurant/restaurantid/{restaurantId}")
	public Restaurants updateRestaurant(@PathVariable long restaurantId, @RequestBody Restaurants restaurants);
	
	
	@DeleteMapping("/restaurants/deleterestaurant/restaurantid/{restaurantId}")
	public String deleteRestaurant(@PathVariable long restaurantId);
	
}
