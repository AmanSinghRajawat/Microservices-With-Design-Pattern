package com.ratings.services;

import java.util.List;


import com.ratings.entities.Ratings;

public interface RatingsService {

	Ratings addRatings(Ratings ratings);

	List<Ratings> getAllRatings();

	Ratings findById(long ratingId);

	List<Ratings> findRatingsByUserId(long userId);
	
	List<Ratings> findRatingsByRestaurantId(long restaurantId);
	
	
	//update rating
	Ratings updateRating(long ratingId, Ratings ratings);
	
	//delete rating
	void deleteRating(long ratingId);
	

}
