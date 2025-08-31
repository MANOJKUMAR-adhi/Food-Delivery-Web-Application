package com.p.Servlet;

import java.io.IOException;
import java.util.List;

import com.p.DAOImpl.MenuDAOImpl;
import com.p.models.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Menu Servlet is called");
		int rid=Integer.parseInt(request.getParameter("restaurantId"));
		System.out.println("Restaurant Id :"+rid);
		
	  try {
		MenuDAOImpl doaImpl = new MenuDAOImpl();
		
		List<Menu> menuList = doaImpl.getAllMenus();
		request.setAttribute("menus", menuList);
		
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}
}