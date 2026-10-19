package com.app.DAO;

import java.util.List;

import com.app.model.Order;

public interface OrderDAO {

    int addOrder(Order order);

    Order getOrder(int orderId);

    List<Order> getAllOrders();

    List<Order> getOrdersByUserId(int userId);

    boolean updateOrderStatus(int orderId, String status);

    boolean deleteOrder(int orderId);
}