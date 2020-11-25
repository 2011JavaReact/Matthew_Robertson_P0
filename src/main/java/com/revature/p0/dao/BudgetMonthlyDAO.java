package com.revature.p0.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.p0.model.BudgetMonthly;

public interface BudgetMonthlyDAO {

	public boolean createBudgetMonthly(int user_id, double housing, double utilities, double internet, double grocery, double entertainment, double transportation, double savings) throws SQLException;
	
	public ArrayList<BudgetMonthly> getBudgetMonthly();
	
}
