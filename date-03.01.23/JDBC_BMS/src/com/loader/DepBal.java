package com.loader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;
public class DepBal {
	int db_acc, db_pin;
	double p_bal;
	Scanner sc = new Scanner(System.in);

// deposit Acc. balance to the database
	public void deposit(int acc_no, int pin) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement(); // create statement

		ResultSet rs = stmt.executeQuery("select * from Bank where account_no= " + acc_no + " and pin= " + pin);

		while (rs.next()) {
			db_acc = rs.getInt(1);
			db_pin = rs.getInt(7);
		}
		if (db_acc != acc_no) {
			System.err.println("!! WRONG ACCOUNT NUMBER INSERTED !!");
		}
		if (db_pin != pin) {
			System.err.println("!! WRONG PIN INSERTED !!");
		} else

			System.out.println("Enter the amount you want to deposite: ");
		double depo = sc.nextDouble();
		ResultSet rs1 = stmt
				.executeQuery("select balance from Bank where" + "account_no= " + acc_no + " and pin= " + pin);
		while (rs1.next()) {
			p_bal = rs1.getDouble(1);
			System.out.println();
			System.out.println("Tour previous balance was: " + p_bal);
		}
		stmt.executeUpdate("Update Bank set balance: " + (p_bal + depo) + " " + " where pin= " + pin);
		System.err.println("your new balance is: " + (p_bal + depo));
		System.err.println("_____");

	}

}
