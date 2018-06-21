package com.xh.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bbs.entity.UserEntity;
import com.xh.bbs.service.UserServiceImpl;
import com.xh.bbs.service.UserServiceInf;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
//		 String user_id = request.getParameter("user_id");
			 
		 String userid = request.getParameter("user_id");
		 int user_id=Integer.parseInt(userid);
		 String user_name = request.getParameter("user_name");
		 String user_password = request.getParameter("md5Pwd");		 
		 String user_sex = request.getParameter("user_sex");
		 String user_face = request.getParameter("user_face");
		 String user_phone = request.getParameter("user_phone");
		 String user_email = request.getParameter("user_email");
		 String user_from = request.getParameter("user_from");
		 				 
		 UserEntity user = new UserEntity();
		 user.setUser_id(user_id);
		 
		 user.setUser_name(user_name);
		 user.setUser_password(user_password);
		 user.setUser_sex(user_sex);
		 user.setUser_face(user_face);
		 user.setUser_phone(user_phone);
		 user.setUser_email(user_email);
		 user.setUser_from(user_from);
		 
		 UserServiceInf service = new UserServiceImpl();
		 service.saveUser(user);
		 		 
		 //PrintWriter out=response.getWriter();
		 
		 response.sendRedirect("login.jsp");
		 //out.print("<a href='login.jsp'>注册成功，请返回登录界面</a>");
		 
	}
}
