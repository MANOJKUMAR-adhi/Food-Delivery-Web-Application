package com.p.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.p.DAO.RestaurantDAO;
import com.p.models.Restaurant;
import com.p.util.DBConnection;

public class RestaurantDAOimpl implements RestaurantDAO{
	
	private String ADD_RES="INSERT into `restaurant`(`name`,`address`,`phoneNumber`,`rating`,`isActive`,`userId`,`cusineType`,`eta`,`imagePath`) VALUES(?,?,?,?,?,?,?,?,?)";
	private String UPDATE_RES="UPDATE `restaurant` SET `name`=?,`address`=?,`phoneNumber`=?,`rating`=?,`isActive`=?,`userId`=?,`cusineType`=?,`eta`=?,`imagePath`=? WHERE `restaurantId`=?";
	private String GET_RES="SELECT * FROM `restaurant` WHERE `restaurantId`=?";
	private String DELETE="DELETE FROM `restaurant` WHERE `restaurantId`=?";
	private String GET_ALL_RES="SELECT * FROM `restaurant`";
	private Restaurant restaurant;

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(ADD_RES);) {
				
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhoneNumber());
			pstmt.setString(4, restaurant.getRating());
			pstmt.setBoolean(5, restaurant.getIsActive());
			pstmt.setInt(6, restaurant.getUserId());
			pstmt.setString(7, restaurant.getCusineType());
			pstmt.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			pstmt.setString(9, restaurant.getImagePath());
			
			int res=pstmt.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(UPDATE_RES);) {
			
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhoneNumber());
			pstmt.setString(4, restaurant.getRating());
			pstmt.setBoolean(5, restaurant.getIsActive());
			pstmt.setInt(6, restaurant.getUserId());
			pstmt.setString(7, restaurant.getCusineType());
			pstmt.setString(8,restaurant.getEta());
			pstmt.setString(9, restaurant.getImagePath());
			pstmt.setInt(10, restaurant.getRestaurantId());
			
			int res=pstmt.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int id) {
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(DELETE);) {
			
			pstmt.setInt(1, id);
			
			int res=pstmt.executeUpdate();
			System.out.println("Restaurant is Deleted"+res);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurant(int id) {
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(GET_RES);) {
			
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			
				int rId=res.getInt(1);
				String name=res.getString(2);
				String address=res.getString(3);
				String phoneNumber=res.getString(4);
				String rating=res.getString(5);
				Boolean isActive=res.getBoolean(6);
				int userId=res.getInt(7);
				String cusineType=res.getString(8);
				String eta=res.getString(9);
				String imagePath=res.getString(10);
				
				
				 restaurant= new Restaurant(rId, name, address, phoneNumber, rating, isActive, userId, cusineType, eta, imagePath);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> li=new ArrayList<>();
		
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt= con.prepareStatement(GET_ALL_RES);) {
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				int rId=res.getInt("restaurantId");
				String name=res.getString("name");
				String address=res.getString("address");
				String phoneNumber=res.getString("phoneNumber");
				String rating=res.getString("rating");
				Boolean isActive=res.getBoolean("isActive");
				int userId=res.getInt("userId");
				String cusineType=res.getString(8);
				String eta=res.getString(9);
				String imagePath=res.getString(10);
				
				 restaurant= new Restaurant(rId, name, address, phoneNumber, rating, isActive, userId, cusineType, eta, imagePath);
				 li.add(restaurant);
				 
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return li;
	}
}