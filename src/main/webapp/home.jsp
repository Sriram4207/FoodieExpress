<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.app.model.User" %>

<%
User user = (User) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>🍽 Foodie Express - Home</title>

<link rel="stylesheet" href="app.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<!-- ==========================================
                HERO SECTION
========================================== -->

<section class="hero">

    <div class="hero-content">

        <% if(user != null){ %>

            <h1>
                Welcome, <%= user.getUsername() %> 👋
            </h1>

        <% } else { %>

            <h1>
                Discover Amazing Food Near You 🍕
            </h1>

        <% } %>

        <h2>
            Delicious Food Delivered Fast
        </h2>

        <p>
            Order from your favorite restaurants and get delicious meals
            delivered to your doorstep in minutes.
        </p>

        <a href="RestaurantServlet" class="hero-btn">
            Explore Restaurants
        </a>

    </div>

</section>

<!-- ==========================================
              FOOD CATEGORIES
========================================== -->

<section class="categories">

    <div class="category-card">

        <div class="emoji">🍕</div>

        <h3>Pizza</h3>

        <p>
            Cheesy, crispy and freshly baked pizzas from top restaurants.
        </p>

    </div>

    <div class="category-card">

        <div class="emoji">🍔</div>

        <h3>Burgers</h3>

        <p>
            Juicy burgers packed with delicious flavors and fresh ingredients.
        </p>

    </div>

    <div class="category-card">

        <div class="emoji">🍜</div>

        <h3>Chinese</h3>

        <p>
            Noodles, fried rice, momos and authentic Chinese dishes.
        </p>

    </div>

    <div class="category-card">

        <div class="emoji">🥗</div>

        <h3>Healthy</h3>

        <p>
            Fresh salads and nutritious meals for a healthy lifestyle.
        </p>

    </div>

    <div class="category-card">

        <div class="emoji">🍰</div>

        <h3>Desserts</h3>

        <p>
            Cakes, ice creams and sweet treats to complete your meal.
        </p>

    </div>

</section>

<!-- ==========================================
                  FOOTER
========================================== -->

<footer>

    © 2026 FoodieExpress. All Rights Reserved.

</footer>

</body>

</html>