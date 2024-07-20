package com.userservice.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entities.Restaurants;

@FeignClient(name = "RESTAURANTSERVICE")
public interface RestaurantService {

	@GetMapping("/restaurantid/{restaurantId}")
	Restaurants getRestaurant(@PathVariable long restaurantId);
	
}
