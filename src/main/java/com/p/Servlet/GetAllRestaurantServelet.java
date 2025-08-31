package com.p.Servlet;

import java.io.IOException;
import java.util.List;

import com.p.DAOImpl.RestaurantDAOimpl;
import com.p.models.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GetAllRestaurantServelet")
public class GetAllRestaurantServelet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Getting All Restaurants...");
		
		try {
			//1.Create object of restaurantDAOIMPL
			RestaurantDAOimpl  rest = new RestaurantDAOimpl();
			
			//2.Get all Restaurant
			List<Restaurant> allRestaurant = rest.getAllRestaurants(); 
			
			//3.put the restaurant list into request object(setAttribute)
			request.setAttribute("restaurants", allRestaurant);
			
			//4.Create a request dispatcher object
			RequestDispatcher rd=request.getRequestDispatcher("restaurant.jsp");
			
			//5.call restaurants.jsp(forward)
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}