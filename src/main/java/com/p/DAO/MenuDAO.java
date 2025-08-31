package com.p.DAO;

import java.util.List;

import com.p.models.Menu;

public interface MenuDAO {
	
		void addMenu(Menu menu);
		void updateMenu(Menu menu);
		void deleteMenu(int id);
		Menu getMenu(int id);
		List<Menu> getAllMenus();
}