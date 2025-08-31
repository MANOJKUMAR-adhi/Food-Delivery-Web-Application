package com.p.Servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.p.DAO.OrdersDAO;
import com.p.DAOImpl.Cart;
import com.p.DAOImpl.OrderItemDAOImpl;
import com.p.DAOImpl.OrdersDAOImpl;
import com.p.models.CartItem;
import com.p.models.Orders;
import com.p.models.OrdersItem;
import com.p.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	private OrdersDAO ordersDAO;
	private OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();;

	@Override
		public void init() throws ServletException { // init method is called before service method
		try {
			ordersDAO = new OrdersDAOImpl();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("Failed to start Order DAO Impl",e);
		}
			
		
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Checkout sevlet is called");
		
		
		HttpSession session = request.getSession();
		
		Cart cart=(Cart) session.getAttribute("cart");
		User user=(User) session.getAttribute("user");
		
		
		
		
		if(cart != null && user!=null && !cart.getItems().isEmpty()) {
			
			// Extract from Data
			String paymentMethod = request.getParameter("paymentMethod");
			String address = request.getParameter("address");
			
			//create and populate order object
			Orders order= new Orders();
			
			order.setUserId(user.getUserId());
			order.setRestaurantId( (int)session.getAttribute("restaurantId"));
			order.setOrderDate(new Timestamp(new Date().getTime()));
			order.setAddress(address);
			order.setStatus("Pending");
			order.setPaymentMode(paymentMethod);
	
			//calculate total Amount
			int totalAmount=0; 
			
			for(CartItem item: cart.getItems().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
			}
			order.setTotalAmount(totalAmount);
			
			
			int orderId=ordersDAO.addOrder(order); // add order
			
			for(CartItem item: cart.getItems().values()) {
				OrdersItem oi = new OrdersItem();
				int itemId = item.getItemId();
				String name = item.getName();
				int price = item.getPrice();
				int quantity = item.getQuantity();
				int totalPrice= price*quantity;
				
			
				OrdersItem ordersItem = new OrdersItem(orderId,itemId, quantity, totalPrice);
				orderItemDAOImpl.addOrdersItem(ordersItem);   // add orderitem
				
				
			}
			
			
			session.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("order_confirmation.jsp");
			rd.forward(request, response);
			//session.removeAttribute("cart");
		}
		else {
			if(user==null) {
				 response.sendRedirect("login.jsp");
				 return;
			}
			response.sendRedirect("cart.jsp");
		}
		
		
		
		
	}

}