package com.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	private long ratingId;
	private long userId;
	private long restaurantId;
	
	private String feedback;
	private int rating;

}
