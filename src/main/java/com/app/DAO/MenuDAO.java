package com.app.DAO;

import java.util.List;

import com.app.model.Menu;

public interface MenuDAO {
	
	    
	    void addMenuItem(Menu menu);

	    Menu getMenu(int menuid);

	    List<Menu> getAllMenus();

	    List<Menu> getMenuByRestaurantId(int restaurantId);

	    void updateMenu(Menu menu);

	    void deleteMenu(int menuid);
	}
