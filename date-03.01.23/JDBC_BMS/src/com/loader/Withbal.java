package com.loader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bms.Helper;
public class Withbal {
	int db_acc, db_pin, pin;
	double p_bal;
	Scanner sc = new Scanner(System.in);

	// withdrawal from Acc. balance to the database
	public void withdrawal(int acc_no, int pin) throws SQLException {
		this.pin = pin;

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

			System.out.println("Enter the amount you want to withdraw: ");
		double wbal = sc.nextDouble();
		ResultSet rs1 = stmt.executeQuery("select balance from Bank where pin= " + pin);
		while (rs1.next()) {
			p_bal = rs1.getDouble(1); // storing the data
			if ((p_bal - wbal) < 0) {
				System.out.println();
				System.out.println("!! INSUFFICIENT BALANCE !!");
				System.out.println("______");
			} else

				System.out.println();
			System.out.println("Your previous balance was: " + p_bal);

			stmt.executeUpdate("update Bank set balance= balance-" + wbal + " " + " where pin =" + pin);

			System.out.println("Your new  balance is  " + (p_bal - wbal));

			System.out.println("BALANCE WITHDRAWL SUCCESSFULLY");
		}
	}
}
