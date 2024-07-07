package com.ratings.entities;

import java.util.List;

import com.restaurants.entities.Restaurants;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {

	@Id
	private long ratingId;
	private long userId;
	private long restaurantId;
	private String feedback;
	private double ratings;

	@Transient
	List<Restaurants> restaurants;

}
