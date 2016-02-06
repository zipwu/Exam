<%@page import="entity.Question"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name = (String) request.getSession().getAttribute("name");
ArrayList list = (ArrayList)request.getSession().getAttribute("QuestionList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试</title>
    
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
	<script type="text/javascript">
	function countDown(secs)
	{
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if(--secs>0){
			setTimeout("countDown("+secs+")",1000); 
		}
	 	else{               
	     	-ma;
		} 
	}
 </script>
  </head>
  
    <body>
    <div class="container">
  	<div class="nav">
  	<div class="nav_back"></div>
  	<div class="nav_text">
  	<h5>你好！<%=name %>，现在进入考试&nbsp;&nbsp;&nbsp;&nbsp;<span id="jumpTo">1800</span>秒后系统会自动提交答案</h5>
  	 <script type="text/javascript">  
     countDown(1800);  
	 </script>  
  	</div>
	</div>
	<div class="exam">
	<form id="questionlistaction=" action="SubmitServlet" method="post">
	<script language="JavaScript"> 
	setTimeout("questionlist.submit();",1800000); 
	</script> 
	<%
			for(int i=0;i<list.size();i++){
				Question question = (Question)list.get(i);
				%>
		 <div class="context" >
		 <div class="background"></div>
		 <div class="text">
		 		<span>序号：<%=i+1%></span><br>
		 		<span>题目：<%=question.getQuestionString() %></span><br>
		 		<div class="option">
		 		<input type="checkbox" name="<%=question.getID() %>" value="A"/>A.<%=question.getChoiceA() %><br>
		 		<input type="checkbox" name="<%=question.getID() %>" value="B"/>B.<%=question.getChoiceB() %><br>
		 		<input type="checkbox" name="<%=question.getID() %>" value="C"/>C.<%=question.getChoiceC() %><br>
		 		</div>
		 		<%-- <%=question.getAnswer() %><%=question.getKeyword0() %> --%>
		 		<br>
		 		<br>
		 </div>
		 </div>
		 <%
			}
	 %>
	 <div class="bottom">
	 <div class="bottom_back"></div>
	 <div class="bottom_text">
	 <input type="submit"  value="提交试卷" />
	 <input type="reset"  value="重置答案" />
	 </div>
	 </div>
	</form>
	</div>
	</div>
  </body>
</html>
