package com.xh.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.ForumEntity;
import com.xh.bbs.entity.ReplyEntity;
import com.xh.bbs.entity.UserEntity;
import com.xh.bbs.service.BbsServiceImpl;
import com.xh.bbs.service.BbsServiceInf;

@SuppressWarnings("serial")
public class ReplyServlet extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int fid = Integer.parseInt(request.getParameter("fid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		String replyContent = request.getParameter("content");
	
		ForumEntity forum = new ForumEntity();
		forum.setFid(fid);
	
		UserEntity user = new UserEntity();
		user.setUser_id(uid);
		
		ReplyEntity reply = new ReplyEntity();
		reply.setForum(forum);
		reply.setUser(user);
		reply.setContent(replyContent);
		reply.setReplyTime(new java.sql.Timestamp(new java.util.Date().getTime()));

		BbsServiceInf service = new BbsServiceImpl();
		service.createReply(reply);
	
		response.sendRedirect("replyList?fid="+fid);
		
	}
}
