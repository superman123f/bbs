package com.xh.bbs.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;

import com.xh.bbs.entity.*;

@SuppressWarnings("serial")
public class MSeeUserForumServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response){
		String user_id=request.getParameter("uid");
		int uid=Integer.parseInt(user_id);
		
		BbsServiceInf service=new BbsServiceImpl();
		List<ForumEntity> forumlist=service.seeUserForumList(uid);
	
		
		try {
			request.setAttribute("forum",forumlist);
			request.getRequestDispatcher("page/manager/userforumlist.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
