package com.restaurants.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurants.entities.Restaurants;
import com.restaurants.exceptions.ResourceNotFoundException;
import com.restaurants.repositories.RestaurantRepository;
import com.restaurants.services.RestaurantService;


@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurants getRestaurantById(long restaurantId) {
		// TODO Auto-generated method stub
		return restaurantRepository.findById(restaurantId).orElseThrow(()-> new ResourceNotFoundException("restaurant not found : "+restaurantId));
	}

	@Override
	public List<Restaurants> getAllRestaurants() {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurants addRestaurant(Restaurants restaurants) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(restaurants);
	}


}
