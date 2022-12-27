package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ScannerJDBC_HomeAssi {
public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	System.out.println("ID: ");
	int id = sc.nextInt();
	System.out.println("NAME: ");
	String sname = sc.next();
	System.out.println("AGE: ");
	int sage = sc.nextInt();
	System.out.println("PHONE: ");
	int sphone = sc.nextInt();
	System.out.println("EMAIL ID: ");
	String semail = sc.next();
	System.out.println("ADDRESS: ");
	String sadd = sc.next();
	System.out.println("QUALIFICATION: ");
	String squalification = sc.next();
	
	try { //register driver step no 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get connection step 2
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/souravdb","root","sourav@1998");
		//creating statement
		PreparedStatement stm;
		//inserting data in database table 
		String sql = "insert into Student_details values (?,?,?,?,?,?,?)";
		stm = conn.prepareStatement(sql);
		
		stm.setInt(1, id);
		stm.setString(2,sname);
		stm.setInt(3,sage);
		stm.setInt(4,sphone);
		stm.setString(5, semail);
		stm.setString(6, sadd);
		stm.setString(7, squalification);
		
		stm.execute();
		System.out.println("Insert Done ");
		
		// updating an existing record step no 4
//		System.out.println("do you want update any data? : ");
//		String update;
//		if(update =="sage") {
//			 int updatesage = sc.nextInt();
//		}
		
	    	stm.executeUpdate("update Student_details set sage=25 where id=10 "); // update
	    	System.out.println("age update done of id 10 ");
		// delete record
			stm.executeUpdate("delete from Student_details where id =7 "); // delete
			System.out.println("delete done of id 7 ");
		// execute query fetch data from database
			ResultSet rs = stm.executeQuery("select * from Student_details"); // read (fetch)
		//iteration
			while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+ rs.getBigDecimal(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				}
				
		conn.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	
}
}
