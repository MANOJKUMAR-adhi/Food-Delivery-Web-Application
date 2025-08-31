package com.p.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p.DAO.OrdersItemDAO;
import com.p.models.OrdersItem;
import com.p.util.DBConnection;

public class OrderItemDAOImpl implements OrdersItemDAO{
	
	private String INSERT="INSERT INTO `ordersItem`(`ordersId`,`menuId`,`quantity`,`totalPrize`) VALUES(?,?,?,?)";
	private String UPDATE="UPDATE `ordersItem` SET `ordersId`=?,`menuId`=?,`quantity`=?,`totalPrize`=? WHERE `ordersItemId`=?";
	private String DELETE_ORDERS_ITEM="DELETE FROM `ordersItem` WHERE `ordersItemId`=?";
	private String GET_ORDERSITEM="SELECT * FROM `ordersItem` WHERE `ordersItemId`=?";
	private String GET_ALL_ORDERITEMS="SELECT * FROM `ordersItem`";
	private OrdersItem ordersItem;
	
	@Override
	public void addOrdersItem(OrdersItem ordersItem) {
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT);) {
			
			pstmt.setInt(1,ordersItem.getOrdersId());
			pstmt.setInt(2, ordersItem.getMenuId());
			pstmt.setInt(3, ordersItem.getQuantity());
			pstmt.setInt(4, ordersItem.getTotalPrize());
			
			int res = pstmt.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateOrdersItem(OrdersItem ordersItem) {
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE);) {
			
			pstmt.setInt(1,ordersItem.getOrdersId());
			pstmt.setInt(2, ordersItem.getMenuId());
			pstmt.setInt(3, ordersItem.getQuantity());
			pstmt.setInt(4, ordersItem.getTotalPrize());
			pstmt.setInt(5, ordersItem.getOrdersItemId());
			
			int res = pstmt.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrdersItem(int id) {
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(DELETE_ORDERS_ITEM);) {
			
			pstmt.setInt(1, id);
			
			int res=pstmt.executeUpdate();
			System.out.println("User is deleted:"+res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public OrdersItem getOrdersItem(int id) {
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ORDERSITEM);){
			
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
		
				int ordersItemid=res.getInt(1);
				int ordersId=res.getInt(2);
				int menuId=res.getInt(3);
				int quantity=res.getInt(4);
				int totalPrize=res.getInt(5);
				ordersItem=new OrdersItem(ordersItemid, ordersId, menuId, quantity, totalPrize);

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ordersItem;
	}

	@Override
	public List<OrdersItem> getAllOrderItems() {
		List<OrdersItem> li=new ArrayList<OrdersItem>();
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_ORDERITEMS);) {
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int ordersItemid=res.getInt(1);
				int ordersId=res.getInt(2);
				int menuId=res.getInt(3);
				int quantity=res.getInt(4);
				int totalPrize=res.getInt(5);
				ordersItem=new OrdersItem(ordersItemid, ordersId, menuId, quantity, totalPrize);
				li.add(ordersItem);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return li;
		}

}