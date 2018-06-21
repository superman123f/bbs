package com.xh.bbs.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.UserEntity;
import com.xh.bbs.service.UserServiceImpl;
import com.xh.bbs.service.UserServiceInf;
@SuppressWarnings("serial")
public class MUserListServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserServiceInf service=new UserServiceImpl();
		List<UserEntity> userList=service.findUserList();		
					
		request.setAttribute("userList", userList);	
		request.getRequestDispatcher("page/manager/userlist.jsp").forward(request, response);
		
	}
}
