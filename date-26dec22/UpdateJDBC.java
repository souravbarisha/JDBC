package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateJDBC {
public static void main(String[] args) {
	try { // register driver-- step no 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		 // get connection step no 2
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/souravdb","root","sourav@1998");
		// create statement step no 3
		Statement stmt = conn.createStatement();
		// updating an existing record step no 4
		stmt.executeUpdate("update customer set lname='Das' where cust_id='B07' "); // update
		// delete record
		stmt.executeUpdate("delete from customer where cust_id ='B06' "); // delete
		// execute query fetch data from database
		ResultSet rs = stmt.executeQuery("select * from customer"); // read (fetch)
		//iteration
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getFloat(7));
		}
		
		conn.close();
	} catch(Exception e) {
		System.out.println(e);
	}
}
}
