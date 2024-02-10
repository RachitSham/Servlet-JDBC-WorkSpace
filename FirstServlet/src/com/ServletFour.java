package com;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;

public class ServletFour extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<h1>Hello Servlet ! This Is My Fourth Servlet And I Am Doing Well.</h1>");
			out.println("<h3>Byee Byee Servlet.</h3>");
		} catch (Exception e){
			
		}
	}
}