package com.app.util;

import java.util.List;


import com.app.DAOIMPLEMENTS.RestaurantDAOIMPLEMENTS;
import com.app.model.Restaurant;

public class RestaurantTest {

    public static void main(String[] args) {

        RestaurantDAOIMPLEMENTS dao =
                new RestaurantDAOIMPLEMENTS();

        // ADD RESTAURANT

        Restaurant r = new Restaurant(
                "Pizza Hut",
                "Italian",
                30,
                "Bangalore",
                4.5,
                1,
                "pizza.jpg"
        );

        dao.addRestaurant(r);

        // GET ONE RESTAURANT

        Restaurant res = dao.getRestaurant(1);

        System.out.println("Single Restaurant:");
        System.out.println(res);

        // UPDATE RESTAURANT

        Restaurant updateRes =
                dao.getRestaurant(1);

        if(updateRes != null) {

            updateRes.setName("Dominos");
            updateRes.setRating(4.8);

            dao.updateRestaurant(updateRes);
        }

        // GET ALL RESTAURANTS

        List<Restaurant> list =
                dao.getAllRestaurants();

        System.out.println("\nAll Restaurants:");

        for(Restaurant restaurant : list) {

            System.out.println(restaurant);
        }

        // DELETE RESTAURANT

        // dao.deleteRestaurant(1);

    }
}