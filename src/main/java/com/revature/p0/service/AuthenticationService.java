package com.revature.p0.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.p0.daoimpl.UserDAOImpl;
import com.revature.p0.model.User;

public class AuthenticationService {
	
	UserDAOImpl udi = new UserDAOImpl();
	
	public AuthenticationService() {
		super();
	}
	
	public User authenticateUser(String username, String password) {
		ArrayList<User> users = new ArrayList<User>();
		User u = null;
		try {
			users = udi.getUserList();
			if(users != null) {
				for (User user : users) {
					if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
						u = new User(user.getUserId(), user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail());
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u; 
	}
}
