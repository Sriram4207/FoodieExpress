package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static final String URL="jdbc:mysql://localhost:3306/food_delivery_app";
	private static final  String USERNAME ="root";
	private static final  String PASSWORD="4207";
	public static Connection getconnection() {
		Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con =DriverManager.getConnection(URL, USERNAME, PASSWORD);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}

}
