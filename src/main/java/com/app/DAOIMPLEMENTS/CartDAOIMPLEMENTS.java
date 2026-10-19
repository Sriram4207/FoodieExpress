package com.app.DAOIMPLEMENTS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.DAO.CartDAO;
import com.app.model.Cart;
import com.app.util.DBconnection;

public class CartDAOIMPLEMENTS implements CartDAO {

    private static final String ADD_CART =
            "INSERT INTO cart(userid,menuid,quantity) VALUES(?,?,?)";

    private static final String GET_CART =
            "SELECT * FROM cart WHERE cartid=?";

    private static final String GET_CART_BY_USER =
            "SELECT c.*, m.restaurantid, m.itemname, m.price, m.imagepath " +
            "FROM cart c " +
            "JOIN menu m ON c.menuid = m.menuid " +
            "WHERE c.userid=?";
    private static final String UPDATE_CART =
            "UPDATE cart SET quantity=? WHERE cartid=?";

    private static final String DELETE_CART =
            "DELETE FROM cart WHERE cartid=?";

    private static final String CLEAR_CART =
            "DELETE FROM cart WHERE userid=?";

    @Override
    public void addCartItem(Cart cart) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(ADD_CART);

            pstmt.setInt(1, cart.getUserId());
            pstmt.setInt(2, cart.getMenuId());
            pstmt.setInt(3, cart.getQuantity());

            int i = pstmt.executeUpdate();

            System.out.println(i +
                    " Cart Item Added Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cart getCartItem(int cartId) {

        Connection con = DBconnection.getconnection();

        Cart cart = null;

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(GET_CART);

            pstmt.setInt(1, cartId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                cart = new Cart();

                cart.setCartId(rs.getInt("cartid"));
                cart.setUserId(rs.getInt("userid"));
                cart.setMenuId(rs.getInt("menuid"));
                cart.setQuantity(rs.getInt("quantity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cart;
    }

    @Override
    public List<Cart> getCartByUserId(int userId) {

        Connection con = DBconnection.getconnection();

        List<Cart> cartList = new ArrayList<>();

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(GET_CART_BY_USER);

            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                Cart cart = new Cart();

                cart.setCartId(rs.getInt("cartid"));
                cart.setUserId(rs.getInt("userid"));
                cart.setMenuId(rs.getInt("menuid"));
                cart.setRestaurantId(rs.getInt("restaurantid"));
                cart.setQuantity(rs.getInt("quantity"));

                cart.setItemName(
                        rs.getString("itemname"));

                cart.setPrice(
                        rs.getDouble("price"));

                cart.setImagePath(
                        rs.getString("imagepath"));
                
                
                cartList.add(cart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }

    @Override
    public void updateCartItem(Cart cart) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(UPDATE_CART);

            pstmt.setInt(1, cart.getQuantity());
            pstmt.setInt(2, cart.getCartId());

            int i = pstmt.executeUpdate();

            System.out.println(i +
                    " Cart Item Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCartItem(int cartId) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(DELETE_CART);

            pstmt.setInt(1, cartId);

            int i = pstmt.executeUpdate();

            System.out.println(i +
                    " Cart Item Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearCart(int userId) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(CLEAR_CART);

            pstmt.setInt(1, userId);

            int i = pstmt.executeUpdate();

            System.out.println(i +
                    " Cart Items Cleared");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}