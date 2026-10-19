package com.app.DAOIMPLEMENTS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.app.DAO.UserDAO;
import com.app.model.User;
import com.app.util.DBconnection;

public class UserDAOIMPLEMENTS implements UserDAO {

    private static final String add_user =
            "INSERT INTO user(username,password,email,address,role,createdate,lastlogindate) VALUES(?,?,?,?,?,?,?)";

    private static final String Update_user =
            "UPDATE user SET username=?, password=?, email=?, address=?, role=?, lastlogindate=? WHERE userid=?";

    private static final String get_user =
            "SELECT * FROM user WHERE userid=?";

    private static final String get_alluser =
            "SELECT * FROM user";

    private static final String delete_user =
            "DELETE FROM user WHERE userid=?";

    // Search only by username
    private static final String check_user =
            "SELECT * FROM user WHERE username=?";

    // Search only by username
    private static final String LOGIN_USER =
            "SELECT * FROM user WHERE username=?";

    @Override
    public void adduser(User u) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(add_user);

            // Hash password before storing
            String hashedPassword = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());

            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getAddress());
            pstmt.setString(5, u.getRole());
            pstmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            pstmt.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));

            int i = pstmt.executeUpdate();

            System.out.println(i + " user added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User u) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(Update_user);

            // Hash password before updating
            String hashedPassword = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());

            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getAddress());
            pstmt.setString(5, u.getRole());
            pstmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            pstmt.setInt(7, u.getUserid());

            int i = pstmt.executeUpdate();

            System.out.println(i + " user updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getuser(int id) {

        Connection con = DBconnection.getconnection();

        User u = new User();

        try {

            PreparedStatement pstmt = con.prepareStatement(get_user);

            pstmt.setInt(1, id);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                u.setUserid(res.getInt("userid"));
                u.setUsername(res.getString("username"));
                u.setPassword(res.getString("password"));
                u.setEmail(res.getString("email"));
                u.setAddress(res.getString("address"));
                u.setRole(res.getString("role"));
                u.setCreatedate(res.getTimestamp("createdate"));
                u.setLastlogindate(res.getTimestamp("lastlogindate"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public List<User> getallusers() {

        Connection con = DBconnection.getconnection();

        List<User> userList = new ArrayList<>();

        try {

            Statement stmt = con.createStatement();

            ResultSet res = stmt.executeQuery(get_alluser);

            while (res.next()) {

                User u = new User();

                u.setUserid(res.getInt("userid"));
                u.setUsername(res.getString("username"));
                u.setPassword(res.getString("password"));
                u.setEmail(res.getString("email"));
                u.setAddress(res.getString("address"));
                u.setRole(res.getString("role"));
                u.setCreatedate(res.getTimestamp("createdate"));
                u.setLastlogindate(res.getTimestamp("lastlogindate"));

                userList.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void deleteuser(int id) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(delete_user);

            pstmt.setInt(1, id);

            int i = pstmt.executeUpdate();

            System.out.println(i + " user deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkuser(User u) {

        Connection con = DBconnection.getconnection();

        try {

            PreparedStatement pstmt = con.prepareStatement(check_user);

            pstmt.setString(1, u.getUsername());

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                String hashedPassword = res.getString("password");

                return BCrypt.checkpw(u.getPassword(), hashedPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User loginUser(String username, String password) {

        Connection con = DBconnection.getconnection();
        User u = null;

        try {

            PreparedStatement pstmt = con.prepareStatement(LOGIN_USER);
            pstmt.setString(1, username);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                String hashedPassword = res.getString("password");

                System.out.println("Username      : " + username);
                System.out.println("Entered Pass  : " + password);
                System.out.println("DB Password   : " + hashedPassword);

                if (hashedPassword != null && BCrypt.checkpw(password, hashedPassword)) {

                    u = new User();

                    u.setUserid(res.getInt("userid"));
                    u.setUsername(res.getString("username"));
                    u.setPassword(res.getString("password"));
                    u.setEmail(res.getString("email"));
                    u.setAddress(res.getString("address"));
                    u.setRole(res.getString("role"));
                    u.setCreatedate(res.getTimestamp("createdate"));
                    u.setLastlogindate(res.getTimestamp("lastlogindate"));

                    // Optional: Update last login time
                    PreparedStatement updateStmt = con.prepareStatement(
                            "UPDATE user SET lastlogindate=? WHERE userid=?");

                    updateStmt.setTimestamp(1,
                            new java.sql.Timestamp(System.currentTimeMillis()));
                    updateStmt.setInt(2, u.getUserid());

                    updateStmt.executeUpdate();

                    updateStmt.close();
                }
            }

            res.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }
}