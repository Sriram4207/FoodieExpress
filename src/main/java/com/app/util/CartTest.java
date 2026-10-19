package com.app.util;

import java.util.List;


import com.app.DAOIMPLEMENTS.CartDAOIMPLEMENTS;
import com.app.model.Cart;

public class CartTest {

    public static void main(String[] args) {

        CartDAOIMPLEMENTS dao =
                new CartDAOIMPLEMENTS();

        System.out.println("===== ADD CART ITEM =====");

        Cart cart = new Cart();

        cart.setUserId(17);
        cart.setMenuId(1);
        cart.setQuantity(2);

        dao.addCartItem(cart);

        System.out.println("\n===== GET CART ITEM =====");

        Cart c = dao.getCartItem(1);

        if(c != null) {
            System.out.println(c);
        }

        System.out.println("\n===== GET CART BY USER =====");

        List<Cart> cartList =
                dao.getCartByUserId(17);

        for(Cart item : cartList) {
            System.out.println(item);
        }

        System.out.println("\n===== UPDATE CART ITEM =====");

        Cart updateCart = new Cart();

        updateCart.setCartId(1);
        updateCart.setQuantity(5);

        dao.updateCartItem(updateCart);

        System.out.println("\n===== DELETE CART ITEM =====");

        dao.deleteCartItem(1);

        System.out.println("\n===== CLEAR CART =====");

        dao.clearCart(17);
    }
}