package com.app.DAOIMPLEMENTS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.DAO.OrderDAO;
import com.app.model.Order;
import com.app.util.DBconnection;

public class OrderDAOIMPLEMENTS implements OrderDAO {

	private static final String ADD_ORDER =
			"INSERT INTO orders(userid,restaurantid,totalamount,status,paymentmode,imagepath,razorpay_payment_id,razorpay_order_id,payment_status) VALUES(?,?,?,?,?,?,?,?,?)";

private static final String GET_ORDER =
        "SELECT * FROM orders WHERE orderid=?";

private static final String GET_ALL_ORDERS =
        "SELECT * FROM orders";

private static final String GET_ORDERS_BY_USER =
        "SELECT * FROM orders WHERE userid=?";

private static final String UPDATE_ORDER_STATUS =
        "UPDATE orders SET status=? WHERE orderid=?";

private static final String DELETE_ORDER =
        "DELETE FROM orders WHERE orderid=?";

@Override
public int addOrder(Order order) {

    Connection con = DBconnection.getconnection();

    try {

        PreparedStatement pstmt =
                con.prepareStatement(
                        ADD_ORDER,
                        Statement.RETURN_GENERATED_KEYS);

        pstmt.setInt(1, order.getUserId());
        pstmt.setInt(2, order.getRestaurantId());
        pstmt.setDouble(3, order.getTotalAmount());
        pstmt.setString(4, order.getStatus());
        pstmt.setString(5, order.getPaymentMode());
        pstmt.setString(6, order.getImagePath());

        pstmt.setString(7, order.getRazorpayPaymentId());
        pstmt.setString(8, order.getRazorpayOrderId());
        pstmt.setString(9, order.getPaymentStatus());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();

        if(rs.next()) {
            return rs.getInt(1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return 0;
}
@Override
public Order getOrder(int orderId) {

    Connection con =
            DBconnection.getconnection();

    Order order = null;

    try {

        PreparedStatement pstmt =
                con.prepareStatement(GET_ORDER);

        pstmt.setInt(1, orderId);

        ResultSet rs =
                pstmt.executeQuery();

        if(rs.next()) {

            order = new Order();

            order.setOrderId(
                    rs.getInt("orderid"));

            order.setUserId(
                    rs.getInt("userid"));

            order.setRestaurantId(
                    rs.getInt("restaurantid"));

            order.setOrderDate(
                    rs.getTimestamp("orderdate"));

            order.setTotalAmount(
                    rs.getDouble("totalamount"));

            order.setStatus(
                    rs.getString("status"));

            order.setPaymentMode(
                    rs.getString("paymentmode"));

            order.setImagePath(
                    rs.getString("imagepath"));
            order.setRazorpayPaymentId(
                    rs.getString("razorpay_payment_id"));

            order.setRazorpayOrderId(
                    rs.getString("razorpay_order_id"));

            order.setPaymentStatus(
                    rs.getString("payment_status"));
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return order;
}

@Override
public List<Order> getAllOrders() {

    Connection con =
            DBconnection.getconnection();

    List<Order> orderList =
            new ArrayList<>();

    try {

        Statement stmt =
                con.createStatement();

        ResultSet rs =
                stmt.executeQuery(GET_ALL_ORDERS);

        while(rs.next()) {

            Order order =
                    new Order();

            order.setOrderId(
                    rs.getInt("orderid"));

            order.setUserId(
                    rs.getInt("userid"));

            order.setRestaurantId(
                    rs.getInt("restaurantid"));

            order.setOrderDate(
                    rs.getTimestamp("orderdate"));

            order.setTotalAmount(
                    rs.getDouble("totalamount"));

            order.setStatus(
                    rs.getString("status"));

            order.setPaymentMode(
                    rs.getString("paymentmode"));

            order.setImagePath(
                    rs.getString("imagepath"));
            order.setRazorpayPaymentId(
                    rs.getString("razorpay_payment_id"));

            order.setRazorpayOrderId(
                    rs.getString("razorpay_order_id"));

            order.setPaymentStatus(
                    rs.getString("payment_status"));

            orderList.add(order);
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return orderList;
}

@Override
public List<Order> getOrdersByUserId(int userId) {

    Connection con =
            DBconnection.getconnection();

    List<Order> orderList =
            new ArrayList<>();

    try {

        PreparedStatement pstmt =
                con.prepareStatement(
                        GET_ORDERS_BY_USER);

        pstmt.setInt(1, userId);

        ResultSet rs =
                pstmt.executeQuery();

        while(rs.next()) {

            Order order =
                    new Order();

            order.setOrderId(
                    rs.getInt("orderid"));

            order.setUserId(
                    rs.getInt("userid"));

            order.setRestaurantId(
                    rs.getInt("restaurantid"));

            order.setOrderDate(
                    rs.getTimestamp("orderdate"));

            order.setTotalAmount(
                    rs.getDouble("totalamount"));

            order.setStatus(
                    rs.getString("status"));

            order.setPaymentMode(
                    rs.getString("paymentmode"));

            order.setImagePath(
                    rs.getString("imagepath"));
            order.setRazorpayPaymentId(
                    rs.getString("razorpay_payment_id"));

            order.setRazorpayOrderId(
                    rs.getString("razorpay_order_id"));

            order.setPaymentStatus(
                    rs.getString("payment_status"));

            orderList.add(order);
        }

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return orderList;
}

@Override
public boolean updateOrderStatus(
        int orderId,
        String status) {

    Connection con =
            DBconnection.getconnection();

    try {

        PreparedStatement pstmt =
                con.prepareStatement(
                        UPDATE_ORDER_STATUS);

        pstmt.setString(1, status);
        pstmt.setInt(2, orderId);

        int i =
                pstmt.executeUpdate();

        return i > 0;

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return false;
}

@Override
 public boolean deleteOrder(int orderId) {

    Connection con =
            DBconnection.getconnection();

    try {

        PreparedStatement pstmt =
                con.prepareStatement(
                        DELETE_ORDER);

        pstmt.setInt(1, orderId);

        int i =
                pstmt.executeUpdate();

        return i > 0;

    } catch (SQLException e) {

        e.printStackTrace();
    }

    return false;
}


}
