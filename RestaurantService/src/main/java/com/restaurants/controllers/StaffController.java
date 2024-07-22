package com.restaurants.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping
	public List<String> listOfStaff(){
		return new ArrayList<>(Arrays.asList("Aman","Rahul","Hariom","Amit"));
	}
	
}
