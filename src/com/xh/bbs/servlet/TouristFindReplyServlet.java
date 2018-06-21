package com.xh.bbs.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;
@SuppressWarnings("serial")
public class TouristFindReplyServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int fid = Integer.parseInt(request.getParameter("fid"));
		BbsServiceInf service = new BbsServiceImpl();
		//查询所有的回复
		ForumEntity forum = service.findReplyList(fid);
		request.setAttribute("forum", forum);
		request.getRequestDispatcher("page/tourist/replyinfo.jsp").forward(request, response);
	}
}
