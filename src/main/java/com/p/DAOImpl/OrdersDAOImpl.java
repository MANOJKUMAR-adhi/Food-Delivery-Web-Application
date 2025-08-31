package com.p.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.p.DAO.OrdersDAO;
import com.p.models.Orders;
import com.p.util.DBConnection;   

public class OrdersDAOImpl implements OrdersDAO{

	private String INSERT="INSERT INTO `orders`(`userId`,`restaurantId`,`orderdate`,`totalAmount`,`status`,`paymentMode`,`Address`) VALUES(?,?,?,?,?,?,?) ";
	private String UPDATE="UPDATE `orders` SET `userId`=?,`restaurantId`=?,`orderDate`=?,`totalAmount`=?,`status`=?,`paymentMode`=?,`Address`=? WHERE `orderId`=?";
	private String DELETE_ORDER="DELETE FROM `orders` WHERE `orderId`=? ";
	private String GET_ORDER="SELECT * FROM `orders` WHERE `orderId`=? ";
	private String GET_ALL_ORDERS="SELECT * FROM `orders`";
	private Orders order;
	int orderId=0;
	
	@Override
	public int addOrder(Orders orders) {
		
		try(Connection con = DBConnection.getConnection();
	 //     PreparedStatement pstmt=con.prepareStatement(INSERT);
			PreparedStatement pstmt=con.prepareStatement(INSERT,java.sql.Statement.RETURN_GENERATED_KEYS);) {
			
			
			pstmt.setInt(1, orders.getUserId());
			pstmt.setInt(2, orders.getRestaurantId());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, orders.getTotalAmount());
			pstmt.setString(5, orders.getStatus());
			pstmt.setString(6, orders.getPaymentMode());
			pstmt.setString(7, orders.getAddress());
			
			int res=pstmt.executeUpdate();
			System.out.println("The row is inserted: "+res);
			
			ResultSet keys=pstmt.getGeneratedKeys();
			while(keys.next()) {
				orderId=keys.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderId;
	}

	@Override
	public void updateOrder(Orders orders) {
		
		try (Connection con = DBConnection.getConnection();
			 PreparedStatement pstmt=con.prepareStatement(UPDATE);){
		
			
			pstmt.setInt(1, orders.getUserId());
			pstmt.setInt(2, orders.getRestaurantId());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, orders.getTotalAmount());
			pstmt.setString(5, orders.getStatus());
			pstmt.setString(6, orders.getPaymentMode());
			pstmt.setString(7, orders.getAddress());
			pstmt.setInt(8, orders.getOrderId());
			
			int res=pstmt.executeUpdate();
			System.out.println("The row is Updated "+res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int id) {
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(DELETE_ORDER);) {
			
			pstmt.setInt(1, id);
			int res=pstmt.executeUpdate();
			System.out.println("User is deleted: "+res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Orders getOrder(int id) {
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(GET_ORDER);) {
			
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			
				int oid=res.getInt(1);
				int userId=res.getInt(2);
				int restaurantId=res.getInt(3);
				Timestamp orderDate=res.getTimestamp(4);
				int totalAmount=res.getInt(5);
				String status=res.getString(6);
				String paymentMode=res.getString(7);
				String address=res.getString(8);
				order =new Orders(oid, userId, restaurantId, orderDate, totalAmount, status, paymentMode,address);
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> li=new ArrayList<Orders>();
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_ORDERS);) {
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int oid=res.getInt(1);
				int userId=res.getInt(2);
				int restaurantId=res.getInt(3);
				Timestamp orderDate=res.getTimestamp(4);
				int totalAmount=res.getInt(5);
				String status=res.getString(6);
				String paymentMode=res.getString(7);
				String address=res.getString(8);
				order =new Orders(oid, userId, restaurantId, orderDate, totalAmount, status, paymentMode,address);			
				li.add(order);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return li;
	}

}