package com.restaurants.services;

import java.util.List;

import com.restaurants.entities.Restaurants;

public interface RestaurantService {

	Restaurants getRestaurantById(long restaurantId);
	
	List<Restaurants> getAllRestaurants();
	
	Restaurants addRestaurant(Restaurants restaurants);
	
	// update Restaurant
	Restaurants updateRestaurant(long restaurantId, Restaurants restaurants);
	
	// delete Restaurant
	String deleteRestaurants(long restaurantId);
}
