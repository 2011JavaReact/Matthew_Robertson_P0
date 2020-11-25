package com.revature.p0.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.p0.model.User;

public interface UserDAO {
	
public void createUser(String username, String password, String firstname, String lastname, String email) throws SQLException;

public ArrayList<User> getUserList() throws SQLException;

public User getUserById(int id) throws SQLException;

public boolean updateUserInfo(int userId, String username, String password, String firstname, String lastname, String email) throws SQLException;

}
