package com.p.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String URL      = "jdbc:mysql://localhost:3306/food_delivery";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static Connection con;
	
	 public static Connection getConnection(){ 
		
		 try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);  // Establish the conn
		 } 
		 
		 catch (ClassNotFoundException | SQLException e) {
		
			 e.printStackTrace();
		 }
		 return con;
			}	 
}