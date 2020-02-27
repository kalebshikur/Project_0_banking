
package bankingApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class Validator {
	     
	static Connection conn = null;
	static PreparedStatement ptUser = null;
	static PreparedStatement ptPass = null;
	static PreparedStatement acPass = null;
	static ResultSet resultSet = null;
	static ResultSet passSet = null;
	static ResultSet actSet = null;
	String passConverter = null;
	Scanner credentialUser = new Scanner(System.in);
	Scanner credentialPass = new Scanner(System.in);
	int s; int counter = 0; String userName; String passWord;
	int atest = 0;
	
	public static void getConnect() {		
		System.out.println("it has started");
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "pj", "pj");
		}
		catch(SQLException e) {
		e.printStackTrace();
		}
}
	
public int validate() throws SQLException, NullPointerException {
	do {
	s=0;
	String userQuery = null;
	String passQuery = null; 
	String acctQuery = null;
	System.out.println("Input user name:");
	userName = credentialUser.nextLine();
	System.out.println("Input Pass Word:");
	passWord = credentialPass.nextLine();
	
	userQuery = "SELECT * FROM login2 where UserName = ?";
	passQuery = "SELECT passWord FROM login2 where PassWord = ?";
	acctQuery = "SELECT account_no FROM login2 where PassWord = ?";	
	ptUser = conn.prepareStatement(userQuery,1);
	ptUser.setString(1,userName);
	ptUser.execute();
	resultSet = ptUser.executeQuery();
	
	String ptest = " ";
	int atest = 0;
	
	ptPass = conn.prepareStatement(passQuery,1);
	ptPass.setString(1,passWord);
	ptPass.execute();
	passSet = ptPass.executeQuery();
	
	int userBool = 0;
	boolean userBool2 = false;
	userBool2 = resultSet.next();
	while(passSet.next()) {	
		userBool++;
	ptest = passSet.getString("password");
	}
	
	acPass = conn.prepareStatement(acctQuery,1);
	acPass.setString(1,passWord);
	acPass.execute();
	actSet = acPass.executeQuery();
	// int userBool = 0;
	// boolean userBool2 = false;
//	userBool2 = resultSet.next();
	while(actSet.next()) {	
	atest = actSet.getInt("Account_No");
	}
	//System.out.println("this is printing:&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& " + atest);
	//System.out.println("this is printing: " + userBool + "this is pass set:" + userBool2);
	//System.out.println("!!!!!!!!!!!! entered pass: "+ ptest + " dummy password: "+ passWord);
	if(userBool == 1 ) {
		s++;
	if(passWord.equals(ptest)) {
		s++;
		}
	}
	counter++ ;
	int attempt = 3 - counter;
	
	if(s != 2) {
		System.out.println("     *********** WRONG USER NAME OR PASS WORD **************        ");
		System.out.println("You have "+ attempt + " of 3 remaining" );
		if(attempt ==0) {
			System.out.println(" You account is temporarily suspended Try again");
		}
	} 
	}while(s != 2 && counter < 3 );
	return s;
	}
/*
	public static void main(String[] args) throws SQLException, NullPointerException {
		Validator valid = new Validator();
		System.out.println(valid.validate());
	}
		*/


public int eValidate() throws SQLException, NullPointerException {
	do {
	s=0;
	String userQuery = null;
	String passQuery = null; 
	String acctQuery = null;
	System.out.println("Input user name:");
	userName = credentialUser.nextLine();
	System.out.println("Input Pass Word:");
	passWord = credentialPass.nextLine();
	
	userQuery = "SELECT * FROM Employee where UserName = ?";
	passQuery = "SELECT passWord FROM Employee where PassWord =? ";
	acctQuery = "SELECT employee_no FROM Employee where PassWord = ?";	
	ptUser = conn.prepareStatement(userQuery,1);
	ptUser.setString(1,"xyz1");
	ptUser.execute();
	resultSet = ptUser.executeQuery();
	
	String ptest = " ";
	int atest = 0;
	
	ptPass = conn.prepareStatement(passQuery,1);
	ptPass.setString(1,passWord);
	ptPass.execute();
	passSet = ptPass.executeQuery();
	System.out.println("fhhhhhhhhhhhhhhhh         "   +  passSet);
	int userBool = 0;
	boolean userBool2 = false;
	userBool2 = resultSet.next();
	while(passSet.next()) {	
		userBool++;
	ptest = passSet.getString("password");
	}
	
	acPass = conn.prepareStatement(acctQuery,1);
	acPass.setString(1,passWord);
	acPass.execute();
	actSet = acPass.executeQuery();
	// int userBool = 0;
	// boolean userBool2 = false;
//	userBool2 = resultSet.next();
	while(actSet.next()) {	
	atest = actSet.getInt("Account_No");
	}
	//System.out.println("this is printing:&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& " + atest);
	//System.out.println("this is printing: " + userBool + "this is pass set:" + userBool2);
	//System.out.println("!!!!!!!!!!!! entered pass: "+ ptest + " dummy password: "+ passWord);
	if(userBool == 1 ) {
		s++;
	if(passWord.equals(ptest)) {
		s++;
		}
	}
	counter++ ;
	int attempt = 3 - counter;
	
	if(s != 2) {
		System.out.println("     *********** WRONG USER NAME OR PASS WORD **************        ");
		System.out.println("You have "+ attempt + " of 3 remaining" );
		if(attempt ==0) {
			System.out.println(" You account is temporarily suspended Try again");
		}
	} 
	}while(s != 2 && counter < 3 );
	return s;
	}






}
	
	
	
	

