<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">

.container{
background-color:pink
}
</style>
</head>
<body>
<div class="container">    
	<center><h1>在线投票欢迎你！</h1></center><h3 align="right">
	您好！${message }</h3>
	
	
	<center><a href="Fabu.html"><h1>发布调查问卷投票</h1></center></a>
	<center><a href="TXServlet"><h1>填写问卷投票</h1></center></a>
	<center><a href="JieguoServlet"><h1>查看调查结果</h1></center></a>
	
</div>
</body>
</html>