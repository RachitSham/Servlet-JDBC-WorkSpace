package com.in.workspace.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.in.workspace.dao.DbConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class RegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String myname = req.getParameter("name");
		String myemail = req.getParameter("email");
		String mypass = req.getParameter("pass");
		String mycity = req.getParameter("city");
		
		try {
			
			Connection con = DbConnection.getConnection();
			
			String insert_sql_query = "INSERT INTO register VALUES(?,?,?,?)"; 
			
			PreparedStatement ps = con.prepareStatement(insert_sql_query);
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mycity);	
			
			int count = ps.executeUpdate();
			
			if(count > 0) {
				out.println("<h3 style ='color: #7bde63'>Registered Successfully !</h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req, resp);
			} else {
				
				out.println("<h3 style ='color: red'>User not Registered due to some error !</h3>");

				
				RequestDispatcher rd = req.getRequestDispatcher("/register.html");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
