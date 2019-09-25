<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家庭显示页面</title>
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
<div class="container">    <center>
	<form action="Fabu1Servlet" method="post">
	<h2><label>问卷主题：</label>
	<input type="text"  name="zhuti" size=40 height=35 value="${zhuti }"> 
	</h2>
	<c:forEach items="${list }" var="li">
		<label>调查内容：</label>
	<input type="text" name="1" size=40 height=40 value="${li.neirong }">
	
	</br>
	</c:forEach>
	<label>调查内容：</label>
	<input type="text" placeholder="请输入调查内容" name="neirong" size=40 height=40 >
	<button type="submit">添加</button> 
	</form>
	</center>
	<center><a href="success.html"><button type="button" class="btn btn-info">确定发布</button></a><a href="ViewServlet"><button type="button" class="btn btn-defult">取消</button></a></center>
</div>

</body>
</html>