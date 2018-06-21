<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/md5.js"></script>

<title>登录</title>
<style type="text/css">

.STYLE1 {
	font-size: 24px;
	color: #000000;
}

.login{
  
   width:300px;
   height:400px;
   margin:auto;
   
}

.bk{  
  background-image: url(http://mpic.tiankong.com/561/5d6/5615d6afeeaf9e8f4bef8367f0984a39/4251r-2786.jpg);  
  background-repeat: no-repeat;  
  background-size: 140% 140%;  
</style>
<script type="text/javascript">

	function check_login(){
				var user_id = document.getElementById("user_id").value;
				var user_password = document.getElementById("user_password").value;
				//alert(id.value);
				
				//var user_id=document.forms.form1.user_id.value;
				//var user_password=document.forms.form1.user_password.value;
				
				//if(user_id == ""){
				//	alert("学号不能为空！");
				//	document.forms.form1.user_id.focus();
				//	return;
				//}
		
				//if(user_password == ""){
				//	alert("请输入密码！");
				//	document.forms.form1.user_password.focus();
				//	return;
				//}
				
		
				password=hex_md5(user_password);
				document.forms.form1.md5Pwd.value=password;
	
			document.form1.submit();		
	}
</script>

</head>
<body class="bk">
<div class="login">
     <form class="form1" id="form1" method="post" action="login">
        <h2 align="center" class="STYLE1">用户登录</h2>

        <label for="inputText" class="sr-only">Text</label>
        <input type="text" name="user_id" id="user_id" class="form-control" placeholder="学号" required oninvalid="setCustomValidity('学号不能为空')" oninput="setCustomValidity('')" autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="user_password" id="user_password" class="form-control" placeholder="密码" required oninvalid="setCustomValidity('密码不能为空')" oninput="setCustomValidity('')">
        <input type="hidden" name="md5Pwd" id="md5Pwd" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
        <button type="submit" class="btn btn-lg btn-primary btn-block" onclick="check_login()">登录</button>
         <button class="btn btn-lg btn-primary btn-block" onclick="location.href='register.jsp'" type="submit">注册</button>
         <button class="btn btn-lg btn-primary btn-block" onclick="location.href='TouristHome'" type="submit">返回</button>
      </form>
    </div> 
</body>
</html>