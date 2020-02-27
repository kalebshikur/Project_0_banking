package bankingApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface BankDaoInt {
	
	
	public void insertUser() throws SQLException;
	public void updateUser() throws SQLException;
	public User SelectUser(int accountNumber);
	boolean deleteUser(int accountNumber) throws SQLException;
}
/*
try {
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

}
}
		
		
		*/