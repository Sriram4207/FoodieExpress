<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.app.model.Cart"%>

<%
List<Cart> cartList =
(List<Cart>)request.getAttribute("cartList");

int totalItems = 0;
double totalPrice = 0;
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Your Cart</title>

<link rel="stylesheet" href="app.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="cart-page">

<h1>🛒 Your Cart</h1>

<%
if(cartList != null && !cartList.isEmpty()){

for(Cart cart : cartList){

totalItems += cart.getQuantity();

totalPrice +=
cart.getPrice() *
cart.getQuantity();
%>

<div class="cart-card">

    <img
    src="<%= cart.getImagePath() %>"
    class="cart-img">

    <div class="cart-info">

        <h2>
            <%= cart.getItemName() %>
        </h2>

        <p>
            ₹ <%= cart.getPrice() %>
        </p>

        <div class="cart-controls">

            <form action="CartServlet" method="post">

                <input type="hidden"
                name="action"
                value="decrease">

                <input type="hidden"
                name="cartId"
                value="<%=cart.getCartId()%>">

                <button>
                    -
                </button>

            </form>

            <span>
                <%= cart.getQuantity() %>
            </span>

            <form action="CartServlet" method="post">

                <input type="hidden"
                name="action"
                value="increase">

                <input type="hidden"
                name="cartId"
                value="<%=cart.getCartId()%>">

                <button>
                    +
                </button>

            </form>

        </div>

    </div>

    <div>

        <h3>

        ₹ <%= cart.getPrice()
             * cart.getQuantity() %>

        </h3>

    </div>

</div>

<%
}
%>

<div class="cart-summary">

    <h2>
        Order Summary
    </h2>

    <p>
        Total Items:
        <%= totalItems %>
    </p>

    <p>
        Total Amount:
        ₹ <%= totalPrice %>
    </p>

</div>

<%
}
else{
%>

<div class="empty-cart">

    <div class="empty-icon">
        🛒
    </div>

    <h2>
        Your Cart Is Empty
    </h2>

    <p>
        Looks like you haven't added
        anything yet.
    </p>

    <a
    href="RestaurantServlet"
    class="shop-btn">

        Browse Restaurants

    </a>

</div>

<%
}
%>

<div class="cart-actions">

    <a
    href="RestaurantServlet"
    class="continue-btn">

        Continue Shopping

    </a>

    <a href="CheckoutServlet" class="checkout-btn">
    Proceed To Payment
</a>

</div>

</section>

</body>

</html>