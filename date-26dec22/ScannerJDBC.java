package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ScannerJDBC {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("id:");
	int id=sc.nextInt();
	System.out.println("sname:");
	String sname=sc.next();
	System.out.println("sage:");
	int sage=sc.nextInt();
	System.out.println("Phoneno:");
	int sphone=sc.nextInt();
	System.out.println("semail:");
	String semail=sc.next();
	System.out.println("sadd:");
	String sadd=sc.next();
	System.out.println("squalification");
	String squalification=sc.next();

	try {
		//register driver step no 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get connection step 2
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/souravdb","root","sourav@1998");
		//creating statement
		PreparedStatement stm;
		//inserting data in database table 
		String sql="insert into Student_details values (?,?,?,?,?,?,?)";
		stm=conn.prepareStatement(sql);
		stm.setInt(1, id);
		stm.setString(2,sname);
		stm.setInt(3,sage);
		stm.setInt(4,sphone);
		stm.setString(5, semail);
		stm.setString(6, sadd);
		stm.setString(7, squalification);
	
		stm.execute();
		System.out.println("Insert done");
	}catch(Exception e) {
		System.out.println(e);
	}

}
}
