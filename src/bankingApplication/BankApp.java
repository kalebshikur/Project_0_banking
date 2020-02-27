package bankingApplication;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

public class BankApp {
	public static  char response;
	
	//private final Logger log = Logger.getLogger(log4J.class)

	public static void main(String[] args) throws SQLException {
		
		
		Employee em =new Employee();
		User s1 = new User ();
		User s2 = new User();
		s1.frontPage();
		String s = null;
		//Scanner scano = new Scanner(System.in);
		String response ;
		Customer obj1= new Customer();
		AllTransactions obj2= new AllTransactions();
		Validator valid = new Validator();
		BankDaoImp bdi1 = new BankDaoImp();
		Customer cus1 = new Customer();
		//em.empTransaction();
		s1.greeter();	
		String rsp = AllTransactions.scanT.nextLine();
		
		
		
		
		Validator.getConnect();
		if(rsp.equalsIgnoreCase("C")) {
			 if(em.EmpLogin()==1) {
				 s1.Employee();
				 
				 
			 }
		}else if (rsp.equalsIgnoreCase("B")) {
			bdi1.insertUser();
			
		}
		else if(valid.validate()==2) {
			do {
				
				System.out.println("***************    iF YOU WANT TO CHECK BALANCE PRESS    A   ************");
				System.out.println("***************    iF YOU WANT TO DEPOSITE MONEY PRESS   B   ************");
				System.out.println("***************    iF YOU WANT TO WITHDRAW MONEY PRESS   C   ************");
				System.out.println("***************    iF YOU WANT TO TRANSFER MONEY PRESS   D   ************");
				System.out.println("***************    iF YOU WANT TO EXIT                   E   ************");
				response =  AllTransactions.scanT.nextLine() ;
		
				switch (response) {
				case "A":bdi1.accountBalance(1001);
					break; 
				case "B":obj2.updateTransaction('B');
					break;
				case "C":obj2.updateTransaction('C');
					break;
				case "D":obj2.TransferAccount('D');
					break;
				case "E": System.out.println("Thank you. See you soon");
					break;
				}
			} while (!response.equals("E") );
	System.out.println(" OK, Bye Bye !!!! ");
			
		}
		}
	}


