package com.p.DAO;

import java.util.List;

import com.p.models.Restaurant;

public interface RestaurantDAO {
	
	void addRestaurant(Restaurant restaurant);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int id);
	Restaurant getRestaurant(int id);
	List<Restaurant> getAllRestaurants();

}