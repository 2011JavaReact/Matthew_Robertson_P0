package com.revature.p0.driver;

import java.sql.SQLException;

import com.revature.p0.daoimpl.BudgetMonthlyDAOImpl;
import com.revature.p0.daoimpl.UserDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		BudgetMonthlyDAOImpl bmd = new BudgetMonthlyDAOImpl();
		UserDAOImpl udi = new UserDAOImpl();
		
//		try {
//			udi.createUser("lavalamp", "something1", "Matthew", "Robertson", "something@gmail.com");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			bmd.createBudgetMonthly(2, 1500, 200, 100, 300, 100, 100, 5000);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
//		System.out.println(bmd.getBudgetMonthly());
//		
//		String dbPassword = System.getenv("RDS_HOSTNAME");
//		System.out.println(dbPassword);
////		
//		Map<String, String> env = System.getenv();
//        for (String envName : env.keySet()) {
//            System.out.format("DB_P0_PASSWORD",
//                              envName,
//                              env.get(envName));
//        }
	}

}
