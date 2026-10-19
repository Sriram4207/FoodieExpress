package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.DAOIMPLEMENTS.OrderDAOIMPLEMENTS;
import com.app.model.Order;
import com.app.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OrderDAOIMPLEMENTS orderDAO;

    @Override
    public void init() throws ServletException {

        orderDAO = new OrderDAOIMPLEMENTS();
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

        int userId = user.getUserid();

        String action = request.getParameter("action");

        if (action == null || !action.equals("view")) {
            response.sendRedirect("OrderServlet?action=view");
            return;
        }

        List<Order> orderList = orderDAO.getOrdersByUserId(userId);

        request.setAttribute("orderList", orderList);

        RequestDispatcher rd =
                request.getRequestDispatcher("orders.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}