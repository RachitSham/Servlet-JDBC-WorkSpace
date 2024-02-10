package com;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;

public class ServletSecond extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<h1> This Is My Second Servlet Program </h1>");
		} catch (Exception e) {
			
		}
	}
}