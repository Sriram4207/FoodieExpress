package com.app.DAO;

import java.util.List;

import com.app.model.Restaurant;

public interface RestaurantDAO {
	
	     void addRestaurant(Restaurant r);

	    Restaurant getRestaurant(int id);

	    List<Restaurant> getAllRestaurants();

	    void updateRestaurant(Restaurant r);

	    void deleteRestaurant(int id);
}
