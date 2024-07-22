package com.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Ratings;
import com.userservice.entities.Restaurants;
import com.userservice.entities.Users;
import com.userservice.fiegnclient.RatingService;
import com.userservice.fiegnclient.RestaurantService;
import com.userservice.services.UserServices;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@GetMapping("/test")
	public String test() {
		return "Hello Users.";
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<Users> addUser(@RequestBody Users u) {
		Users user = userServices.addUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> users = userServices.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	
	@GetMapping("/userid/{userId}")
	public Users getUserById(@PathVariable long userId) {
		return userServices.findById(userId);
	}
	
	
	// update user
	@PutMapping("/users/updateuser/userid/{userId}")
	public Users updateUser(@PathVariable long userId, @RequestBody Users users) {
		return userServices.updateUser(userId, users);
	}
	
	// delete user
	@DeleteMapping("/users/deleteuser/userid/{userId}")
	public String deleteUser(@PathVariable long userId) {
		return userServices.deleteUser(userId);
	}
	
	
	
	// Rating Service

	@PostMapping("/users/addratings")
	public Ratings addRating(@RequestBody Ratings ratings) {
		return ratingService.createRating(ratings);
	}
	
	@PutMapping("/users/updateratings/ratingid/{ratingId}")
	public Ratings updateRatings(@PathVariable long ratingId, @RequestBody Ratings ratings) {		
		return ratingService.updateRatings(ratingId, ratings);
	}

	@DeleteMapping("/users/deleteratings/ratingid/{ratingId}")
	public void deleteRatings(@PathVariable long ratingId) {
		ratingService.deleteRatings(ratingId);
	}
	
	
	// Restaurant Service
	
	@PostMapping("/users/addrestaurant")
	public Restaurants addRestaurant(@RequestBody Restaurants restaurants) {
		return restaurantService.addRestaurant(restaurants);
	}
	
	@PutMapping("/users/updaterestaurant/restaurantid/{restaurantId}")
	public Restaurants updateRestaurant(@PathVariable long restaurantId, @RequestBody Restaurants restaurants) {
		return restaurantService.updateRestaurant(restaurantId, restaurants);
	}
	
	@DeleteMapping("/users/deleterestaurant/restaurantid/{restaurantId}")
	public String deleteRestaurant(@PathVariable long restaurantId) {
		return restaurantService.deleteRestaurant(restaurantId);
	}
	
}
