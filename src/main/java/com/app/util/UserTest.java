package com.app.util;

import java.util.List;

import com.app.DAOIMPLEMENTS.UserDAOIMPLEMENTS;
import com.app.model.User;

public class UserTest {

    public static void main(String[] args) {

        UserDAOIMPLEMENTS dao =
                new UserDAOIMPLEMENTS();

        // ==========================
        // ADD USER
        // ==========================

        User u = new User(
                "SriRam",
                "12345",
                "sriram@gmail.com",
                "Bangalore",
                "customer"
        );

        dao.adduser(u);

        // ==========================
        // GET USER
        // ==========================

        User user = dao.getuser(1);

        System.out.println("Single User:");
        System.out.println(user);

        // ==========================
        // UPDATE USER
        // ==========================

        User updateUser = dao.getuser(1);

        if(updateUser != null) {

            updateUser.setUsername("Ram");
            updateUser.setPassword("54321");

            dao.update(updateUser);
        }

        // ==========================
        // GET ALL USERS
        // ==========================

        List<User> userList =
                dao.getallusers();

        System.out.println("\nAll Users:");

        for(User usr : userList) {

            System.out.println(usr);
        }

        // ==========================
        // DELETE USER
        // ==========================

        dao.deleteuser(6);
    }
}