package com.xh.bbs.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;
@SuppressWarnings("serial")
public class UPersonDeleteForumServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		
//		PrintWriter out=response.getWriter();
//		out.println(forumid);
		
		
		String forumid=request.getParameter("fid");
		int fid=Integer.parseInt(forumid);	
		String uid=request.getParameter("uid");
		
//		int userid=Integer.parseInt(uid);
//		out.println(userid);
		
		BbsServiceInf service=new BbsServiceImpl();
		service.deleteReplyByFid(fid);
		service.deleteForumByFid(fid);
		
		
		
     	request.setAttribute("uid", uid);
		request.getRequestDispatcher("UPersonForumList").forward(request, response);
	}
}
