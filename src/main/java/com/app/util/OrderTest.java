package com.app.util;

import java.util.List;

import com.app.DAOIMPLEMENTS.OrderDAOIMPLEMENTS;
import com.app.model.Order;

public class OrderTest {

    public static void main(String[] args) {

        OrderDAOIMPLEMENTS dao = new OrderDAOIMPLEMENTS();

        System.out.println("===== ADD ORDER =====");

        Order order = new Order();

        order.setUserId(3);
        order.setRestaurantId(1);
        order.setTotalAmount(450.0);
        order.setStatus("Pending");
        order.setPaymentMode("Cash");

        int orderId = dao.addOrder(order);

        System.out.println("Generated Order ID : " + orderId);

        System.out.println("\n===== GET ORDER =====");

        Order fetchedOrder = dao.getOrder(orderId);

        if(fetchedOrder != null) {
            System.out.println(fetchedOrder);
        }

        System.out.println("\n===== GET ALL ORDERS =====");

        List<Order> orderList = dao.getAllOrders();

        for(Order o : orderList) {
            System.out.println(o);
        }

        System.out.println("\n===== GET ORDERS BY USER ID =====");

        List<Order> userOrders = dao.getOrdersByUserId(3);

        for(Order o : userOrders) {
            System.out.println(o);
        }

        System.out.println("\n===== UPDATE STATUS =====");

        boolean updated =
                dao.updateOrderStatus(orderId, "Delivered");

        System.out.println("Status Updated : " + updated);

        System.out.println("\n===== DELETE ORDER =====");

        boolean deleted =
                dao.deleteOrder(orderId);

        System.out.println("Order Deleted : " + deleted);
    }
}