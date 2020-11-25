package com.revature.p0.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.p0.dao.BudgetMonthlyDAO;
import com.revature.p0.model.BudgetMonthly;
import com.revature.p0.util.ConnSingleton;

public class BudgetMonthlyDAOImpl implements BudgetMonthlyDAO{
	
	public static ConnSingleton cs = ConnSingleton.getInstance();
	
	public boolean createBudgetMonthly(int user_id, double housing, double utilities, double internet, double grocery, double entertainment, double transportation, double savings) throws SQLException {
		Connection conn = cs.getConnection();
		String sql = "INSERT INTO BUDGET_MONTHLY VALUES (NEXTVAL('bmseq'),?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setDouble(2, housing);
		ps.setDouble(3, utilities);
		ps.setDouble(4, internet);
		ps.setDouble(5, grocery);
		ps.setDouble(6, entertainment);
		ps.setDouble(7, transportation);
		ps.setDouble(8, savings);
		ps.executeUpdate();
		return true;
	}
	
	public ArrayList<BudgetMonthly> getBudgetMonthly(){
		ArrayList<BudgetMonthly> budgetMonthly = new ArrayList<BudgetMonthly>();
		try {
		Connection conn = cs.getConnection();
		String sql = "SELECT * FROM BUDGET_MONTHLY";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		BudgetMonthly bm = null;
			while(rs.next()) {
				bm = new BudgetMonthly(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), 
						rs.getDouble(7), rs.getDouble(8), rs.getDouble(9));
			budgetMonthly.add(bm);
			}
		}catch(SQLException e){
			e.printStackTrace(); 
		}
		return budgetMonthly;
	}
	
}
