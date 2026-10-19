<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.app.model.Menu" %>

<%
List<Menu> menuList =
(List<Menu>) request.getAttribute("menuList");

if(menuList == null){
    response.sendRedirect("RestaurantServlet");
    return;
}

String restaurantId =
request.getParameter("restaurantId");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Restaurant Menu</title>

<link rel="stylesheet" href="app.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="menu-header">

    <h1>🍽 Restaurant Menu</h1>

    <p>
        Choose your favorite dishes
    </p>

</section>

<section class="menu-grid">

<%
for(Menu menu : menuList){
%>

<div class="food-card">

    <img
    src="<%= menu.getImagepath() %>"
    alt="<%= menu.getItemname() %>"
    class="food-img">

    <div class="food-content">

        <h2>
            <%= menu.getItemname() %>
        </h2>

        <p class="food-desc">

            <%= menu.getDescription() %>

        </p>

        <div class="food-bottom">

            <div class="food-price">

                ₹ <%= menu.getPrice() %>

            </div>

            <% if(menu.getIsavailable()==1){ %>

                <span class="available-tag">
                    Available
                </span>

            <% } else { %>

                <span class="unavailable-tag">
                    Out Of Stock
                </span>

            <% } %>

        </div>

        <form
        action="CartServlet"
        method="post">

            <input
            type="hidden"
            name="menuId"
            value="<%=menu.getMenuid()%>">

            <input
            type="hidden"
            name="restaurantId"
            value="<%=restaurantId%>">

            <input
            type="hidden"
            name="quantity"
            value="1">

            <button
            type="submit"
            class="add-btn">

                Add To Cart

            </button>

        </form>

    </div>

</div>

<%
}
%>

</section>

<div class="menu-actions">

    <a
    href="RestaurantServlet"
    class="continue-btn">

        ← Restaurants

    </a>

    <a
    href="CartServlet"
    class="checkout-btn">

        🛒 View Cart

    </a>

</div>

</body>

</html>