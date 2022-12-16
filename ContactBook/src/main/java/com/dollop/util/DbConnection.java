package com.dollop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection con = null;

	public static Connection dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "vik@6266");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
