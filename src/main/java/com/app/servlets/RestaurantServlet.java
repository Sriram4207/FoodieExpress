package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.DAOIMPLEMENTS.RestaurantDAOIMPLEMENTS;
import com.app.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {

private RestaurantDAOIMPLEMENTS dao;

@Override
public void init() throws ServletException {
    dao = new RestaurantDAOIMPLEMENTS();
}

@Override
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException 
{

    List<Restaurant> restaurantList =
            dao.getAllRestaurants();

    request.setAttribute("restaurantList", restaurantList);

    RequestDispatcher rd =
            request.getRequestDispatcher("restaurants.jsp");

    rd.forward(request, response);
}

}
