package dao;

import java.sql.*;
import java.util.*;

public class PhonebookReadDao
{
	public List<ArrayList<String>> readFromPhoneBook()
	{
		
		List allRecords = new ArrayList<ArrayList<String>>();
		
		// This Is The Database Name.
		String url="jdbc:postgresql://localhost:5432/km-doc-offline";
		String username = "postgres";
		String password = "root";
		
		
		//Reading Records From The Phonebook Table
		String selectQuery = "SELECT CONTACT_NAME, GENDER, PHONE_NO FROM Phone_Table_Data";
		
		try{
		  //Load The Driver.
		  Class.forName("org.postgresql.Driver");
		  
		  //Creating The Connection Object TO Established The Connection Between Java Application And Database. 
		  Connection con =DriverManager.getConnection(url, username, password);
		  
		  // Creating The Statement.
		  Statement st = con.createStatement();
		  
		  // executing The Query
		  ResultSet rs = st.executeQuery(selectQuery);
		  		  
		  while(rs.next()) {
			  List record = new ArrayList<String>();
			  String contactName = rs.getString("contact_name");
			  String gender = rs.getString("gender");
			  String phoneNo = rs.getString("phone_no");
			  
			  record.add(contactName);
			  record.add(gender);
			  record.add(phoneNo);
			  
			  allRecords.add(record);
		  }  
		  
		  // closing the Statement
		  st.close();
		  
		  // Closing The Connection
		  con.close();
		  
		} catch (Exception e){
			
		}
		return allRecords;
	}
}