package com.ratings.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratings.entities.Ratings;

public interface RatingsRepositories extends JpaRepository<Ratings, Long> {

	List<Ratings> findByUserId(Long userId);
	List<Ratings> findByRestaurantId(Long restaurantId);
}
