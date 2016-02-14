<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script src='http://www.ichartjs.com/ichart.latest.min.js'></script>
	<link href="main.css" rel="stylesheet" type="text/css" media="all" />
	<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link href='http://fonts.useso.com/css?family=Gentium+Basic:400,700,400italic,700italic' rel='stylesheet' type='text/css'>		<!-- js -->
	<script src="js/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Buje Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
  	<%
  	User user = (User) request.getSession().getAttribute("user");
  	String name = user.getName();
	Double score = (Double)request.getSession().getAttribute("score");
	%>
  </head>
  <body>
    <div class="container">
    <div class="nav">
    <div class="nav_back"></div>
    <div class="nav_text">
    <h5>你好！<%=name %>。你的成绩是<%=score %>分。</h5>
    </div>
    </div>
    <div class="examResult">
    <div class="context">
   
    <div class="background"></div>
    <div class="text">
    <br>
<!--       <div id='ichart-render'></div> -->
    </div>
    </div>
    <div class="bottom">
	 <h5>中国电信</h5>
	 </div>
	 </div>
    </div>
  </body>
</html>
