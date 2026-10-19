<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.app.model.Order"%>

<%
List<Order> orderList =
(List<Order>)request.getAttribute("orderList");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>My Orders</title>

<link rel="stylesheet"
href="<%=request.getContextPath()%>/app.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="overlay">

<h1>📦 My Orders</h1>

<div class="orders-container">

<%
if(orderList != null && !orderList.isEmpty()){

for(Order order : orderList){
%>

<div class="order-card">

<img
src="<%=order.getImagePath()%>"
class="order-image"
alt="Food Image">

<div class="order-info">

<h2>

Order #<%=order.getOrderId()%>

</h2>

<p>

<b>Order Date :</b>

<%=order.getOrderDate()%>

</p>

<p>

<b>Amount :</b>

₹ <%=order.getTotalAmount()%>

</p>

<p>

<b>Payment Mode :</b>

<%=order.getPaymentMode()%>

</p>

<p>

<b>Payment Status :</b>

<%
if("Paid".equalsIgnoreCase(order.getPaymentStatus())){
%>

<span style="color:green;font-weight:bold;">
✅ Paid
</span>

<%
}
else{
%>

<span style="color:orange;font-weight:bold;">
💵 Pending (Cash On Delivery)
</span>

<%
}
%>

</p>

</div>

<div class="status-section">

<%
String status = order.getStatus();

if("Preparing".equalsIgnoreCase(status)){
%>

<span
class="status"
style="background:#ffc107;color:black;">

🍳 Preparing

</span>

<%
}
else if("Out For Delivery".equalsIgnoreCase(status)){
%>

<span
class="status"
style="background:#17a2b8;color:white;">

🛵 Out For Delivery

</span>

<%
}
else if("Delivered".equalsIgnoreCase(status)){
%>

<span
class="status"
style="background:#28a745;color:white;">

✅ Delivered

</span>

<%
}
else{
%>

<span class="status">

<%=status%>

</span>

<%
}
%>

</div>

</div>

<%
}
}
else{
%>

<div class="empty-orders">

<h2>No Orders Found 😔</h2>

<p>

Start ordering your favourite food!

</p>

</div>

<%
}
%>

</div>

<div class="actions">

<a href="RestaurantServlet">

🍽 Continue Shopping

</a>

</div>

</div>

</body>

</html>