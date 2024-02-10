package dao;

import java.sql.*;
import java.io.*;
import java.util.*;

public class SearchPhonebookDao
{
	public List<ArrayList<String>> searchData(String searchName)
	{
		System.out.println("Calling SearchPhonebookDao class");		
		//Creating The Object Of List Into Array list Object 
		List allRecords = new ArrayList<ArrayList<String>>();
		
		// This Is The Database Name.
		String url="jdbc:postgresql://localhost:5432/km-doc-offline";
		String username = "postgres";
		String password = "root"; 
		
		// Searching The Query from PhoneBook table
		String searchQuery = "SELECT CONTACT_NAME, GENDER, PHONE_NO FROM Phone_Table_Data where contact_name = ?";
		
		try{
			//Load The Driver
			Class.forName("org.postgresql.Driver");
			
			//Creating The Connection Object To Establish The Connection Between JavaApplication and Database
			Connection con =DriverManager.getConnection(url, username, password);
			
			//Creating The Statement Object 
			PreparedStatement pst =con.prepareStatement(searchQuery);
			pst.setString(1, searchName);
			
			//Executing The Query
			ResultSet rs = pst.executeQuery();
			
			 while(rs.next()) {
			// Crating The Object Of Array List. 	 
			  List record = new ArrayList<String>();
			  String contactName = rs.getString("contact_name");
			  String gender = rs.getString("gender");
			  String phoneNo = rs.getString("phone_no");
			  
			  // //Adding The Element In The List.
			  record.add(contactName);
			  record.add(gender);
			  record.add(phoneNo);
			  
			  allRecords.add(record); 
		  }  
		  
		  // closing the Statement
		  pst.close();
		  
		  // Closing The Connection
		  con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return allRecords;
	}
}