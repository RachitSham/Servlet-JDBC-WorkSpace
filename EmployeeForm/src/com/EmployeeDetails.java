package com;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;

public class EmployeeDetails extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			String eName = request.getParameter("eName");
			String cName = request.getParameter("cName");
			String eId = request.getParameter("eId");
			String eEmail = request.getParameter("eEmail");
			String eMno = request.getParameter("eMno");
			String eAdd = request.getParameter("eAdd");
			
			PrintWriter out = response.getWriter();
			out.println("<h3>Employee Form Has Been Fetched Correctly.</h3>");
			out.println("<h3>Well Done ! Your Data Has Been Fetched.</h3>");
		} catch (Exception e ){
			
		}
	}
}