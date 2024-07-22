package com.ratings.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratings.entities.Ratings;
import com.ratings.repositories.RatingsRepositories;
import com.ratings.services.RatingsService;

//if you remove @component, you will get an ERROR -> Field ratingsService in com.ratings.controllers.RatingsController required a bean of type 'com.ratings.services.RatingsService' that could not be found.

@Service
public class RatingsServiceImpl implements RatingsService {

	@Autowired
	private RatingsRepositories ratingsRepositories;

	@Override
	public Ratings addRatings(Ratings ratings) {
		// TODO Auto-generated method stub
		return ratingsRepositories.save(ratings);
	}

	@Override
	public List<Ratings> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingsRepositories.findAll();
	}

	@Override
	public Ratings findById(long ratingId) {
		// TODO Auto-generated method stub
		return ratingsRepositories.findById(ratingId)
				.orElseThrow(() -> new RuntimeException("record not found : " + ratingId));
	}

	@Override
	public List<Ratings> findRatingsByUserId(long userId) {
		// TODO Auto-generated method stub
		return ratingsRepositories.findByUserId(userId);
	}

	@Override
	public List<Ratings> findRatingsByRestaurantId(long restaurantId) {
		// TODO Auto-generated method stub
		return ratingsRepositories.findByRestaurantId(restaurantId);
	}

	@Override
	public Ratings updateRating(long ratingId, Ratings ratings) {
		// TODO Auto-generated method stub
		Optional<Ratings> rating = ratingsRepositories.findById(ratingId);
		
		if(rating.isPresent()) {
			
			Ratings ratingObj = rating.get();
			
			if(ratings.getFeedback().length() > 0) {
				ratingObj.setFeedback(ratings.getFeedback());
			}
			if(ratings.getRatings() > 0){
				ratingObj.setRatings(ratings.getRatings());
			}
			if(ratings.getRestaurantId() > 0) {
				ratingObj.setRestaurantId(ratings.getRestaurantId());
			}

			if(ratings.getUserId() > 0) {
				ratingObj.setUserId(ratings.getUserId());
			}
			
			ratingsRepositories.save(ratingObj);
			return ratingObj;
		}
		
		return rating.get();
	}

	@Override
	public void deleteRating(long ratingId) {
		// TODO Auto-generated method stub
		ratingsRepositories.deleteById(ratingId);
	}

}
