
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

public class GFGDemo
{
	public static void main(String[] args) 
	{
		GFGDemo demo = new GFGDemo();
		demo.readDataFromDatabase();	
	}
	
	public void readDataFromDatabase() {
		
		try {
			// creating table details
			String url = "jdbc:postgresql://localhost:5432/km-doc-offline";
			
			// PostGresql credentials
			String username = "postgres";
			String password = "root";
			
			// my phone_book query to be run
			String query = "select *from phone_book";
			
			// Driver name
			Class.forName("org.postgresql.Driver");
			
			// creating the connection between the java application and database
			Connection con = DriverManager.getConnection(url, username, password);
			
			// creating the statement 
			Statement st = con.createStatement();
			
			// Execute the querry
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
			
				// Retrieve name from db
				int srNo = rs.getInt("sr_no");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int phoneNo = rs.getInt("phone_no");
				Date cd = rs.getDate("created_date");
				boolean ia = rs.getBoolean("is_active");
				
				// print result on console
				System.out.print("Sr No : "+ srNo + " | ");
				System.out.print("Name : "+ name + " | ");
				System.out.print("Gender : "+ gender + " | ");
				System.out.print("Phone No : "+ phoneNo + " | ");
				System.out.print("Created Date : "+ cd + " | ");
				System.out.print("Active : "+ ia);
				System.out.println();
			
			}

			
			// close statement
			st.close();
			
			// close connection
			con.close();
			
			System.out.println("Connection Closed");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}