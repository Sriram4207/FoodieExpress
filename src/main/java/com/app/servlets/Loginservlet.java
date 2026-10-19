package com.app.servlets;

import java.io.IOException;

import com.app.DAOIMPLEMENTS.UserDAOIMPLEMENTS;
import com.app.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginservlet")
public class Loginservlet extends HttpServlet {


@Override
protected void doPost(HttpServletRequest req,
                      HttpServletResponse resp)
                      throws ServletException, IOException {

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    UserDAOIMPLEMENTS dao = new UserDAOIMPLEMENTS();

    User loggedUser =
            dao.loginUser(username, password);

    if(loggedUser != null) {

        HttpSession session =
                req.getSession();

        session.setAttribute("user",
                             loggedUser);

        resp.sendRedirect("home.jsp");

    } else {

        resp.getWriter().println(
            "<h2>Invalid Username or Password</h2>"
        );
    }
}


}
