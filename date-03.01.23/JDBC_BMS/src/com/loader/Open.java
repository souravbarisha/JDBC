package com.loader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.bms.Helper;

public class Open {
	int acc_no, pin, db_acc, db_pin;
	double acc_bal;
	String acc_holder, ifsc, branch, acc_type, db_ifsc;
	Scanner sc = new Scanner(System.in);

	public void openAccountDetails(int acc_no, String ifsc, int pin) throws SQLException {
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement();

		// execute query fetch data from database
		ResultSet rs = stmt.executeQuery("select * from Bank where account_no=" + acc_no + " and pin =" + pin);
		while (rs.next()) {
			db_acc = rs.getInt(1);
			db_ifsc = rs.getString(3);
			db_pin = rs.getInt(7);
		}
		if (db_acc == acc_no) {
			System.err.println(" !! Account Number Already Exist !!");
		} else if (db_ifsc == ifsc) {
			System.out.println("!! IFSC Already Exist !!");

		}

		else {

			System.out.println("Enter Account Holder name: ");
			acc_holder = sc.next();

			System.out.println("Enter Branch: ");
			branch = sc.next();

			System.out.println("Enter Account Type: ");
			acc_type = sc.next();

			System.out.println("Enter Account Balance: ");
			acc_bal = sc.nextDouble();

			PreparedStatement stmt1 = conn.prepareStatement("insert into Bank values(?,?,?,?,?,?,?)");
			stmt1.setInt(1, acc_no);
			stmt1.setString(2, acc_holder);
			stmt1.setString(3, ifsc);
			stmt1.setString(4, branch);
			stmt1.setString(5, acc_type);
			stmt1.setDouble(6, acc_bal);
			stmt1.setInt(7, pin);

			stmt1.executeUpdate(); // execute
			System.err.println("___NEW ACCOUNT CREATED___");
		}
	}

}
