package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;

//Calling service package in PhonebookData.
import service.PhonebookService;

public class PhonebookData extends HttpServlet
{
	// Using doPost Method.
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		// creating The Object of PhonebookService in Controller.
		PhonebookService ps = new PhonebookService();
		try{
			// Read The Input By Using request.getParameter Method.
			String conInputName = request.getParameter("pName");
			String conInputGender = request.getParameter("pGender");
			String conInputPmNo = request.getParameter("pmNo");

			//calling PhonebookService method in Controller.
			int noRecordsEffected = ps.insertService(conInputName, conInputGender, conInputPmNo);
			
			// Creating The PrintWriter object To Print the Input.
			PrintWriter out = response.getWriter();
			if(noRecordsEffected > 0){
				out.println("The Details In The PhonebookData Success Inseted !");
			} else {
				out.println("Fill The Details In The PhonebookData CareFully !");
			}	
			out.println("PersonName: "+conInputName);
			out.println("PersonGender: "+conInputGender);
			out.println("PersonMobileNo: "+conInputPmNo);
		}catch(Exception e){
			
		}
	}
}