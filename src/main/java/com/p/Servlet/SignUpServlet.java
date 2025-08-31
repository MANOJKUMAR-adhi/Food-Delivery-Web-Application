package com.p.Servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.p.DAOImpl.UserDAOimpl;
import com.p.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			   // 1. Get form data
			  	String name = request.getParameter("name");
		        String userName = request.getParameter("userName");
		        String password = request.getParameter("password");
		        String email = request.getParameter("email");
		        String phoneNumber = request.getParameter("phoneNumber");
		        String address = request.getParameter("address");
		        String role = request.getParameter("role"); // Optional field
		        // 2. Create User object 
		        User user=new User();
		        user.setName(name);
		        user.setUserName(userName);
		        user.setPassword(password);
		        user.setEmail(email);
		        user.setPhoneNumber(phoneNumber);
		        user.setAddress(address);
		        user.setRole(role);
		        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		        user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
		     // 3. Add user using DAO
		        UserDAOimpl impl = new UserDAOimpl();
		        
		     
		        impl.addUser(user);
		     // 4. Redirect or show message
		        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		        rd.forward(request, response);
		        
		        System.out.println("New User add Succesfully!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}