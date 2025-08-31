package com.p.Servlet;

import java.io.IOException;

import com.p.DAOImpl.Cart;
import com.p.DAOImpl.MenuDAOImpl;
import com.p.models.CartItem;
import com.p.models.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		System.out.println("Cart Servlet is called...");
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
       
		
		int newRestaurantId = Integer.parseInt(request.getParameter("restaurantId")) ;
		Integer curentrestaurantId = (Integer) session.getAttribute("restaurantId");

	        
	        if(cart == null || newRestaurantId != curentrestaurantId){
	        	
				cart = new Cart();  // creating cart..
				session.setAttribute("cart", cart);
				session.setAttribute("restaurantId", newRestaurantId);
			}
	        
	        
	        String action = request.getParameter("action");
	        
	        if(action.equals("add")) {
	        	
	    			addItemTocart(request, cart);
	    	}
	        
	    	else if(action.equals("update")) {
	    		
	    		updateCartItem(request, cart);
	    		
	    	}
	    	else if(action.equals("remove")) {
	    		
	    		removeItemFromCart(request, cart);	
	    	}
	
	        response.sendRedirect("cart.jsp");
}
	
	private void addItemTocart(HttpServletRequest request,Cart cart)  {
		
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		MenuDAOImpl menuDAO = new MenuDAOImpl();
		Menu menuItem= menuDAO.getMenu(itemId);
		
		System.out.println("The Menu is calling the Cart Sevlet and ADD "+menuItem);
		
		if(menuItem != null) {
			
			CartItem item = new CartItem(menuItem.getMenuId(),
					menuItem.getRestaurantId(),
					menuItem.getItemName(),
					quantity,
					menuItem.getPrice()
					);
			
			cart.addItem(item); //this method present in cart.java
			
		}
			
		
	}
	
	public void updateCartItem(HttpServletRequest  request,Cart cart) {
		
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
		
	}
	
	
	public void removeItemFromCart(HttpServletRequest  request,Cart cart) {
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		cart.removeitem(itemId);
	}
	
}	
	
	
//	if(action.equals("add")) {
//		
//		
//			addItemTocart(request, cart);
//		 
//	}
//	else if(action.equals("update")) {
//		updateCartItem(request, cart);
//		
//	}
//	
//	else if(action.equals("remove")) {
//		removeItemFromCart(request, cart);
//		
//	}
//	
//	
	
	
//	if(restaurantIdParam!= null) {
//		int newRestaurantId= Integer.parseInt(restaurantIdParam);
//		if(curentrestaurantId== null || !curentrestaurantId.equals(newRestaurantId)) {
//			cart = new Cart();
//			session.setAttribute("cart", cart);
//			session.setAttribute("restaurantId", newRestaurantId);
//		}
//	}
		
		
		
//		
//		try {
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}}