<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name = (String) request.getSession().getAttribute("name");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>考试准备</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="choose.css">
	<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link href='http://fonts.useso.com/css?family=Gentium+Basic:400,700,400italic,700italic' rel='stylesheet' type='text/css'>		<!-- js -->
	<script src="js/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Buje Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
</head>
<body>
	<div class="container">
   		<div class="nav">
   			<div class="nav_back"></div>
   			<div class="nav_text"> <h5>你好！<%=name %>，请选择将要参加的考试。</h5></div>
   		</div>
   		<div class="exam_choice">
   		 	<div class="context" >
		 	<div class="background"></div>
		 	<div class="text">
		 		<span>1.</span><br>
				<span>《岗位练兵考试》</span>
				<a href="exam.jsp">点击进入考试</a><br>
				<br>
				<span>-------------------------------------------------------------------------------</span><br>
				<span>2.</span><br>
				<span>《岗位练兵考试》</span>
				<a href="testrecord.jsp">查看考试详情</a>
		 	</div>
		 	</div>
		</div>
   		<div class="bottom">
	 		<div class="bottom_back"></div>
	 		<div class="bottom_text"><h5>中国电信</h5></div>
	 	</div>
	 </div>
</body>
</html>
