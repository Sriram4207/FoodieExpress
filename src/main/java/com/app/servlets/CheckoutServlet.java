package com.app.servlets;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import com.app.DAOIMPLEMENTS.CartDAOIMPLEMENTS;
import com.app.model.Cart;
import com.app.model.User;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Replace with your actual Razorpay Test Keys
    private static final String KEY_ID = "rzp_test_TFMpmDlexljcau";
    private static final String KEY_SECRET = "TMZ73s95yIkIRZ24YHyceYmp";

    private CartDAOIMPLEMENTS cartDAO;

    @Override
    public void init() throws ServletException {
        cartDAO = new CartDAOIMPLEMENTS();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

        User user = (User) session.getAttribute("user");

        List<Cart> cartList =
                cartDAO.getCartByUserId(user.getUserid());

        if (cartList == null || cartList.isEmpty()) {
            response.sendRedirect("CartServlet");
            return;
        }

        double totalAmount = 0;

        for (Cart cart : cartList) {
            totalAmount +=
                    cart.getPrice() * cart.getQuantity();
        }

        // Store for PlaceOrderServlet / PaymentSuccessServlet
        session.setAttribute("cartList", cartList);
        session.setAttribute("totalAmount", totalAmount);

        try {

            RazorpayClient razorpay =
                    new RazorpayClient(KEY_ID, KEY_SECRET);

            JSONObject options = new JSONObject();

            options.put("amount",
                    (int) (totalAmount * 100));

            options.put("currency", "INR");

            options.put("receipt",
                    "FOODIE_" + System.currentTimeMillis());

            Order razorpayOrder =
                    razorpay.orders.create(options);

            request.setAttribute("key", KEY_ID);
            request.setAttribute("amount",
                    (int) (totalAmount * 100));
            request.setAttribute("currency", "INR");
            request.setAttribute("orderId",
                    razorpayOrder.get("id"));
            request.setAttribute("totalAmount",
                    totalAmount);

            request.getRequestDispatcher("checkout.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error : " + e.getMessage());
        }
    }
}