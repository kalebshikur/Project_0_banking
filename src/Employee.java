import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Employee {
	String userName;
	String SSN;
	String userQuery, passQuery, email, username, passWord;
	static Connection connEmp = null;
	static Statement empUserP = null;
	static ResultSet empUserR = null;
	
	static Statement empPassP = null;
	static ResultSet empPassR = null;
	String emptest1, emptest2;
	public int EmpLogin() throws SQLException {
		int empL =0;
		System.out.println("begiennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		System.out.println("Enter user name");
		userName = AllTransactions.scanT.nextLine();
		System.out.println("Enter pass word");
		passWord = AllTransactions.scanT.nextLine();
		connEmp = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "pj", "pj");
		userQuery = "SELECT employee_no FROM Employee where UserName ='"+ userName + "'";
		passQuery = "SELECT employee_no FROM employee where PassWord ='"+ passWord + "'";
		empUserP = connEmp.createStatement();
		empUserR = empUserP.executeQuery(userQuery);
		empUserR.next();
		emptest1=empUserR.getString(1);
		empPassP = connEmp.createStatement();
		empPassR = empPassP.executeQuery(passQuery);
		empPassR.next();
		emptest2 =empPassR.getString(1);
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" + emptest1+ "mmmmmmmmmmmmmmmmm" + emptest2);
		if(emptest1.equals(emptest2)) {
			empL= 1;}
		return empL ;
		
	}
	
	
	
	
	
	public char Aproval() {
		//if customer is applying for a new account check the info and return approve	
		return 0;
	}
	protected void viewInfor() {
		// the added functinality is the empoyee can see multiple customer accounts
		// This is where you pull all the information of of the customer 
		// from the data base and when this method is called it will display
		// the information
	}
	protected void ViewLog() {
		// Ask for the customer account number
		// view the log	
	}
}
