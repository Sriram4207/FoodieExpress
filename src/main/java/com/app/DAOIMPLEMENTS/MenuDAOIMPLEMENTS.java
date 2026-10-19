package com.app.DAOIMPLEMENTS;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.app.DAO.MenuDAO;
import com.app.model.Menu;
import com.app.util.DBconnection;

public class MenuDAOIMPLEMENTS implements MenuDAO {

    private static final String INSERT_MENU =
            "INSERT INTO menu(restaurantid,itemname,description,price,isavailable,imagepath) VALUES(?,?,?,?,?,?)";

    private static final String GET_MENU =
            "SELECT * FROM menu WHERE menuid=?";

    private static final String GET_ALL_MENUS =
            "SELECT * FROM menu";

    private static final String GET_MENU_BY_RESTAURANT =
            "SELECT * FROM menu WHERE restaurantid=?";

    private static final String UPDATE_MENU =
            "UPDATE menu SET restaurantid=?, itemname=?, description=?, price=?, isavailable=?, imagepath=? WHERE menuid=?";

    private static final String DELETE_MENU =
            "DELETE FROM menu WHERE menuid=?";

    @Override
    public void addMenuItem(Menu menu) {

        try(Connection con = DBconnection.getconnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_MENU)) {

            pstmt.setInt(1, menu.getRestaurantid());
            pstmt.setString(2, menu.getItemname());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setInt(5, menu.getIsavailable());
            pstmt.setString(6, menu.getImagepath());

            pstmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int menuid) {

        Menu menu = null;

        try(Connection con = DBconnection.getconnection();
            PreparedStatement pstmt = con.prepareStatement(GET_MENU)) {

            pstmt.setInt(1, menuid);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                menu = new Menu();

                menu.setMenuid(rs.getInt("menuid"));
                menu.setRestaurantid(rs.getInt("restaurantid"));
                menu.setItemname(rs.getString("itemname"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setIsavailable(rs.getInt("isavailable"));
                menu.setImagepath(rs.getString("imagepath"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    @Override
    public List<Menu> getAllMenus() {

        List<Menu> menuList = new ArrayList<>();

        try(Connection con = DBconnection.getconnection();
            PreparedStatement pstmt = con.prepareStatement(GET_ALL_MENUS)) {

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                Menu menu = new Menu();

                menu.setMenuid(rs.getInt("menuid"));
                menu.setRestaurantid(rs.getInt("restaurantid"));
                menu.setItemname(rs.getString("itemname"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setIsavailable(rs.getInt("isavailable"));
                menu.setImagepath(rs.getString("imagepath"));

                menuList.add(menu);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public List<Menu> getMenuByRestaurantId(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        try(Connection con = DBconnection.getconnection();
            PreparedStatement pstmt = con.prepareStatement(GET_MENU_BY_RESTAURANT)) {

            pstmt.setInt(1, restaurantId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                Menu menu = new Menu();

                menu.setMenuid(rs.getInt("menuid"));
                menu.setRestaurantid(rs.getInt("restaurantid"));
                menu.setItemname(rs.getString("itemname"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setIsavailable(rs.getInt("isavailable"));
                menu.setImagepath(rs.getString("imagepath"));

                menuList.add(menu);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public void updateMenu(Menu menu) {

        try(Connection con = DBconnection.getconnection();
            PreparedStatement pstmt = con.prepareStatement(UPDATE_MENU)) {

            pstmt.setInt(1, menu.getRestaurantid());
            pstmt.setString(2, menu.getItemname());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setInt(5, menu.getIsavailable());
            pstmt.setString(6, menu.getImagepath());
            pstmt.setInt(7, menu.getMenuid());

            pstmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuid) {

        try(Connection con = DBconnection.getconnection();
            PreparedStatement pstmt = con.prepareStatement(DELETE_MENU)) {

            pstmt.setInt(1, menuid);

            pstmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}