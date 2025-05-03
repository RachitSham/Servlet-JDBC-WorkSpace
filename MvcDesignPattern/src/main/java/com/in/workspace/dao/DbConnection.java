package com.in.workspace.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
