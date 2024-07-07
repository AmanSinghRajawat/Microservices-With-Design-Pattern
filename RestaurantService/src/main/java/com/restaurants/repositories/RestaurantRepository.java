package com.restaurants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurants.entities.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {

}
