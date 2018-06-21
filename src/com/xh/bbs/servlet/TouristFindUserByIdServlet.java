package com.xh.bbs.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.UserEntity;
import com.xh.bbs.service.UserServiceImpl;
import com.xh.bbs.service.UserServiceInf;

@SuppressWarnings("serial")
public class TouristFindUserByIdServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String u_id=request.getParameter("uid");
		int uid=Integer.parseInt(u_id);
		
		UserServiceInf service=new UserServiceImpl();
		UserEntity user=service.findUser(uid);
		request.setAttribute("user",user);
		
		request.getRequestDispatcher("page/tourist/userinfo.jsp").forward(request, response);
		
		
	}
}
