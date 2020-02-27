import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class User {
	
	Scanner s2 = new Scanner(System.in);
	Scanner s3 = new Scanner(System.in);
	List <String> infoList = new ArrayList <String> ();
	public void frontPage() {
		System.out.println("******************************************************");
		System.out.println("*****************WELCOME TO XYZ BANK******************");
		System.out.println("******************************************************");
		System.out.println("*************IF YOU ARE A CUSTOMER *******************");
		System.out.println("******************************************************");
		System.out.println("****            ENTER USER NAME:              ********");
		System.out.println("**********         PASS WORD:               **********");
		System.out.println("******************************************************");
		System.out.println("**********     NEW CUSTOMER PRESS -N-     ************");
		System.out.println("******************************************************");
	}
	public void greeter() {
		System.out.println("    Well come to bank ABC Signup page");
		System.out.println("    You can register for a new account");
		System.out.println("    by following the steps below");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("If you are an existing customer Press:    A");
		System.out.println("If you are a new  customer Press:         B");
		System.out.println("If you are an employee Press:             C");	
	}
	
	public void Employee() {
		String empResponse;
		System.out.println("If you want to view all transactions press:  X");
		System.out.println("If you want to view new applicant    press:  Z");
		empResponse = AllTransactions.scanT.nextLine();
		
	}
	
	public List<String> register() {

		System.out.println("Press Y if you want to register for a new account");
		String x = s2.nextLine();
		if (x.equalsIgnoreCase("Y") ) {
		System.out.println("Enter First Name:");
		infoList.add(s3.nextLine());
		System.out.println("Enter Last Name:");
		infoList.add(s3.nextLine());
		System.out.println("Enter User Name:");
		infoList.add(s3.nextLine());
		System.out.println("Enter Pass Word:");
		infoList.add(s3.nextLine());		
		}
		return infoList;
	}
	
	
}
