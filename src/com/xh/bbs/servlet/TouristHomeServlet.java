package com.xh.bbs.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;
@SuppressWarnings("serial")

public class TouristHomeServlet extends HttpServlet {

		public void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			BbsServiceInf service=new BbsServiceImpl();
			List<ForumEntity> forumList=service.findForumList();
			
			request.setAttribute("forumList", forumList);		
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		}
}
