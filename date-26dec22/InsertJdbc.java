package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJdbc {
	public static void main(String[] args) {
		try {
			// register driver step no 1
			Class.forName("com.mysql.cj.jdbc.Driver");
		    // get connection step
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/souravdb","root","sourav@1998");
			// create statement step no 3
			Statement stmt = conn.createStatement();
			// inserting data into database table step no 4			//ResultSet rs = stmt.executeQuery("select*from customer");
			stmt.executeUpdate(
					"insert into customer values ('B07','PUJA','BERA','HI',222333,\"02-jan-98\",2500.50)"
					);
			System.out.println("inserting succesfully");
			//close database connection step 5
			conn.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
