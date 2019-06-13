package com.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class Common {
	
	public static Connection getConnection(){
		System.out.println("Connection");
		Connection conn = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/test","postgres", "root");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	      }
		return conn;
	}

}
