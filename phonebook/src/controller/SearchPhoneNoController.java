//Creating My Own Package.
package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;
import java.util.*;

// Calling service.SearchPhoneNoService Package in Controller class.
import service.SearchPhoneNoService;

public class SearchPhoneNoController extends HttpServlet
{
	//Creating doGet Methed To take input from The Html . 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			System.out.println("Calling SearchPhoneNoController class");
			//Creating Service class Object into Controller(servlet) class.
			SearchPhoneNoService sps = new SearchPhoneNoService();
			
			
			String prName  = request.getParameter("prName");
			
			//Calling Service class Method into Controller class.
			List<ArrayList<String>> searchRecords = sps.searchPhoneDetails(prName);
			
			//Creating PrintWriter object.
			PrintWriter out =response.getWriter();
			out.println(searchRecords);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
