package com.app.model;

import java.sql.Timestamp;

public class Order {

    private int orderId;
    private int userId;
    private int restaurantId;
    private Timestamp orderDate;
    private double totalAmount;
    private String status;
    private String paymentMode;
    private String imagePath;

    // Razorpay Fields
    private String razorpayPaymentId;
    private String razorpayOrderId;
    private String paymentStatus;

    public Order() {
    }

    public Order(int orderId,
                 int userId,
                 int restaurantId,
                 Timestamp orderDate,
                 double totalAmount,
                 String status,
                 String paymentMode,
                 String imagePath,
                 String razorpayPaymentId,
                 String razorpayOrderId,
                 String paymentStatus) {

        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMode = paymentMode;
        this.imagePath = imagePath;
        this.razorpayPaymentId = razorpayPaymentId;
        this.razorpayOrderId = razorpayOrderId;
        this.paymentStatus = paymentStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Razorpay Payment ID

    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }

    // Razorpay Order ID

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    // Payment Status

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                ", paymentMode=" + paymentMode +
                ", imagePath=" + imagePath +
                ", razorpayPaymentId=" + razorpayPaymentId +
                ", razorpayOrderId=" + razorpayOrderId +
                ", paymentStatus=" + paymentStatus +
                "]";
    }
}