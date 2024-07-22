package com.userservice.entities;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ratings {

	private long ratingId;
	private long userId;
	private long restaurantId;
	private String feedback;
	private double ratings;

	@Transient
	Restaurants restaurants;

}
