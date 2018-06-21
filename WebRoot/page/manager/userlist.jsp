<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xh.bbs.entity.UserEntity" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息列表</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/background.css" />
</head>
<body class="bk">
<nav class="navbar navbar-inverse" role="navigation"><!-- 顶部的菜单栏 -->
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="forumList">校园论坛</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${pageContext.request.contextPath}/UserInfo?uid=${user.user_id}"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
     <li><a href="${pageContext.request.contextPath}/UPersonForumList?uid=${user.user_id}"><span class="glyphicon glyphicon-user"></span> 我的帖子</a></li>
     <li><a href="${pageContext.request.contextPath}/TouristHome"><span class="glyphicon glyphicon-user"></span> 退出论坛</a></li>   
      
    </ul>
  </div>
</nav>
<div  class="container"><!-- 中间的 -->
<nav class="navbar navbar-default" role="navigation">
	<% List<UserEntity> userList=(List<UserEntity>)request.getAttribute("userList");%>
	<table class="table table-bordered">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>联系电话</th>
			<th>电子邮箱</th>
			<th>来自哪里</th>
			<th>操作</th>
		</tr>
		
		<% for(UserEntity user: userList){ %>
		<tr>
			<td><%=user.getUser_id() %></td>
			<td><%=user.getUser_name() %></td>
			<td><%=user.getUser_sex() %></td>
			<td><%=user.getUser_phone() %></td>
			<td><%=user.getUser_email() %></td>
			<td><%=user.getUser_from() %></td>
			<td>
				<a href="MDeleteUserInfo?uid=<%=user.getUser_id() %>">删除</a><br>
				<a href="MSeeUserForum?uid=<%=user.getUser_id() %>">查看帖子</a>
			</td>
		</tr>
		<%} %>
	
	</table>
	<a href="forumList">返回</a>
	</nav></div>

</body>
</html>