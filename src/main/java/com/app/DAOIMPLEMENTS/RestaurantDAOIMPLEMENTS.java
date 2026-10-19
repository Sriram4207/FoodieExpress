package com.app.DAOIMPLEMENTS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.DAO.RestaurantDAO;
import com.app.model.Restaurant;
import com.app.util.DBconnection;

public class RestaurantDAOIMPLEMENTS implements RestaurantDAO{
	private static final String ADD_RES="INSERT INTO restaurant (name, cuisinetype, deliverytime, address, rating, isactive, imagepath) "
			+ "VALUES(?,?,?,?,?,?,?)";
	private static final String GET_RES="SELECT * FROM restaurant where restaurantid = ?";
    private static final String GETALL_RES="SELECT * FROM restaurant";
    private static final String UPDATE_RES =
    		"UPDATE restaurant SET name=?, cuisinetype=?, deliverytime=?, address=?, rating=?, isactive=?, imagepath=? "
    		+ "WHERE restaurantid=?";
    private static final String DEL_RES="DELETE FROM restaurant WHERE restaurantid =?";
    @Override
	public void addRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		Connection con =DBconnection.getconnection();
	try {
		PreparedStatement pstmt=con.prepareStatement(ADD_RES);
		pstmt.setString(1,r.getName());
		pstmt.setString(2,r.getCuisinetype());
		pstmt.setInt(3,r.getDeliverytime());
		pstmt.setString(4,r.getAddress());
		pstmt.setDouble(5,r.getRating());
		pstmt.setInt(6,r.getIsactive());
		pstmt.setString(7,r.getImagepath());
		int i =pstmt.executeUpdate();
	      System.out.println(i+"Resturant Added Succesfully");	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public Restaurant getRestaurant(int id) {
		// TODO Auto-generated method stub
		Connection con =DBconnection.getconnection();
		 Restaurant r = null;
		try {
			PreparedStatement pstmt =con.prepareStatement(GET_RES);
			pstmt.setInt(1,id);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				 r =new Restaurant();
				r.setRestaurantid(res.getInt("restaurantid"));
				r.setName(res.getString("name"));
				r.setCuisinetype(res.getString("cuisinetype"));
				r.setDeliverytime(res.getInt("deliverytime"));
				r.setAddress(res.getString("address"));
				r.setRating(res.getDouble("rating"));
				r.setIsactive(res.getInt("isactive"));
				r.setImagepath(res.getString("imagepath"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
		Connection con =DBconnection.getconnection();
		 List<Restaurant> rl = new ArrayList<>();

		try {
			Statement stmt =con.createStatement();
			ResultSet res=stmt.executeQuery(GETALL_RES);
			while(res.next()) {
				Restaurant r =new Restaurant();
				r.setRestaurantid(res.getInt("restaurantid"));
				r.setName(res.getString("name"));
				r.setCuisinetype(res.getString("cuisinetype"));
				r.setDeliverytime(res.getInt("deliverytime"));
				r.setAddress(res.getString("Address"));
				r.setRating(res.getDouble("rating"));
				r.setIsactive(res.getInt("isactive"));
                r.setImagepath(res.getString("imagepath"));
                rl.add(r);			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rl;
	}

	@Override
	public void updateRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		Connection con =DBconnection.getconnection();
		try {
			PreparedStatement pstmt =con.prepareStatement(UPDATE_RES);
			pstmt.setString(1,r.getName());
			pstmt.setString(2, r.getCuisinetype());
			pstmt.setInt(3, r.getDeliverytime());
			pstmt.setString(4, r.getAddress());
			pstmt.setDouble(5, r.getRating());
			pstmt.setInt(6,r.getIsactive());
			pstmt.setString(7,r.getImagepath());
			pstmt.setInt(8, r.getRestaurantid());
			int i =pstmt.executeUpdate();
			System.out.println(i+"Updated Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int id) {
		// TODO Auto-generated method stub
		Connection con =DBconnection.getconnection();
          try {
			PreparedStatement pstmt = con.prepareStatement(DEL_RES);
			pstmt.setInt(1, id);
			int i =pstmt.executeUpdate();
			System.out.println(i+"Restaurant Deleted Successfully ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	};
	
	
	
}
