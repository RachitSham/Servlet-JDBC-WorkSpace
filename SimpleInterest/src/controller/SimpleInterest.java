package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.io.*;
import service.SimpleInterestService;

public class SimpleInterest extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			// creating service class object in the Servlet class (Controller)
			SimpleInterestService sis = new SimpleInterestService();
			
			String iPrinciple = request.getParameter("iPrinciple");
			String iRate = request.getParameter("iRate");
			String tYears = request.getParameter("tYears");
			
			Double p = Double.parseDouble(iPrinciple);
			Double r = Double.parseDouble(iRate);
			Double t = Double.parseDouble(tYears);
			
			// calling service class method in Controller
			double interst = sis.calculateInterest(p, r, t);
			
			PrintWriter out = response.getWriter();
			out.println("<h3>Calculate The Simple Interest.</h3>");
			out.println("Pricipal: "+iPrinciple);
			out.println("Rate: "+iRate);
			out.println("Years: "+tYears);
			out.println("Simple Interst: "+interst);
		}catch (Exception e){
			
		}
	}
}