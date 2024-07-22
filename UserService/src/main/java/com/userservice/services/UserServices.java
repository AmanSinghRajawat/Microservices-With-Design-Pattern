package com.userservice.services;

import java.util.List;

import com.userservice.entities.Ratings;
import com.userservice.entities.Users;

public interface UserServices {
	
	Users addUser(Users u);
	
	List<Users> getAllUsers();
	
	Users findById(long userId);
	
	// update user
	Users updateUser(long userId, Users users);
	
	// delete user
	String deleteUser(long userId);
	
}
