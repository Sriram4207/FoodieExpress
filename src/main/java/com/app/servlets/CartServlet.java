package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.DAOIMPLEMENTS.CartDAOIMPLEMENTS;
import com.app.model.Cart;
import com.app.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

private CartDAOIMPLEMENTS cartDAO;

@Override
public void init() throws ServletException {

    cartDAO = new CartDAOIMPLEMENTS();
}

@Override
protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session =
            request.getSession(false);

    if(session == null ||
       session.getAttribute("user") == null) {

        response.sendRedirect("login.html");
        return;
    }

    User user =
            (User) session.getAttribute("user");

    int userId =
            user.getUserid();

    List<Cart> cartList =
            cartDAO.getCartByUserId(userId);

    request.setAttribute(
            "cartList",
            cartList);

    RequestDispatcher rd =
            request.getRequestDispatcher(
                    "cart.jsp");

    rd.forward(request,
            response);
}

@Override
protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session =
            request.getSession(false);

    if(session == null ||
       session.getAttribute("user") == null) {

        response.sendRedirect("login.html");
        return;
    }

    User user =
            (User) session.getAttribute("user");

    int userId =
            user.getUserid();

    String action =
            request.getParameter("action");

    if(action != null) {

        int cartId =
                Integer.parseInt(
                request.getParameter("cartId"));

        Cart cart =
                cartDAO.getCartItem(cartId);

        if(cart != null) {

            if(action.equals("increase")) {

                cart.setQuantity(
                        cart.getQuantity() + 1);

                cartDAO.updateCartItem(cart);
            }

            else if(action.equals("decrease")) {

                if(cart.getQuantity() > 1) {

                    cart.setQuantity(
                            cart.getQuantity() - 1);

                    cartDAO.updateCartItem(cart);

                } else {

                    cartDAO.deleteCartItem(cartId);
                }
            }

            else if(action.equals("delete")) {

                cartDAO.deleteCartItem(cartId);
            }
        }

        response.sendRedirect("CartServlet");
        return;
    }

    int menuId =
            Integer.parseInt(
            request.getParameter("menuId"));

    int restaurantId =
            Integer.parseInt(
            request.getParameter("restaurantId"));

    int quantity =
            Integer.parseInt(
            request.getParameter("quantity"));

    Cart cart = new Cart();

    cart.setUserId(userId);
    cart.setMenuId(menuId);
    cart.setQuantity(quantity);

    cartDAO.addCartItem(cart);

    response.sendRedirect(
            "MenuServlet?restaurantId="
            + restaurantId);
}


}
