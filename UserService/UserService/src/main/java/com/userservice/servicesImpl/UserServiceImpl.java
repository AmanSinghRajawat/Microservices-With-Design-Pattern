package com.userservice.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.entities.Users;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	UserRepository userRepository;
		
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



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



	@Override
	public Users findUserById(long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found by given userid : "+userId));
	}

}
