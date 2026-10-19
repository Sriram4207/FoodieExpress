package com.app.DAO;


import java.util.List;

import com.app.model.User;

public interface UserDAO {

		 void adduser(User u);
		 void update(User u);
		 User getuser(int id);
		  List<User> getallusers();
		 void deleteuser(int id);
		 boolean checkuser(User u);
		 User loginUser(String username, String password);
}



