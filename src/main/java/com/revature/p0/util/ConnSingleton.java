package com.revature.p0.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import org.apache.log4j.Logger;


public class ConnSingleton {
	
	//static Logger logger = Logger.getLogger(ConnSingleton.class);
		
	private static volatile ConnSingleton instance = null;
	
	private ConnSingleton() {
		super();
	}
	
	public static ConnSingleton getInstance() {
		if(instance == null) {
			synchronized(ConnSingleton.class) {
				if(instance == null) {
					instance = new ConnSingleton();
				}
			}
		}
		return instance;
	}
	
//	public static Connection getConnection(String filename) throws SQLException {
////		Connection c = null;
////		
//		Connection c = null;
//		try {
//		Properties prop = new Properties();
//		InputStream in = ConnSingleton.class.getClassLoader().getResourceAsStream(filename);
//		prop.load(in);
//			Class.forName("org.postgresql.Driver");
//			c = DriverManager.getConnection(
//					prop.getProperty("url"), 
//					prop.getProperty("usr"), 
//					prop.getProperty("password"));
//		} catch(ClassNotFoundException ex) {
//			System.out.println("unable to load driver class!");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return c;
		
	public static Connection getConnection() {
	    if (System.getenv("RDS_HOSTNAME") != null) {
	      try {
	    	  System.out.println("Check");
	      Class.forName("org.postgresql.Driver");
	      String dbName = System.getenv("RDS_DB_NAME");
	      String userName = System.getenv("RDS_USERNAME");
	      String password = System.getenv("RDS_PASSWORD");
	      String hostname = System.getenv("RDS_HOSTNAME");
	      String port = System.getenv("RDS_PORT");
	      String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
	      //logger.trace("Getting remote connection with connection string from environment variables.");
	      Connection con = DriverManager.getConnection(jdbcUrl);
	      //logger.info("Remote connection successful.");
	      return con;
	    }
	    catch (ClassNotFoundException e) { 
	    	e.printStackTrace();
	    	//logger.warn(e.toString());
	    	}
	    catch (SQLException e) { 
	    	e.printStackTrace();
	    	//logger.warn(e.toString());
	    	}
	    }
	    return null;
	  }
		
		
		
//		try {
//			Properties prop = new Properties();
//			InputStream in = ConnSingleton.class.getClassLoader().getResourceAsStream(filename);
//			prop.load(in);
//		try {
//			System.out.println("Something1");
//			Class.forName("org.postgresql.Driver");
//			System.out.println("Something2");
//				c = DriverManager.getConnection(
//						System.getenv("DB_P0_URL"),
//						System.getenv("DB_P0_USERNAME"),
//						System.getenv("DB_P0_PASSWORD"));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("Didn't work...");
//	}
//		} catch(FileNotFoundException e) {
//			e.printStackTrace();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return c;
//	}
}
