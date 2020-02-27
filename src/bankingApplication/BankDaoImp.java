package bankingApplication;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankDaoImp implements BankDaoInt {
	
	static PreparedStatement ptAccount = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String query = null;
	PreparedStatement ptmt = null;
	User user = new User();
	double accountBalance;
	
	
	public double accountBalance(int account_no) throws SQLException {
		connectionPoint();
		String query4 = "select balance from account where account_no =?";
		ptAccount = conn.prepareStatement(query4,1);
		ptAccount.setInt(1, account_no);
		ptAccount.execute();
		rs = ptAccount.executeQuery();
		rs.next();
		accountBalance = rs.getDouble("Balance");
		System.out.println("Your account balance is: " + accountBalance);
		return accountBalance;
	}
	public double setAccountBalance(int account_no, double amount) throws SQLException {
		//System.out.println("entered SAB");
		BankApp Bresp = new BankApp();
		connectionPoint();
		double remainder = 150;
		if (Bresp.response == 'C') {
		remainder = accountBalance(account_no) - amount;} 
		else if(Bresp.response == 'B') {
			remainder = accountBalance(account_no) + amount;} 	
		String query4 = "UPDATE Account set Balance = ? where account_no = ?";
		ptAccount = conn.prepareStatement(query4);
		ptAccount.setDouble(1, remainder);
		ptAccount.setInt(2, account_no);
		// ptAccount.execute();
		rs = ptAccount.executeQuery();
		rs.next();
		//accountBalance = rs.getDouble("Balance");
		System.out.println("Your account balance is: " + accountBalance);
		return accountBalance;
	}
	
	
	
	public void connectionPoint() {
	
	String user= "jdbc:oracle:thin:@localhost:1521:ORCL";
	try {
	conn = DriverManager.getConnection(user, "pj", "pj");
	 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY);
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	}
	@Override
	public void insertUser() throws SQLException, NullPointerException {
		connectionPoint();
		int i = 1;
		List<String> lst = new ArrayList<String>();
		lst = user.register();
		Iterator<String> itr = lst.iterator();
		String query2 = "INSERT INTO customer VALUES (SEQ_Bank_id.nextval,?,?,?,?)";
		ptmt = conn.prepareStatement(query2);
		while (itr.hasNext()) {
			//System.out.println(itr.next());		
			ptmt.setString(i,itr.next());   
			i++;
			//System.out.println("counter inside input iterator" + i);
		}
		ptmt.execute();
		System.out.println("Enter Yor First name");		
			//ptmt.close();
	}
	@Override
	public User SelectUser(int accountNumber) {
		try {
			String name = "Boston";
			stmt = conn.createStatement();
			query = "select * from Store_information where Store_name='"+ name + "'";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
			}
		}
		catch(SQLException e) {
		e.printStackTrace();
		}
		return null;
	}
	@Override
	public void updateUser() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean deleteUser(int accountNumber) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public double setaccountBalance(int accountNo) {
		// TODO Auto-generated method stub
		return 0;
	}	
}