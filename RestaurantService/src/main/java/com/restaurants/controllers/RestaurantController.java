package com.restaurants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurants.entities.Restaurants;
import com.restaurants.services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
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
	
	@GetMapping("")
	public List<Restaurants> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
	
	// update restaurant
	
	@PutMapping("/updaterestaurant/restaurantid/{restaurantId}")
	public Restaurants updateRestaurant(@PathVariable long restaurantId, @RequestBody Restaurants restaurants) {
		return restaurantService.updateRestaurant(restaurantId, restaurants);
	}
	
	
	// delete restaurant
	
	@DeleteMapping("/deleterestaurant/restaurantid/{restaurantId}")
	public String deleteRestaurant(@PathVariable long restaurantId) {
		return restaurantService.deleteRestaurants(restaurantId);
	}
	
	
	
	
//	@GetMapping("/restaurants/ratingid/{ratingId}")
//	public List<Restaurants> getRestaurantByRatingId(@PathVariable long ratingId){
//		return restaurantService.findRestaurantsByRatingId(ratingId);
//	}

}
