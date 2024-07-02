package com.userservice.services;

import java.util.List;

import com.userservice.entities.Users;

public interface UserServices {
	
	Users addUser(Users u);
	
	List<Users> getAllUsers();
	
	Users findUserById(long userId);
}
