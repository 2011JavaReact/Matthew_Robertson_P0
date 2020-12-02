package com.revature.p0.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.p0.dao.UserDAO;
import com.revature.p0.model.User;
import com.revature.p0.util.ConnSingleton;

public class UserDAOImpl implements UserDAO{
	
	public static ConnSingleton cs = ConnSingleton.getInstance();
	
	@Override
	public void createUser(String username, String password, String firstname, String lastname, String email) throws SQLException {
		Connection conn = cs.getConnection();
		String sql = "INSERT INTO USERS VALUES (NEXTVAL('userseq'),?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, firstname);
		ps.setString(4, lastname);
		ps.setString(5, email);
		ps.executeUpdate();
	}
	
	@Override
	public ArrayList<User> getUserList() throws SQLException {
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			Connection conn = cs.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
			User user = null;
			while(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				userList.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public ArrayList<User> getUserById(int id) throws SQLException{
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = cs.getConnection();
		String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6)); 
		userList.add(u);
		}
		return userList;
	}
	
	@Override
	public boolean updateUserInfo(int userId, String username, String password, String firstname, String lastname, String email) throws SQLException{
		Connection conn = cs.getConnection();
		String sql = "UPDATE USERS SET FIRSTNAME = (?), LASTNAME = (?), USERNAME = (?), PASSWORD = (?), EMAIL = (?) WHERE EMPLOYEES_ID = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, firstname);
		ps.setString(4, lastname);
		ps.setString(5, email);
		ps.executeUpdate();
		return true; 
	}

}
