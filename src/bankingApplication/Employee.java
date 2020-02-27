package bankingApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Employee {
	String userName;
	String SSN;
	String userQuery, passQuery,userQueryT ,email, username, passWord;
	static Connection connEmp = null;
	static Statement empUserP = null;
	static ResultSet empUserR = null;
	
	static Statement empPassP = null;
	static ResultSet empPassR = null;
	String emptest1, emptest2;
	
	static Connection connEmpT = null;
	static Statement empUserPT = null;
	static ResultSet empUserRT = null;
	
	public void empTransaction() throws SQLException {
		    
		connEmpT = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "pj", "pj");
		userQueryT = "select * from transaction_audits";
		empUserPT = connEmpT.createStatement();
		//empUserRT = empUserP.executeQuery(userQuery);
		empUserRT = empUserPT.executeQuery(userQueryT);
		while (empUserRT.next()) {
			System.out.println(empUserRT.getInt(1)+" "+empUserRT.getString(2)+" "+empUserRT.getString(3)+" "+empUserRT.getString(4)+" "+empUserRT.getDate(5));
		}
		
	}
	
	
	
	public int EmpLogin() throws SQLException {
		int empL =0;
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
		if(emptest1.equals(emptest2)) {
			empL= 1;}
		return empL ;
		
	}
	
	
	
	
	
	public char Aproval() {
		
		return 0;
	}
	protected void viewInfor() {

	}
	protected void ViewLog() {
		// Ask for the customer account number
		// view the log	
	}
}
