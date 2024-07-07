package com.restaurants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurants.entities.Restaurants;
import com.restaurants.services.RestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/test")
	public String test() {
		return "hello restaurants..";
	}
	
	
	@PostMapping("/addrestaurant")
	public Restaurants addRestaurant(@RequestBody Restaurants restaurants) {
		return restaurantService.addRestaurant(restaurants);
	}
	
	
	@GetMapping("/restaurantid/{restaurantId}")
	public Restaurants getRestaurantById(@PathVariable long restaurantId) {
		return restaurantService.getRestaurantById(restaurantId);
	}
	
	@GetMapping("/restaurants")
	public List<Restaurants> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
//	@GetMapping("/restaurants/ratingid/{ratingId}")
//	public List<Restaurants> getRestaurantByRatingId(@PathVariable long ratingId){
//		return restaurantService.findRestaurantsByRatingId(ratingId);
//	}
//	
	
}
