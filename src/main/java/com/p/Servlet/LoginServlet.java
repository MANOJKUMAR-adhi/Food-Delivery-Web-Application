package com.p.Servlet;

import java.io.IOException;

import com.p.DAOImpl.UserDAOimpl;
import com.p.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName= request.getParameter("username");
		String password= request.getParameter("password");
		UserDAOimpl impl = new UserDAOimpl();
		User user=impl.checkLogin(userName, password); 
		HttpSession session = request.getSession();
				
		if(user != null) {
			
			System.out.println("Login Succesfully");
		
			session.setAttribute("username", user.getUserName());
			session.setAttribute("user", user);
			response.sendRedirect("GetAllRestaurantServelet");

		
		}
		else {
			System.out.println("Invalid User Name or Password");
			request.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}