<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.app.model.User" %>

<%
User user = (User) session.getAttribute("user");
%>

<nav class="navbar">

    <a href="home.jsp" class="logo">
        FoodieExpress
    </a>

    <div class="nav-links">

        <a href="home.jsp">
            Home
        </a>

        <a href="RestaurantServlet">
            Restaurants
        </a>

        <% if(user == null){ %>

            <a href="login.html">
                Login
            </a>

            <a href="signup.html" class="signup-btn">
                Sign Up
            </a>

        <% } else { %>

            <a href="CartServlet">
                Cart
            </a>

            <a href="OrderServlet?action=view">
                Orders
            </a>

            <a href="profile.jsp">
                Profile
            </a>

            <a href="logout" class="logout-btn">
                Logout
            </a>

        <% } %>

    </div>

</nav>