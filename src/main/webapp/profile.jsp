<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.app.model.User" %>

<%
User user = (User) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.html");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>My Profile</title>

<link rel="stylesheet" href="app.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<section class="profile-wrapper">

    <div class="profile-card-modern">

        <div class="profile-banner"></div>

        <div class="profile-content">

            <img
            src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
            class="profile-avatar-modern"
            alt="Profile">

            <h1><%= user.getUsername() %></h1>

            <p class="profile-role">
                ⭐ FoodieExpress Customer
            </p>

            <div class="member-status">

                <span class="status">
                    🟢 Active
                </span>

                <span class="member-date">
                    📅 Member Since :
                    <%= user.getCreatedate()!=null ?
                    user.getCreatedate().toLocalDateTime().toLocalDate()
                    : "N/A" %>
                </span>

            </div>

            <!-- Profile Statistics -->

            <div class="profile-stats">

                <div class="stat-card">
                    <h2>12</h2>
                    <p>📦 Orders</p>
                </div>

                <div class="stat-card">
                    <h2>2</h2>
                    <p>🛒 Cart</p>
                </div>

                <div class="stat-card">
                    <h2>5</h2>
                    <p>⭐ Reviews</p>
                </div>

                <div class="stat-card">
                    <h2>8</h2>
                    <p>❤️ Favorites</p>
                </div>

            </div>

            <!-- Profile Information -->

            <div class="profile-info">

                <div class="info-row">
                    <span>👤 Username</span>
                    <strong><%= user.getUsername() %></strong>
                </div>

                <div class="info-row">
                    <span>📧 Email</span>
                    <strong><%= user.getEmail() %></strong>
                </div>

                <div class="info-row">
                    <span>📍 Address</span>
                    <strong><%= user.getAddress() %></strong>
                </div>

                <div class="info-row">
                    <span>🛡 Role</span>
                    <strong><%= user.getRole() %></strong>
                </div>

                <div class="info-row">
                    <span>🆔 User ID</span>
                    <strong><%= user.getUserid() %></strong>
                </div>

                <div class="info-row">
                    <span>📅 Member Since</span>
                    <strong>
                    <%= user.getCreatedate()!=null ?
                    user.getCreatedate().toLocalDateTime().toLocalDate()
                    : "Not Available" %>
                    </strong>
                </div>

                <div class="info-row">
                    <span>🕒 Last Login</span>
                    <strong>
                    <%= user.getLastlogindate()!=null ?
                    user.getLastlogindate().toLocalDateTime().toString().replace("T"," ")
                    : "First Login" %>
                    </strong>
                </div>

            </div>

            <div class="profile-buttons">

                <a href="home.jsp" class="profile-btn">
                    🏠 Back To Home
                </a>

            </div>

        </div>

    </div>

</section>

</body>
</html>