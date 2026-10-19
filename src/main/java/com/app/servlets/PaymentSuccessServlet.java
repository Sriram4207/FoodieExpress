package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.DAOIMPLEMENTS.CartDAOIMPLEMENTS;
import com.app.DAOIMPLEMENTS.OrderDAOIMPLEMENTS;
import com.app.model.Cart;
import com.app.model.Order;
import com.app.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PaymentSuccessServlet")
public class PaymentSuccessServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private CartDAOIMPLEMENTS cartDAO;
    private OrderDAOIMPLEMENTS orderDAO;

    @Override
    public void init() throws ServletException {

        cartDAO = new CartDAOIMPLEMENTS();
        orderDAO = new OrderDAOIMPLEMENTS();
    }

    @Override
    protected void doPost(HttpServletRequest request,
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

        String paymentId =
                request.getParameter("razorpay_payment_id");

        String razorpayOrderId =
                request.getParameter("razorpay_order_id");

        String signature =
                request.getParameter("razorpay_signature");

        System.out.println("Payment ID : " + paymentId);
        System.out.println("Order ID : " + razorpayOrderId);
        System.out.println("Signature : " + signature);

        // TODO:
        // Verify Razorpay Signature here later

        double totalAmount = 0;

        for (Cart cart : cartList) {

            totalAmount +=
                    cart.getPrice() * cart.getQuantity();
        }

        Cart firstItem = cartList.get(0);

        Order order = new Order();

        order.setUserId(user.getUserid());

        order.setRestaurantId(
                firstItem.getRestaurantId());

        order.setTotalAmount(totalAmount);

        order.setStatus("Preparing");

        order.setPaymentMode("Online");

        order.setPaymentStatus("Paid");

        order.setImagePath(
                firstItem.getImagePath());

        order.setRazorpayPaymentId(paymentId);

        order.setRazorpayOrderId(razorpayOrderId);

        int orderId = orderDAO.addOrder(order);

        if (orderId > 0) {

            cartDAO.clearCart(user.getUserid());

            response.sendRedirect(
                    "OrderServlet?action=view");
        }
        else {

            response.getWriter().println(
                    "Unable to place order.");
        }
    }
}