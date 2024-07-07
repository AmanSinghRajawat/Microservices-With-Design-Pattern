package com.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {
	
	private long ratingId;
	private long restaurantId;
	private long userId;
	private String feedback;
	private double ratings;
	
	private Restaurants restaurants;

}
