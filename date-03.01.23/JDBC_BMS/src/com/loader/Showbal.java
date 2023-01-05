package com.loader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;
public class Showbal {
	int db_acc;
	int db_pin;
	public void openAccountDetails(int acc_no,int pin) throws SQLException {
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Bank where account_no=" + acc_no + " and pin =" + pin);
		while (rs.next()) {
			db_acc = rs.getInt(1);
			db_pin = rs.getInt(7);
		}
		if (db_acc != acc_no) {
			System.err.println(" !!Wrong Account Number Already Inserted !!");
		}
		if (db_acc != pin) {
			System.err.println(" !!Wrong Pin Inserted !!");
		}
		else
		{
		System.out.println("-------------------------");
		System.out.println("Details of Your Account:");
		ResultSet rs1 = stmt.executeQuery("select * from Bank where  pin =" + pin);
		while(rs1.next()) {
			System.out.println("Account Number:"+rs1.getInt(1));
			System.out.println("Account Houlder:"+rs1.getString(2));
			System.out.println("Branch Ifsc:"+rs1.getString(3));
			System.out.println("Branch:"+rs1.getString(4));
			System.out.println("Account Type:"+rs1.getString(5));
			System.out.println("Account Balance:"+rs1.getDouble(6));
			System.out.println("Account Pin:"+rs1.getInt(7));
			System.out.println("--------------------------");

		}
		}
		}
}
