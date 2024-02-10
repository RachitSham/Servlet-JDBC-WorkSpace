package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;
public class StudentAddmission extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			String sName = request.getParameter("sName");
			String fName = request.getParameter("fName");
			String dob = request.getParameter("dob");
			String add = request.getParameter("add");
			String eMail = request.getParameter("eMail");
			String gen = request.getParameter("gen");
			String mNo = request.getParameter("mNo");
			
			PrintWriter out = response.getWriter();
			out.println("<h3>Addmission Form Has Been Fetched Correctly.</h3>");
			out.println("<h3>Well Done ! Your Data Has Been Fetched.</h3>");
		} catch (Exception e){
			
		}
	}
}