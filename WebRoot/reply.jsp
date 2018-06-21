<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.xh.bbs.entity.*"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看回复</title>
<link rel="stylesheet" type="text/css" href="css/forum.css">
<style>
.replytable{
margin-left:50px;
}
</style>
<style>
.bk{  
  background-image: url(http://mpic.tiankong.com/561/5d6/5615d6afeeaf9e8f4bef8367f0984a39/4251r-2786.jpg);  
  background-repeat: no-repeat;  
  background-size: 100% auto;  
}
</style>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="bk">
<nav class="navbar navbar-inverse" role="navigation">
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
<div  class="container">
<nav class="navbar navbar-default" role="navigation">
<div>
  <img  src="images/logo.png" class="img-circle">
</div>
<%
  ForumEntity forum = (ForumEntity)request.getAttribute("forum");
%>
<div class="panel panel-default">
<div class="panel-body">
<form name="form1" method="post" action="reply">
<table class="table table-bordered"  >
  <tr class="ttr">
    <td width="95">标题</td>
    <td width="397"><%=forum.getTitle() %></td>
  </tr>
  <tr class="ttr">
    <td><%=forum.getAuthor().getUser_name() %></td>
    <td>发表于&nbsp;&nbsp;<%=forum.getCreateTime() %></td>
  </tr>
  <tr class="ttr">
    <td height="92"><img src="<%=forum.getAuthor().getUser_face() %>" class="img-circle">
    </td>
    <td>&nbsp;<%=forum.getContent() %></td>
  </tr>
  <%
    List<ReplyEntity> replyList = forum.getReplyList();
    for(ReplyEntity reply : replyList){
  %>
  <tr class="ttr">
    <td><%=reply.getUser().getUser_name() %></td>
    <td>回复于&nbsp;&nbsp;<%=reply.getReplyTime() %></td>
  </tr>
  <tr class="ttr">
    <td height="101" class="td1"> <img src="<%=reply.getUser().getUser_face() %>" class="img-circle">
      </td>
    <td class="td2">&nbsp;<%=reply.getContent() %></td>
  </tr>
  <%} %></table>
  <div class="form-group">
    
    <div class="col-sm-10">
    <textarea class="form-control" rows="5" name="content"></textarea>
           <button type="submit" name="Submit" value="回复" class="btn btn-default">回复</button>
	       <button type="button" value="返回" onclick="location.href='forumList'" class="btn btn-default">返回</button>
	       <input type="hidden" name="fid" value="<%=forum.getFid()%>"/>
	<!-- 回复人就是当前登录的用户 -->
	<%UserEntity replyUser = (UserEntity)session.getAttribute("user"); %>
	<input type="hidden" name="uid" value="<%=replyUser.getUser_id()%>"/>
    </div>
    </div>
	      
	          
    

	
</form></div></div></nav></div>
 
 
 
 
  <!--  <table class="logotop">
     <tr>
     <td id="logo">校园论坛</td>
     <td class="righttop"><a href = "home.jsp">注销</a></td>
     
     </tr>
     
  </table>
  <div  class="borad">
  <div class="boradtop">
  
     <img src="images/logo.png">
     <span>校园论坛</span>
  
  </div>
</div>
<p>&nbsp;</p>-->
</body>
</html>