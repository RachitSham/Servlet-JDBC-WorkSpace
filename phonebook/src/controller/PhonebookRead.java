package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import java.util.*;
import java.io.*;
import service.PhonebookReadService;

public class PhonebookRead extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			PhonebookReadService prs = new PhonebookReadService();
			List<ArrayList<String>> dataRecord = prs.readPhoneDetails();
			
			PrintWriter out =response.getWriter();
			out.println(dataRecord);
		} catch (Exception e){
			
		}
	}
}