<%@page import="entity.TestRecord"%>
<%@page import="dao.ExamResultRecordDAO"%>
<%@page import="entity.UserScoreRecord"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name = (String) request.getSession().getAttribute("name");
ArrayList<UserScoreRecord> userScoreRecords = 
	new ExamResultRecordDAO().getALLScoreRecordByUsername((String)request.getSession().getAttribute("username"));
ArrayList<TestRecord> testRecords = 
	new ExamResultRecordDAO().getAllTestRecordByUsername((String)request.getSession().getAttribute("username"), false);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试详情</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="main.css" rel="stylesheet" type="text/css" media="all" />
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
  			<div class="nav_text"><h5>你好！<%=name %>，测试详情</h5></div>
		</div>
		<div class="exam">
    		<%if(!userScoreRecords.isEmpty()){
    			for(int i=0;i<userScoreRecords.size();i++){
    				UserScoreRecord userScoreRecord = (UserScoreRecord)userScoreRecords.get(i);
    				%>
    				<div class="result">
    				<div class="background"></div>
    				<div class="text">
    				<span><%=i%>.测试时间：</span><%=userScoreRecord.getDate()%><br>
    				<span>测试成绩：</span><%=userScoreRecord.getScore()%><br>
					</div>
					</div>
    				<%
    			}	
    		}
    		 %>
    		 <%if(!testRecords.isEmpty()){
    			 for(int j=0;j<testRecords.size();j++){
    				 TestRecord testRecord = (TestRecord)testRecords.get(j);
    				 %>
    				<div class="result">
    				<div class="background"></div>
    				<div class="text">
    				<span><%=j%>.测试时间：</span><%=testRecord.getDateTime()%><br>
    				<span>答错题目：</span><%=testRecord.getQuestion()%><br>
					</div>
					</div>
    				 <%
    			 }
    		 } 
    		 	
    		 %>
		</div>
		<div class="bottom"><h5>中国电信</h5></div>
	</div>
</body>
</html>