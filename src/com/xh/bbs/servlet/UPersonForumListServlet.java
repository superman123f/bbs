package com.xh.bbs.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;
import com.xh.bbs.entity.ForumEntity;

@SuppressWarnings("serial")
public class UPersonForumListServlet extends HttpServlet {
	public void service (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		
		String user_id=request.getParameter("uid");

		if(user_id==null){
			String uid=(String)request.getAttribute("uid");
			int pid=Integer.parseInt(uid);
			
			BbsServiceInf service=new BbsServiceImpl();
			List<ForumEntity> personList=new ArrayList<ForumEntity>();
			personList=service.personForum(pid);
			request.setAttribute("perForumList", personList);
			request.getRequestDispatcher("page/user/myforum.jsp").forward(request, response);
		}else{
			int pid=Integer.parseInt(user_id);
			
			BbsServiceInf service=new BbsServiceImpl();
			List<ForumEntity> personList=new ArrayList<ForumEntity>();
			personList=service.personForum(pid);
			request.setAttribute("perForumList", personList);
			request.getRequestDispatcher("page/user/myforum.jsp").forward(request, response);
		}
		
		
//		PrintWriter out=response.getWriter();
//		out.println(user_id);
		
//		out.println(user_id);
		
		
	}
}
