package com.app.servlets;

import java.io.IOException;
import java.util.List;

import com.app.DAOIMPLEMENTS.MenuDAOIMPLEMENTS;
import com.app.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {

private MenuDAOIMPLEMENTS menuDAO;

@Override
public void init() throws ServletException {
    menuDAO = new MenuDAOIMPLEMENTS();
}

@Override
protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    int restaurantId =
            Integer.parseInt(
            request.getParameter("restaurantId"));

    List<Menu> menuList =
            menuDAO.getMenuByRestaurantId(restaurantId);

    request.setAttribute("menuList", menuList);

    RequestDispatcher rd =
            request.getRequestDispatcher("menu.jsp");

    rd.forward(request, response);
}


}
