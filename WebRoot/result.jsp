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
    
    <title>My JSP 'result.jsp' starting page</title>
    
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
	<script type='text/javascript'>
$(function(){
      var chart = iChart.create({
            render:"ichart-render",
            width:800,
            height:400,
            background_color:"#2e3b4e",
            gradient:false,
            color_factor:0.2,
            border:{
                  color:"#404c5d",
                  width:1
            },
            align:"center",
            offsetx:0,
            offsety:-20,
            sub_option:{
                  border:{
                        color:"#fefefe",
                        width:1
                  },
                  label:{
                        fontweight:600,
                        fontsize:20,
                        color:"#f5f5f5",
                        sign:"square",
                        sign_size:12,
                        border:{
                              color:"#BCBCBC",
                              width:1
                        },
                        background_color:"#fefefe"
                  }
            },
            shadow:true,
            shadow_color:"#fafafa",
            shadow_blur:10,
            showpercent:false,
            column_width:"70%",
            bar_height:"70%",
            radius:"90%",
            title:{
                  text:"Let ichartjs Bring You Into Magical World",
                  color:"#f5f5f5",
                  fontsize:24,
                  font:"Verdana",
                  textAlign:"left",
                  height:30,
                  offsetx:36,
                  offsety:0
            },
            subtitle:{
                  text:"一周工作心情指数(百分制)",
                  color:"#8d9db5",
                  fontsize:24,
                  font:"微软雅黑",
                  textAlign:"left",
                  height:50,
                  offsetx:36,
                  offsety:6
            },
            footnote:{
                  text:"by IDC Puxi Operating Center ",
                  color:"#8d9db5",
                  fontsize:14,
                  font:"微软雅黑",
                  textAlign:"right",
                  height:30,
                  offsetx:-32,
                  offsety:0
            },
            legend:{
                  enable:true,
                  background_color:"rgba(254,254,254,0.2)",
                  color:"#c1cdde",
                  fontsize:13,
                  border:{
                        color:"#85898f",
                        width:0
                  },
                  column:5,
                  align:"right",
                  valign:"top",
                  offsetx:-32,
                  offsety:-40
            },
            coordinate:{
                  width:"92%",
                  height:"80%",
                  background_color:"rgba(246,246,246,0.05)",
                  axis:{
                        color:"#bfbfc3",
                        width:["","",6,""]
                  },
                  grid_color:"#c0c0c0",
                  label:{
                        fontweight:500,
                        color:"#f5f5f5",
                        fontsize:0
                  }
            },
            label:{
                  fontweight:600,
                  color:"#f5f5f5",
                  fontsize:18
            },
            type:"column2d",
            data:[
                  {
                  name:"Mon.",
                  value:50,
                  color:"rgba(131,166,213,0.9)"
            },{
                  name:"Tues.",
                  value:60,
                  color:"rgba(243,125,178,0.9)"
            },{
                  name:"Wed.",
                  value:70,
                  color:"rgba(237,236,238,0.9)"
            },{
                  name:"Thur.",
                  value:80,
                  color:"rgba(143,198,64,0.9)"
            },{
                  name:"Fri.",
                  value:90,
                  color:"rgba(100,139,191,0.9)"
            }
            ]
      });
      chart.draw();
});
  </script>
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
