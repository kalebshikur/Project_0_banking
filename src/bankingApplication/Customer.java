package bankingApplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Customer {
	BankDaoImp bdi2 = new BankDaoImp();
	private String Name, userName, passWord;
	private String adress, email, phone, SSN;
	static private double accountBalaced = 0;
	static double acc = 0;
	Scanner custScanner = new Scanner(System.in);
	/*
	static Connection conn = null;
	static PreparedStatement ptUser = null;
	static PreparedStatement ptPass = null;
	static ResultSet resultSet = null;
	static ResultSet passSet = null;
	String passConverter = null;
	Scanner credentialUser = new Scanner(System.in);
	Scanner credentialPass = new Scanner(System.in);
	int s; int counter = 0; String userName; String passWord;

	*/
	protected void viewInfor() {
		// This is where you pull all the information of of the customer 
		// from the data base and when this method is called it will display
		// the information	
	}
	protected void acceptWire() {
		// this is were a wire sent to the account can be received and or declined
		// if accepted the amount equal to the amount transfered will be added to the account
		//if declined the amount will be transfered back to the senders account with a message saying 
		// recipient XYZ declined the wire transfer	
	}
	//protected void passWordValidater() {
		//this is were password can be validated
	//}
	
	protected void checkBalance(int accountNo) throws SQLException {
		
		accountBalaced = bdi2.accountBalance(accountNo);
		System.out.println("Your account balance is: " + accountBalaced);
	}
	protected void Withdrawal(int accountNo)throws SQLException {
		System.out.println("How much do you want to withdraw?");
		double withdrawal = custScanner.nextDouble();
		accountBalaced = bdi2.accountBalance(accountNo);
		if (withdrawal > 0 && accountBalaced > withdrawal ) {
			acc = accountBalaced - withdrawal;
			System.out.println("You have Withdrawn: "+ withdrawal);
			System.out.println("this is the remainder:" + acc);
		}
		else {
			System.out.println("invalid entry");
		}

	}
	
	protected void Deposit(int accountNo) throws SQLException {
		System.out.println("How much money do you want to Deposite?");
		double deposite= custScanner.nextDouble();
		accountBalaced = bdi2.accountBalance(accountNo);
		if (deposite > 0 ) {
			acc = accountBalaced+ deposite;
			System.out.println("You have DEPOSITED: "+ deposite);
		}
		else {
			System.out.println("invalid entry");
		}
	}
	
protected void TransferMoney() {
	System.out.println("Account number to transfer to ?");
	System.out.println("How much money do you want to transfer");
	double TransferAmount= custScanner.nextDouble();
	
	if (custScanner.nextDouble() > 0 ) {
		accountBalaced = accountBalaced-TransferAmount;
	}
	else {
		System.out.println("invalid entry");
	}
	// Take input with scanner
	// Take input with scanner and validate with the account in the database
	// update the corresponding account in the database with the amount of money transfered in 
}
}
