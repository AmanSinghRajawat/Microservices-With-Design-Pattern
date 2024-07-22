package com.restaurants.servicesImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Restaurants updateRestaurant(long restaurantId, Restaurants restaurants) {
		// TODO Auto-generated method stub
		Restaurants restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new ResourceNotFoundException("restaurant not found by restaurantid "+restaurantId)); 
		
		if(!restaurant.equals(null)) {
			if(restaurants.getAddress() != null) {
				restaurant.setAddress(restaurants.getAddress());
			}
			if(restaurants.getCity() != null) {
				restaurant.setCity(restaurants.getCity());
			}
			if(restaurants.getMenus().size() > 0) {
				restaurant.setMenus(restaurants.getMenus());
			}
			if(restaurants.getRestaurantName() != null) {
				restaurant.setRestaurantName(restaurants.getRestaurantName());
			}
			
			
			restaurantRepository.save(restaurant);
		}
		
		return restaurant;
	}

	@Override
	public String deleteRestaurants(long restaurantId) {
		// TODO Auto-generated method stub
		Optional<Restaurants> restaurant = restaurantRepository.findById(restaurantId);
		if(!restaurant.isPresent()) {
//			throw new ResourceNotFoundException("restaurant not found by restaurantid "+restaurantId);
			return "restaurant not found by restaurantid "+restaurantId;
		}
		restaurantRepository.deleteById(restaurantId);
		return "restaurant deleted by restaurantid "+restaurantId;
	}


}
