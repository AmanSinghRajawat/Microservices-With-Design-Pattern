package com.userservice.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entities.Ratings;
import com.userservice.entities.Restaurants;
import com.userservice.entities.Users;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserServices;

import com.userservice.fiegnclient.RatingService;
import com.userservice.fiegnclient.RestaurantService;


@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private RatingService ratingService;

	@Override
	public Users addUser(Users u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

//
//	@Override
//	public Users findUserById(long userId) {
//		// TODO Auto-generated method stub
//		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found by given userid : "+userId));
//	}
//

	@Override
	public Users findById(long userId) {
		// TODO Auto-generated method stub

		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found userid : " + userId));

		// calling Rating Service using feignclien.

		List<Ratings> ratingList = ratingService.getRatings(user.getUserId());

		ratingList.stream().map(rating -> {

			// 1. call restaurant service to get the Restaurants details.

			// calling restaurant service using Feign Client.

			Restaurants restaurant = restaurantService.getRestaurant(rating.getRestaurantId());

			// 2. set Restaurants for ratingId

			rating.setRestaurants(restaurant);

			// 3. return rating

			return rating;

		}).collect(Collectors.toList());

// DYNAMIC ENDED HERE.

		user.setRatings(ratingList);

		return user;
	}

}
