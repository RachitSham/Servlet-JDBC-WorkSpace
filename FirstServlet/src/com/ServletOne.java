//copy servlet-api.jar file to project lib folder from tomact/lib folder
//set classpath=%classpath%;.;C:\JavaBasicWork\FirstServlet\WEB-INF\lib\servlet-api.jar
//save this file in project/src folder
//compile with javac and generate .class file
//copy all class file into project/WEB-INF/classes folder [inluding packages]

package com;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class ServletOne extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try{
		PrintWriter out = response.getWriter();
		out.println("<h1> Hello Servlet ! How Are You</h1>");
		} catch (Exception e){
	}
		
	}
}