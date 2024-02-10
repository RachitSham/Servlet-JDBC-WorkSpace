package com;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;

public class ServletFormFive extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String myName = request.getParameter("pName");
			PrintWriter out = response.getWriter();
			out.println("Good Mormning !"+myName);
		} catch (Exception e){
			
		}
	}
}