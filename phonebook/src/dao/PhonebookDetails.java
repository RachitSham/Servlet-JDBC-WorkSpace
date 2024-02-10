// Creating My Own package.
package dao;

import java.sql.*;
import java.io.*;

public class PhonebookDetails
{
	// creating the Method
	public int insertData(String pName, String pGender, String pmNo)
	{
		// This Is The Database Name.
		String url="jdbc:postgresql://localhost:5432/km-doc-offline";
		String username = "postgres";
		String password = "root";
		int rs = 0;
		// Inserting The Value Into The Table.
		String insertQuery = "insert into Phone_Table_Data(CONTACT_NAME, GENDER, PHONE_NO) values(?,?,?)";
		
		//Using Try Catch To Handling The Exception.
		try{
			// Loading The Driver.
			Class.forName("org.postgresql.Driver");
				
			//Creating The Connection Object TO Established The Connection Between Java Application And Database.  	
			Connection connection = DriverManager.getConnection(url, username, password);
			
			//Creating The PreparedStatement object.
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			pst.setString(1, pName);
			pst.setString(2, pGender);
			pst.setString(3, pmNo);
			
			// executing The Query and Storeing  The value in rs. 
			rs = pst.executeUpdate();
			
			// Closing The Statement.
			pst.close();
			
			//Closeing The Connection.
			connection.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		//Returning The Value.
		return rs;
	}
}
