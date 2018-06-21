package com.xh.bbs.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;

@SuppressWarnings("serial")
public class UPdeleteReplyByIdServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String replyid=request.getParameter("rid");
		int rid=Integer.parseInt(replyid);
		String forumid=request.getParameter("fid");
		
		BbsServiceInf service=new BbsServiceImpl();
		service.deleteReplyByRid(rid);
		
		request.setAttribute("forumid", forumid);
		request.getRequestDispatcher("UPfindReplyById").forward(request, response);
	}
}
