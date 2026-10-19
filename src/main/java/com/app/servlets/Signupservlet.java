package com.app.servlets;

import java.io.IOException;


import com.app.DAOIMPLEMENTS.UserDAOIMPLEMENTS;
import com.app.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signupservlet")
public class Signupservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
                          throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String role = req.getParameter("role");

        User user = new User(
                username,
                password,
                email,
                address,
                role
        );

        UserDAOIMPLEMENTS dao = new UserDAOIMPLEMENTS();

        dao.adduser(user);

        resp.sendRedirect("login.html");
    }
}