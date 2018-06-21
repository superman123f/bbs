package com.xh.bbs.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;
import com.xh.bbs.service.UserServiceImpl;
import com.xh.bbs.service.UserServiceInf;
@SuppressWarnings("serial")
public class MDeleteUserInfoServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid=request.getParameter("uid");
		int user_id=Integer.parseInt(userid);
	
		BbsServiceInf bbs=new BbsServiceImpl();
		
		
		bbs.dUserAllreplyByUid(user_id);
		
		bbs.dUserOtherRelyByFid(user_id);
		
		bbs.dUserAllForumByUid(user_id);
			
		UserServiceInf service=new UserServiceImpl();
		service.deleteUser(user_id);
		
		
		
		response.sendRedirect("MUserList");		
	}
}
