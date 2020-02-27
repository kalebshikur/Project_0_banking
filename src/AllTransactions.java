import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class AllTransactions {
	Connection conn = null;
	PreparedStatement ptAcctT = null;
	Statement stmt = null;
	ResultSet rsT = null;
	int acctNT;
	int acctNreturnedT;
	String userName;
	Validator validT;
	double accountBalanceT;
	double tranAmount;
	double remainT;
	static Scanner scanT = new Scanner(System.in);
	BankDaoImp bdiT = new BankDaoImp();
	
	public void wireSwitchY(int accountNum) throws SQLException {
		bdiT.connectionPoint();
		String query4 = "UPDATE Account SET wirestatus = 'Y' WHERE account_no = ?";
		ptAcctT = Validator.conn.prepareStatement(query4);
		ptAcctT.setInt(1, accountNum);	
		ptAcctT.execute();
	}
	public void wireSwitchX(int accountNum) throws SQLException {
		bdiT.connectionPoint();
		String query4 = "UPDATE Account SET wirestatus = 'X' WHERE account_no = ?";
		ptAcctT = Validator.conn.prepareStatement(query4);
		ptAcctT.setInt(1, accountNum);	
		ptAcctT.execute();
	}
	/*
	public void wirePending(int wireAcctNo, int y) throws SQLException {
		String wireP = "Y";
		String wireResp;
		String query4 = "select wirestatus from account where account_no = ?";
		ptAcctT = Validator.conn.prepareStatement(query4);
		ptAcctT.setInt(1, x);	
		// ptAcctT.execute();
		rsT = ptAcctT.executeQuery();
		wireP = rsT.getString(query4);
		if(rsT.equals(wireP)) {
			System.out.println("You have a pending wire: Accept = A or decline = B");
		wireResp = scanT.nextLine();
		if(wireResp == "A") {
			wireSwitchX(wireAcctNo);	
		}else {
			
			
			wireSwitchX(wireAcctNo);	
		}
		
		
		
		
	}
	
	
	*/
	
	public double TransferAccount(char b) throws NullPointerException, SQLException {
		char passT = ' '; 
		int respAccNo;
		tranAmount=0;
		System.out.println("Enter Account UserName:");
		userName = scanT.nextLine();
		System.out.println("Enter reciepients account number");
		respAccNo = scanT.nextInt();
		scanT.nextLine();
		accountBalanceT(respAccNo);
		System.out.println("qqqqqqqqqqqqqqqqqq    "+ accountBalanceT(respAccNo));
		setAccountBalance('B',respAccNo,tranAmount);
		passT = b;
		acctNreturnedT = fetchAccountNo(userName);
		
		accountBalanceT(acctNreturnedT);
		System.out.println("Enter transaction Ammount: ");
		tranAmount = scanT.nextDouble();
		scanT.nextLine();
		if(tranAmount >0 && tranAmount < accountBalanceT(acctNreturnedT)) {
			setAccountBalance(passT,acctNreturnedT,tranAmount);
			setAccountBalance('B',respAccNo,tranAmount);
			if(b == 'D') {
			wireSwitchY(respAccNo);
			}
		}
		return tranAmount;
	}
	
	public void updateTransaction(char b) throws NullPointerException, SQLException {
		char pass;
		
		System.out.println("Enter Account UserName:");
		userName = scanT.nextLine();
		pass = b;
		String s= "abababa";
		acctNreturnedT = fetchAccountNo(userName);
		accountBalanceT(acctNreturnedT);
		System.out.println("Enter transaction Ammount: ");
		tranAmount = scanT.nextDouble();
		scanT.nextLine();
		if(pass == 'B') {
			if (tranAmount >0) {
				setAccountBalance(pass,acctNreturnedT,tranAmount);
			}else 
				System.out.println("invalid entry try again");
				}
		else if(pass == 'C') {
			if(tranAmount >0 && tranAmount < accountBalanceT(acctNreturnedT)) {
				setAccountBalance(pass,acctNreturnedT,tranAmount);
			}else
				System.out.println("invelid entry try again");
		}
		//setAccountBalance(pass,acctNreturnedT,tranAmount);
	}
	
	//takes in user name and return the account number (acctT) associated with the account
	public int fetchAccountNo(String userName) throws SQLException {
		bdiT.connectionPoint();
		String query4 = "select Account_No from login2 where username =?";
		ptAcctT = Validator.conn.prepareStatement(query4);
		ptAcctT.setString(1, userName);
		// ptAcctT.execute();
		rsT = ptAcctT.executeQuery();
		rsT.next();
		acctNT = rsT.getInt("Account_NO");
		rsT.close();
		System.out.println("Your account Number is: " + acctNT);
		return acctNT;
		
	}
	
	// takes in account number and return account balance
	public double accountBalanceT(int account_no) throws SQLException {
		bdiT.connectionPoint();
		String query4 = "select balance from account where account_no =?";
		ptAcctT = Validator.conn.prepareStatement(query4,1);
		ptAcctT.setInt(1, account_no);
		ptAcctT.execute();
		rsT = ptAcctT.executeQuery();
		rsT.next();
		accountBalanceT = rsT.getDouble("Balance");
		System.out.println("Your account balance is: " + accountBalanceT);
		return accountBalanceT;
	}
	
	public void setAccountBalance(char xResponse,int account_no, double amountT) throws SQLException {
		System.out.println("entered SAB");
		//BankApp Bresp = new BankApp();
		char fResponse;
		fResponse = xResponse;
		bdiT.connectionPoint();
		//double remainder = 150;
		
		System.out.println("the response 1111111111111111111111111111111"+ xResponse);
		if (xResponse == 'C'||xResponse == 'D') {
		remainT = accountBalanceT(account_no) - amountT;} 
		else if(xResponse == 'B') {
		remainT = accountBalanceT(account_no) + amountT;} 	
		String query4 = "UPDATE Account set Balance = ? where account_no = ?";
		ptAcctT = Validator.conn.prepareStatement(query4);
		ptAcctT.setDouble(1, remainT);
		ptAcctT.setInt(2, account_no);
		// ptAccount.execute();
		rsT = ptAcctT.executeQuery();
		rsT.next();
		//accountBalance = rs.getDouble("Balance");
		System.out.println("Your account balance is: " + remainT);
		//return accountBalance;
	}	
}
