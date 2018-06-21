<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.xh.bbs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
<link rel="stylesheet" type="text/css" href="css/message.css"> 
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.bk{  
  background-image: url(http://mpic.tiankong.com/561/5d6/5615d6afeeaf9e8f4bef8367f0984a39/4251r-2786.jpg);  
  background-repeat: no-repeat;  
  background-size: 100% auto;  
}
</style>
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
      <li><a href="TouristHome"><span class="glyphicon glyphicon-user"></span> 退出论坛</a></li>
      
    </ul>
  </div>
</nav>
<div  class="container"><!-- 中间的 -->
<nav class="navbar navbar-default" role="navigation">
<div class="panel panel-default">
<div class="panel-body">

<table class="table table-bordered"  >
	<% UserEntity user=(UserEntity)request.getAttribute("userinfo");%>
	<tr ><td >头像:</td>
	<td ><img src="<%=user.getUser_face()%>"></td></tr>
	<tr ><td >学号:</td><td ><%=user.getUser_id() %></td></tr>
	<tr class="tr"><td >姓名:</td><td ><%=user.getUser_name() %></td></tr>
	<tr ><td >性别:</td><td ><%=user.getUser_sex() %></td></tr>
	
	<tr ><td >联系电话</td><td ><%=user.getUser_phone() %></td></tr>
	<tr ><td >电子邮箱:</td><td ><%=user.getUser_email() %></td></tr>
	<tr ><td >来自哪里:</td><td ><%=user.getUser_from() %></td></tr>
	</table>
	<div class="form-group" align="center">
		<input type="button"  class="btn btn-primary" onclick="location.href='page/user/updateinfo.jsp'" value="修改资料" class="button">	
		<input type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/forumList'" value="返回主页" class="button" >
	</div>
</div></div></nav></div>
</body>
</html>