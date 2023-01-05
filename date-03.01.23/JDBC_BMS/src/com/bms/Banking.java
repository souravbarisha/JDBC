package com.bms;
import java.sql.SQLException;
import java.util.Scanner;

import com.loader.CloseAccount;
import com.loader.DepBal;
import com.loader.Open;
import com.loader.PinChange;
import com.loader.Showbal;
import com.loader.Withbal;
public class Banking {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		int variable;
		do {
			System.out.println("press 1 to open account in our bank");
			System.out.println("press 2 to check your account details");
			System.out.println("press 3 to deposit money in your account");
			System.out.println("press 4 to withdraw money from you account");
			System.out.println("press 5 to change your pin");
			System.out.println("press 6 to close your account");
			System.out.println("press 7 to exit");
	variable =sc.nextInt();
	System.out.println("--------------------------------");
	switch(variable) {
	case 1:
		System.out.print("enter 10 digits to create a new account number:");
		int acc_no=sc.nextInt();
		System.out.println("enter account ifsc:");
	String ifsc_code=sc.next();
	System.out.println("enter 4 digits to create a new account pin:");
	int pin =sc.nextInt();
	Open op=new Open();
	op.openAccountDetails(acc_no,ifsc_code,pin);
	System.err.println("----New Account Created-----");
	break;
	case 2:
		System.out.println("Enter you account number:");
	int p=sc.nextInt();
	System.out.println("Enter your pin:");
	int q =sc.nextInt();
	Showbal sb =new Showbal();
	sb.openAccountDetails(p, q);
	System.out.println();
	break;
	case 3:
		System.out.println("ENter Your Account Number:");
		int a=sc.nextInt();
		System.out.println("Enter Your Pin:");
		int b=sc.nextInt();
		DepBal db=new DepBal();
		db.deposit(a, b);
		System.out.println();
		break;
	case 4:
		System.out.println("ENter Your Account Number:");
		int c=sc.nextInt();
		System.out.println("Enter Your Pin:");
		int d=sc.nextInt();
		Withbal wb=new Withbal();
		wb.withdrawal(c, d);
		System.out.println();
		break;
	case 5:
		System.out.println("ENter Your Account Number:");
		int e=sc.nextInt();
		System.out.println("Enter Your Pin:");
		int f=sc.nextInt();
		PinChange pc=new PinChange();
		pc.pinChange(e, f);
		System.out.println("Pin has been Changed");
		break;
	case 6:
		System.out.println("ENter Your Account Number:");
		int g=sc.nextInt();
		System.out.println("Enter Your Pin:");
		int h=sc.nextInt();
		CloseAccount ca=new CloseAccount();
		ca.deleteAcc(g, h);
		System.out.println();
		break;
	case 7:
		System.out.println("You have Succesfully logged out");
		System.out.println("Thannk You");
		System.out.println();
	System.exit(0);
	break;
	}
	}while(variable>0&&variable<8);
	}
}
