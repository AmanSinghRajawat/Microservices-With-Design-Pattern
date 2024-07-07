package com.userservice.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurants {

	private long restaurantId;
	private String restaurantName;
	private String address;
	private String city;
	private List<String> menus;
	private boolean nonVeg;

	

}
