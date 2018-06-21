package com.xh.bbs.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;

@SuppressWarnings("serial")
public class UPfindReplyByIdServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forumid=request.getParameter("fid");
		
		if(forumid==null){
			String fid=(String)request.getAttribute("forumid");
			int f_id=Integer.parseInt(fid);
			
			PrintWriter out= response.getWriter();
			out.println(f_id+"ewrew");
			
			BbsServiceInf service = new BbsServiceImpl();
			//查询所有的回复
			ForumEntity forum = service.findReplyList(f_id);
			request.setAttribute("forum", forum);
			request.getRequestDispatcher("page/user/preplyinfo.jsp").forward(request, response);
			
		}else{
			int fid = Integer.parseInt(forumid);
			
			PrintWriter out= response.getWriter();
			out.println(fid+"ewrew");
			
			BbsServiceInf service = new BbsServiceImpl();
			//查询所有的回复
			ForumEntity forum = service.findReplyList(fid);
			request.setAttribute("forum", forum);
			request.getRequestDispatcher("page/user/preplyinfo.jsp").forward(request, response);
		}	
		
		
		
	}
}
