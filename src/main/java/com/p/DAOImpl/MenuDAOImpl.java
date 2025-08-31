package com.p.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p.DAO.MenuDAO;
import com.p.models.Menu;
import com.p.util.DBConnection;

public class MenuDAOImpl implements MenuDAO{
	
	
	private String INSERT="INSERT INTO `menu`(`restaurantId`,`itemName`,`description`,`price`,`ratings`,`isAvailable`,`imagePath`) VALUES(?,?,?,?,?,?,?)";
	private String UPDATE="UPDATE `menu` SET `restaurantId`=?,`itemName`=?,`description`=?,`price`=?,`ratings`=?,`isAvailable`=?,`imagePath`=? WHERE `menuId`=?";
	private String DELETE_MENU="DELETE FROM `menu` WHERE `menuId`=?";
	private String GET_MENU="SELECT * FROM `menu` WHERE `menuId`=?";
	private String GET_ALL_MENUS="SELECT * FROM `menu`";
	private Menu menu;
	
	@Override
	public void addMenu(Menu menu) {
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT);) {
			
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setInt(4, menu.getPrice());
			pstmt.setString(5, menu.getRatings());
			pstmt.setBoolean(6, menu.getisAvailable());
			pstmt.setString(7, menu.getImagePath());
			
			int res=pstmt.executeUpdate();
			System.out.println("Menu is added:"+res);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMenu(Menu menu) {
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE);) {
			
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setInt(4, menu.getPrice());
			pstmt.setString(5, menu.getRatings());
			pstmt.setBoolean(6, menu.getisAvailable());
			pstmt.setString(7, menu.getImagePath());
			pstmt.setInt(8, menu.getMenuId());
			
			int res=pstmt.executeUpdate();
			System.out.println("Menu is Updated:"+res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int id) {
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(DELETE_MENU);) {
			
			pstmt.setInt(1, id);
			int res=pstmt.executeUpdate();
			System.out.println("User is deleted"+res);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int id) {
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_MENU);) {
			
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			
				int mid=res.getInt(1);
				int restaurantId=res.getInt(2);
				String itemName=res.getString(3);
				String description=res.getString(4);
				int price=res.getInt(5);
				String rating=res.getString(6);
				boolean isAvailable=res.getBoolean(7);
				String imagePath=res.getString(8);
				
				menu=new Menu(mid, restaurantId, itemName, description, price, rating, isAvailable, imagePath);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<Menu> getAllMenus() {
		List<Menu> li=new ArrayList<Menu>();
		try (Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_MENUS);){
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int mid=res.getInt(1);
				int restaurantId=res.getInt(2);
				String itemName=res.getString(3);
				String description=res.getString(4);
				int price=res.getInt(5);
				String rating=res.getString(6);
				boolean isAvailable=res.getBoolean(7);
				String imagePath=res.getString(8);
				
				menu=new Menu(mid, restaurantId, itemName, description, price, rating, isAvailable, imagePath);
				li.add(menu);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return li;
	}

}
