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

public class UpdateDemoData
{
	public  static void main(String[] args)
	{
		// creating the object to call method 
		UpdateDemoData ud = new UpdateDemoData();
		ud.inputUser();
	}
	public void inputUser()
	{
		// creating scanner class to take input from user
		Scanner sc = new Scanner(System.in);
		
		// Enter the SrNo
		System.out.println("Enter The SrNo");
		int srNo = sc.nextInt();
		
		// Enter the Name
		System.out.println("Enter The Name");
		String name = sc.next();

		// Enter the Gender
		System.out.println("Enter The Gender");
		String gender = sc.next();
		
		
		//updateRecordUsingStatement(srNo, name, gender);
		updateRecordUsingPreparedStatement(srNo, name, gender);
	}
	public void updateRecordUsingPreparedStatement(int srNo, String name, String gender)
	{
		// url of the database
		String url = "jdbc:postgresql://localhost:5432/km-doc-offline";
		
		// username and password to access database
		String username = "postgres";
		String password = "root";
		
		String updateQuery = "UPDATE phone_book SET name = ?, gender = ? WHERE sr_no = ?";
		
		System.out.println(updateQuery);

		try{
			//Load the Driver
			Class.forName("org.postgresql.Driver");
			
			// creating connection between the java appliction and database
			Connection con = DriverManager.getConnection(url, username, password);
			
			// Creating The Statement
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setString(1, name);
			pst.setString(2, gender);
			pst.setInt(3, srNo);
			
			//Executin The Query
			int n = pst.executeUpdate();
			if(n > 0)
			{
				System.out.println("Updated Succesfully :");
			} else {
				
				System.out.println("Updated Failed");
			}
			// closeing the connection
			pst.close();
			con.close();
			
		 } catch (Exception e){		
			// Display the message when exceptions
			System.out.println(e);
			}
		}

		public void updateRecordUsingStatement(int srNo, String name, String gender)
		{
			// url of the database
			String url = "jdbc:postgresql://localhost:5432/km-doc-offline";
			
			// username and password to access database
			String username = "postgres";
			String password = "root";
			
			String updateQuery = "UPDATE phone_book SET name = '" + name + "', gender = '" + gender + "' WHERE sr_no = "+srNo;
			
			System.out.println(updateQuery);

			try{
				//Load the Driver
				Class.forName("org.postgresql.Driver");
				
				// creating connection between the java appliction and database
				Connection con = DriverManager.getConnection(url, username, password);
				
				// Creating The Statement
				Statement st = con.createStatement();
				
				//Executin The Query
				int n = st.executeUpdate(updateQuery);
				if(n > 0)
				{
					System.out.println("Updated Succesfully :");
				} else {
					
					System.out.println("Updated Failed");
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
