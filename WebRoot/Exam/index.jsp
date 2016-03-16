<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线考试</title>
		<link href="style.css" rel="stylesheet" type="text/css" media="all" />
		<!-- <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /> -->
		<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		<link href='http://fonts.useso.com/css?family=Gentium+Basic:400,700,400italic,700italic' rel='stylesheet' type='text/css'>		<!-- js -->
		<script src="js/jquery.min.js"></script>
		<!-- //js -->
		<!-- for-mobile-apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Buje Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

  </head>
  
 <body>
	<div id="home" class="banner">
		<div class="head-logo">
		<h2>数据中心工程师在线评估系统</h2>
		<p>我们做亚太地区最好的数据中心。<br>
		<span>We are operating the best Internet Data Centers in the Asian-Pacific.</span><br>
		</p>
		</div>
		<div class="banner-info">
		<form action="LoginServlet" method="post">
		<input type="text"  name="username" placeholder="请输入你的用户名" onblur="checkUserName(this.value);">
   		<input type="password" name="password"  placeholder="请输入你的密码" onblur="checkPassword(this.value);">
		<input type="submit" value="登陆">
		</form>
		</div>
	</div>	
 </body>
</html>
