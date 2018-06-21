package com.xh.bbs.servlet;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")

public class Test1Servlet extends HttpServlet {
	
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		out.println("hello");
		out.flush();
		out.close();
	}
	
	
}
