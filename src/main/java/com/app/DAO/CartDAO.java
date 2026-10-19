package com.app.DAO;

import java.util.List;

import com.app.model.Cart;

public interface CartDAO {

    void addCartItem(Cart cart);

    Cart getCartItem(int cartId);

    List<Cart> getCartByUserId(int userId);

    void updateCartItem(Cart cart);

    void deleteCartItem(int cartId);

    void clearCart(int userId);
}