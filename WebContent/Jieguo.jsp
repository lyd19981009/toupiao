<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>填写问卷</title>
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
<center><h1>   所有问卷</h1></center>
</br>
<c:forEach items="${list }" var="li">
<center>
<label >${li.zhuti }</label>
<input type="hidden" name="${li.zhuti }" value="${li.zhuti }">
	<a href="JieguoServlet1?zhuti=${li.zhuti }"><button type="button" >查看结果</button></a>
	</br>
	</center>
</c:forEach>
</div>

</body>
</html>