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
public class UserInfoServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid=request.getParameter("uid");
		int user_id=Integer.parseInt(userid);
		UserServiceInf service=new UserServiceImpl();
		UserEntity userinfo=service.findUser(user_id);	
					
		request.setAttribute("userinfo", userinfo);		
		request.getRequestDispatcher("page/user/individualinfo.jsp").forward(request, response);
		
	}
}
