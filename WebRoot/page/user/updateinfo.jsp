<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xh.bbs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/css/code.css' />
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>修改个人信息</title>


<script>
	function isEmail(str){
		var email=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-]{2,3})+\.([a-zA-Z0-9_-]{2,3})+/;
		return email.test(str);
	}
	
	function isPhone(str){
		var phone=/^([0-9])+/;
		return phone.test(str);
	}
	
	function check_login(form1){
			var user_name=document.forms.form1.user_name.value;
			var user_password=document.forms.form1.user_password.value;
			var confirmPwd=document.forms.form1.confirmPwd.value;

			

			
			if(user_name==""){
				alert("请输入用户名！");
				document.forms.form1.user_name.focus();
				return;
			}
			
			if(user_password==""){
				alert("请输入密码！");
				document.forms.form1.user_password.focus();
				return;
			}
			
			if(confirmPwd==""){
				alert("请确认密码！");
				document.forms.form1.confirmPwd.focus();
				return;
			}
			
			if(user_password!=confirmPwd){
				alert("两次密码不一致！请重新输入！");
				return;
			}
			
			user_password=hex_md5(document.forms.form1.user_password.value);
			document.forms.form1.md5Pwd.value=user_password;
			
			if(document.forms.form1.user_sex.value==""){
				alert("请选择性别！");
				return;
			}
			
			//if(document.forms.form1.user_phone.value==""){
			//	alert("联系电话不能为空！");
			//	document.forms.form1.user_phone.focus();
			//	return;
			//}
			
			if(!isPhone(document.getElementById("userphone").value)){
				alert("电话格式不正确！");
				document.getElementById("userphone").focus();
				return false;
			}
						
			//if(document.forms.form1.user_email.value==""){
			//	alert("电子邮箱不能为空！");
			//	document.forms.form1.user_email.focus();
			//	return;
			//}
			
			if(!isEmail(document.getElementById("useremail").value)){
				alert("邮箱格式不正确！");
				document.getElementById("useremail").focus();
				return false;
			}
			
			if(document.forms.form1.user_from.value==""){
				alert("请输入地址！");
				document.forms.form1.user_from.focus();
				return;
			}			
								
			document.form1.submit();
		}
</script>

<style>
.bk{  
  background-image: url(http://mpic.tiankong.com/561/5d6/5615d6afeeaf9e8f4bef8367f0984a39/4251r-2786.jpg);  
  background-repeat: no-repeat;  
  background-size: 100% auto;  
}
</style>
</head>
<body class="bk">
<div class="container">
<nav class="navbar " role="navigation">
<h3>用户修改</h3>
	<form class="form-horizontal" name="form1" method="post" action="${pageContext.request.contextPath}/UserUpdateInfo">
		
		<div class="form-group">
			<label class="col-sm-2 control-label">学号：</label>
			<div class="col-sm-4">
	        <input class="form-control" type="text" name="user_id" value="${user.user_id}" readonly="readonly" >
		</div></div>
		
		<div class="form-group">
			  <label class="col-sm-2 control-label">用户名：</label>
			  <div class="col-sm-4">
	    	 <input class="form-control" id="user_name" type="text" name="user_name" placeholder="请输入用户名...">
		</div></div>
		
	  
	    
	<div class="form-group">
	   <label class="col-sm-2 control-label">密 码：</label>
	   <div class="col-sm-4">
	     <input class="form-control" id="userpassword" type="password" name="user_password" placeholder="请输入密码...">
		</div></div>
	   
	
	<div class="form-group">
	  <label class="col-sm-2 control-label"> 确认密码：</label>
	  <div class="col-sm-4">
	     <input class="form-control" id="confirmPwd" type="password" name="confirmPwd" placeholder="请输入确认密码...">
	      <input type="hidden" name="md5Pwd">
		</div></div>
	  
	  
	    
	   
	 
	    
	    
	    
	    
	  <div class="form-group">
		<label class="col-sm-2 control-label">  性别:</label>
		<div class="radio">
	      <label><input type="radio" name="user_sex" value="男" checked>男</label>
	      <label> <input type="radio" name="user_sex" value="女" >女</label>	
	  	</div>
		</div>   
	     
	    
	    
	  <div class="form-group">
	   <label class="col-sm-2 control-label">联系电话:</label>
	   <div class="col-sm-4">
	     <input class="form-control" id="userphone" type="text" maxlength=11 name="user_phone" placeholder="请输入联系电话...">
		</div></div>
	   
	    
	    
	  <div class="form-group">
	 <label class="col-sm-2 control-label"> 电子邮箱:</label>
	 <div class="col-sm-4">
	      <input class="form-control" id="useremail" type="text" maxlength=20 name="user_email" placeholder="请输入电子邮箱...">
		</div></div>
	      
	   
	    
	   <div class="form-group">
	    <label class="col-sm-2 control-label">来自哪里:</label>
	    <div class="col-sm-4">
	     <input class="form-control" id="userfrom" type="text" name="user_from" placeholder="请输入地址...">
		</div></div>
	    
	    <div class="form-group">    
	    	<label for="name" class="col-sm-2 control-label">选择头像:</label>
	    	<div class="col-sm-4">
	      	<div>
	      	   <img src="${pageContext.request.contextPath}/images/userface/user01.jpg" width="70" height="70" id="idface">
	        </div>
	    	
	    	
	    	
	     	<select class="form-control" placeholder=".col-lg-4" name="user_face" onchange="document.images['idface'].src=options[selectedIndex].value;">
	      	  <option value="${pageContext.request.contextPath}/images/userface/user01.jpg" selected>user1</option>
	      	 <option value="${pageContext.request.contextPath}/images/userface/user03.jpg">user2</option>	      	 
	      	 <option value="${pageContext.request.contextPath}/images/userface/user04.jpg">user3</option>
	      	 
	      	 <option value="${pageContext.request.contextPath}/images/userface/user11.jpg">user4</option>
	      	 <option value="${pageContext.request.contextPath}/images/userface/user17.jpg">user5</option>
	      	 <option value="${pageContext.request.contextPath}/images/userface/user19.jpg">user6</option>
  
  
	      </select> 
			</div></div>

	<div class="form-group">
	<label class="col-sm-2 control-label"></label>
	   <div class="col-sm-4">
       <button class="btn btn-primary" type="button" onclick="check_login()" >修改</button>
       <button class="btn btn-primary" type="reset"  >重置</button>
	   <button class="btn btn-primary" type="button" onclick="location.href='../../UserInfo?uid=${user.user_id}'"> 返回</button>
	   </div>
	</div>
	</form></nav></div>
	
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>

</html>