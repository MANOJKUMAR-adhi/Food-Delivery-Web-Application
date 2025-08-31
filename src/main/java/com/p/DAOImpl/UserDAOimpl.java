package com.p.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.p.DAO.UserDAO;
import com.p.models.User;
import com.p.util.DBConnection;

public class UserDAOimpl implements UserDAO {
	
	private String Insert="INSERT into `user`(`name`,`userName`,`password`,`email`,`phoneNumber`,`address`,`role`,`createdDate`,`lastLoginDate`) values(?,?,?,?,?,?,?,?,?)";
	private String GET_USER="SELECT * FROM `user` WHERE `userId`=?";
	private String UPDATE_USER="UPDATE `user` SET `name`=?, `userName`=?, `password`=?, `email`=?,`phoneNumber`=?, `address`=?, `role`=?, `lastLoginDate`=? WHERE `userId`=? ";
	private String DELETE_USER="DELETE FROM `user` WHERE `userId`=?";
	private String GET_ALL_USERS="SELECT * FROM `user`";
	private String CHECK_LOGIN="SELECT* FROM `user` WHERE `userName`=? AND `password`=?";
	private User user;
	
	@Override
	public void addUser(User user) {
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(Insert);) {
			
			//Incomplete query ?? use pstmt
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhoneNumber());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getRole());
			pstmt.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9,new Timestamp(System.currentTimeMillis()));
			
			int res=pstmt.executeUpdate();
			System.out.println(res);

		} catch ( SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {

		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(UPDATE_USER);) {
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhoneNumber());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getRole());
			pstmt.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(9, user.getUserId());
			
			int res=pstmt.executeUpdate();
			System.out.println("The row is Updated: "+res);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int id) {
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(DELETE_USER);) {
			
			pstmt.setInt(1, id);
			
			int res=pstmt.executeUpdate();
			System.out.println("User is deleted"+res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUser(int id) {
		
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt= con.prepareStatement(GET_USER);) {
			
			pstmt.setInt(1, id);
			
			ResultSet res=pstmt.executeQuery();
			
				int uid= res.getInt(1);
				String name=res.getString(2);
				String userName=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phoneNumber=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createDate=res.getTimestamp(9);
				Timestamp loginDate= res.getTimestamp(10);
				
				user=new User(uid,name, userName, password, email, phoneNumber, address, role, createDate, loginDate);

} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> li= new ArrayList<User>();
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(GET_ALL_USERS);) {
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				
				int uid= res.getInt(1);
				String name=res.getString(2);
				String userName=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phoneNumber=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createDate=res.getTimestamp(9);
				Timestamp loginDate= res.getTimestamp(10);
				
				user=new User(uid,name, userName, password, email, phoneNumber, address, role, createDate, loginDate);
				li.add(user); // adding every user into the list
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return li;
}

	@Override
	public User checkLogin(String username, String password) {
		
		try (Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(CHECK_LOGIN);){
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				user=new User();
				user.setUserId(res.getInt(1));
				user.setName(res.getString(2));
				user.setUserName(res.getString(3));
				user.setPassword(res.getString(4));
				user.setEmail(res.getString(5));
				user.setPhoneNumber(res.getString(6));
				user.setAddress(res.getString(7));
				user.setRole(res.getString(8));
				user.setCreatedDate(res.getTimestamp(9));
				user.setLastLoginDate(res.getTimestamp(10));
				
}
			
} 
	catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}