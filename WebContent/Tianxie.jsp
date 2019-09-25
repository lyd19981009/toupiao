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
<center><h1>   ${zhuti }问卷填写</h1></center>
</br>
<form action="JiaoServlet" method="get">
<input type="hidden" name="zhuti" value="${zhuti }">
<c:forEach items="${list }" var="li"><center>
<label>${li.neirong }</label><input name="${li.neirong }" type="radio" value="1" checked/>满意
					<input name="${li.neirong }" type="radio" value="2" />比较满意
					<input name="${li.neirong }" type="radio" value="3" />基本满意
					<input name="${li.neirong }" type="radio" value="4" />不满意
					<input name="${li.neirong }" type="radio" value="5" />很不满意
					</br>
					</center>
					</c:forEach>
					<center><button type="submit" class="btn btn-info">确定提交</button></center>
					</form>
</div> 
