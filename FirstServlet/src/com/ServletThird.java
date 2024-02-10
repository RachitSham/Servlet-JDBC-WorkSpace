package com;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;


public class ServletThird extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<h1>Hello Servlet ! This Is My Thrid Servlet Program</h1>");
		} catch (Exception e){
			
		}
	}
}