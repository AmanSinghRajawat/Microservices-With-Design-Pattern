package com.restaurants.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurants {
	
	@Id
	private long restaurantId;
	private String restaurantName;
	private String address;
	private String city;
	private List<String> menus;
	private boolean nonVeg;	
	

}
