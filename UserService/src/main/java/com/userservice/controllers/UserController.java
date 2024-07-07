package com.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Users;
import com.userservice.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
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
	

}
