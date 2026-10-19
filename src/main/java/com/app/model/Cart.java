package com.app.model;

public class Cart {

    private int cartId;
    private int userId;
    private int menuId;

    // NEW
    private int restaurantId;

    private int quantity;

    private String itemName;
    private double price;
    private String imagePath;

    public Cart() {

    }

    public Cart(int cartId, int userId, int menuId,
            int restaurantId, int quantity,
            String itemName, double price,
            String imagePath) {

        this.cartId = cartId;
        this.userId = userId;
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    // NEW

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId +
                ", userId=" + userId +
                ", menuId=" + menuId +
                ", restaurantId=" + restaurantId +
                ", quantity=" + quantity +
                ", itemName=" + itemName +
                ", price=" + price +
                ", imagePath=" + imagePath + "]";
    }
}