package com.userservice.servicesImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Ratings;
import com.userservice.entities.Restaurants;
import com.userservice.entities.Users;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
	// @Override
	// public Users findUserById(long userId) {
	// // TODO Auto-generated method stub
	// return userRepository.findById(userId).orElseThrow(() -> new
	// ResourceNotFoundException("User not found by given userid : "+userId));
	// }
	//

	@Override
	public Users findById(long userId) {
		// TODO Auto-generated method stub

		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found userid : " + userId));

		// calling Rating Service

		// ArrayList<Ratings> ratingsByUserId =
		// restTemplate.getForObject("http://localhost:8083/ratings/userid/"+user.getUserId(),
		// ArrayList.class);
		// logger.info("{} ",ratingsByUserId);
		// user.setRatings(ratingsByUserId);

		// calling Rating Service and then Restaurant Service.

		// "http://localhost:8083/ratings/userid/"+user.getUserId() all this is hard
		// coded, our code is depend on host and port number.
		// hard coded approach is not the good coding approach for example if we change
		// our port number or host our services won't work.
		// so lets make it dynamic.

		// HARD CODED

		// Ratings[] ratingsByUserId =
		// restTemplate.getForObject("http://localhost:8083/ratings/userid/"+user.getUserId(),
		// Ratings[].class);
		//
		// logger.info("{}",ratingsByUserId);
		//
		// List<Ratings> ratingList = Arrays.stream(ratingsByUserId).toList();
		//
		// ratingList.stream().map(rating -> {
		//
		// // 1. call restaurant service to get the Restaurants details.
		//
		// ResponseEntity<Restaurants> forObject =
		// restTemplate.getForEntity("http://localhost:8082/restaurantid/"+rating.getRestaurantId(),
		// Restaurants.class);
		//
		// Restaurants restaurants = forObject.getBody();
		// logger.info("status code: {} ",forObject.getStatusCode());
		//
		// // 2. set Restaurants for ratingId
		//
		// rating.setRestaurants(restaurants);
		//
		// // 3. return rating
		//
		// return rating;
		//
		// }).collect(Collectors.toList());

		// HARD CODED END HERE.

		// DYNAMIC --- By Replacing localhost:portNO by SERVICE NAME. now if you change
		// your port it won't effect. still it works fine.

		// Now we have to use @LoadBalanced annotation on RestTemplate Bean. to tell
		// resttemplate object that you have to communicate with other service by
		// Services Name not hostname or port no.

		Ratings[] ratingsByUserId = restTemplate.getForObject("http://RATINGSERVICE/ratings/userid/" + user.getUserId(),
				Ratings[].class);

		logger.info("{}", ratingsByUserId);

		List<Ratings> ratingList = Arrays.stream(ratingsByUserId).toList();

		ratingList.stream().map(rating -> {

			// 1. call restaurant service to get the Restaurants details.

			ResponseEntity<Restaurants> forObject = restTemplate.getForEntity(
					"http://RESTAURANTSERVICE/restaurantid/" + rating.getRestaurantId(), Restaurants.class);

			Restaurants restaurants = forObject.getBody();
			logger.info("status code: {} ", forObject.getStatusCode());

			// 2. set Restaurants for ratingId

			rating.setRestaurants(restaurants);

			// 3. return rating

			return rating;

		}).collect(Collectors.toList());

		// DYNAMIC ENDED HERE.

		user.setRatings(ratingList);

		return user;
	}

}
