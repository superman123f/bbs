package com.xh.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.entity.UserEntity;
import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;

@SuppressWarnings("serial")
public class ReleaseServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		UserEntity user = (UserEntity)request.getSession().getAttribute("user");
		
		ForumEntity forum = new ForumEntity();
		forum.setTitle(title);
		forum.setContent(content);
		forum.setAuthor(user);
		forum.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		BbsServiceInf service = new BbsServiceImpl();
		service.createForum(forum);
		response.sendRedirect("forumList");
	}
}
