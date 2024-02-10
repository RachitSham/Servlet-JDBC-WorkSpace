/*driver: org.postgresql.Driver

url:
jdbc:postgresql://localhost:5432/km-doc-offline

username: 
postgres

password:
root

 set classpath=%classpath%;.;C:\JavaBasicWork\postgresql-42.7.1.jar
*/

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ReadDataDemo
{
	
	public static void main(String[] args)
	{
		ReadDataDemo rd = new ReadDataDemo();
		rd.inputUser();
		
		GFGDemo demo = new GFGDemo();
		demo.readDataFromDatabase();
	}
	
	public void inputUser()
	{
		//Take input from the user
		Scanner sc = new Scanner(System.in);
		
		//Entering thr Serial No
		System.out.println("Enter The Serial No :");
		int srNo = sc.nextInt();
		
		// Entering the Name
		System.out.println("Enter The Name :");
		String name = sc.next();
		
		//Entering the Gender
		System.out.println("Enter The Gender :");
		String gender = sc.next();
		
		//Entering the Phone No
		System.out.println("Enter The PhoneNo :");																									
		int phoneNO = sc.nextInt();
		
		//Entering the Date
		System.out.println("Enter The Date :");
		String date = sc.next();  

		// Entering the is_Active
		System.out.println("Enter The Person Is_Active Or Not :");
		boolean isActive = sc.nextBoolean();
		
		writeToDatabase(srNo, name, gender, phoneNO, date, isActive);
	
	}
		// writing phone details data into phone_book table
	public void writeToDatabase(int srNo, String name, String gender, int phoneNo, String date, boolean isActive)
	{
		// url of the database
		String url = "jdbc:postgresql://localhost:5432/km-doc-offline";
		
		// username and password to access database
		String username = "postgres";
		String password = "root";
			
		String insertQuery = "insert into phone_book(sr_no, name, gender, phone_no, created_date, is_active) values ( " + srNo + ",'" + name + "', '" + gender + "', " + phoneNo + ", '" + date + "', " + isActive + ")"; 
		
		System.out.println(insertQuery);	
		
		try {
			// load the driver
			Class.forName("org.postgresql.Driver");
			
			// creating connection between the java appliction and database
			Connection con = DriverManager.getConnection(url, username, password);
			
			// creating a statement
			Statement st = con.createStatement();
			
			// Executing the Query
			int m = st.executeUpdate(insertQuery);
			if(m > 0)
			{
				System.out.println("Inserted Succesfully :");
			} else {
				
				System.out.println("Insertion Failed");
			}
			// closeing the connection
			st.close();
			con.close();
			
		} catch (Exception e){		
			// Display the message when exceptions
			System.out.println(e);
		}
	}
}