<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.app.model.Restaurant" %>

<%
List<Restaurant> restaurantList =
(List<Restaurant>) request.getAttribute("restaurantList");

if(restaurantList == null){
    response.sendRedirect("home.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Restaurants</title>

<link rel="stylesheet" href="app.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="restaurant-header">

    <h1>🍽 Explore Restaurants</h1>

    <p>
        Discover the best restaurants near you
    </p>

</section>

<section class="restaurant-grid">

<%
for(Restaurant r : restaurantList){
%>

<div
    class="restaurant-card"
    onclick="location.href='MenuServlet?restaurantId=<%= r.getRestaurantid() %>'">

    <img
        src="<%= r.getImagepath() %>"
        alt="<%= r.getName() %>"
        class="restaurant-img">

    <div class="restaurant-content">

        <div class="restaurant-top">

            <h2>
                <%= r.getName() %>
            </h2>

            <span class="rating">
                ⭐ <%= r.getRating() %>
            </span>

        </div>

        <p class="cuisine">
            <%= r.getCuisinetype() %>
        </p>

        <div class="restaurant-meta">

            <span>
                🕒 <%= r.getDeliverytime() %> mins
            </span>

            <span class="status">
                <%= (r.getIsactive() == 1) ? "Open" : "Closed" %>
            </span>

        </div>

    </div>

</div>

<%
}
%>

</section>

</body>

</html>