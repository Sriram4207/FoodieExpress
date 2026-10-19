package com.app.util;

import java.util.List;

import com.app.DAO.MenuDAO;
import com.app.DAOIMPLEMENTS.MenuDAOIMPLEMENTS;
import com.app.model.Menu;

public class MenuTest {

    public static void main(String[] args) {

        MenuDAO menuDAO = new MenuDAOIMPLEMENTS();

        // Add Menu Items

        Menu m1 = new Menu(
                1,
                "Chicken Burger",
                "Spicy Chicken Burger",
                199.0,
                1,
                "images/burger.jpg");

        Menu m2 = new Menu(
                1,
                "Veg Burger",
                "Crispy Veg Burger",
                149.0,
                1,
                "images/vegburger.jpg");

        Menu m3 = new Menu(
                1,
                "Margherita Pizza",
                "Classic Cheese Pizza",
                299.0,
                1,
                "images/pizza.jpg");

        Menu m4 = new Menu(
                1,
                "French Fries",
                "Golden Crispy Fries",
                99.0,
                1,
                "images/fries.jpg");

        Menu m5 = new Menu(
                1,
                "Cold Coffee",
                "Chilled Coffee with Ice Cream",
                129.0,
                1,
                "images/coffee.jpg");

        menuDAO.addMenuItem(m1);
        menuDAO.addMenuItem(m2);
        menuDAO.addMenuItem(m3);
        menuDAO.addMenuItem(m4);
        menuDAO.addMenuItem(m5);

        System.out.println("===== MENU ITEMS ADDED =====");

        // Display All Menus

        System.out.println("\n===== GET ALL MENUS =====");

        List<Menu> menuList = menuDAO.getAllMenus();

        for(Menu menu : menuList) {
            System.out.println(menu);
        }
    }
}