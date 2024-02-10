package com;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;

public class ServletFormSeven extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try{
			String sname = request.getParameter("sName");
			String mNo = request.getParameter("mNo");
			String mail = request.getParameter("mail");

			PrintWriter out = response.getWriter();
			out.println("<h3> Your Details has Been Filled Correctly</h3>");
			out.println("<h3>Well Done! Your Data Is Fetched</h3>");
		} catch (Exception e) {
			
		}
	}
}