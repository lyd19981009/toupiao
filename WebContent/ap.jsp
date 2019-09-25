<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	
    <c:when test="${ b==-1}">
       	 	<script>

			alert("请将信息填写完整！")
			location.href="zhuce.html";
			</script>
    </c:when>
    <c:when test="${ b==23}">
       <script>

			alert("手机号已注册！")
			location.href="zhuce.html";
			</script>
    	</c:when>
    <c:when test="${ b==-3}">
       	 	<script>

			alert("请输入正确的手机格式！！！")
			location.href="zhuce.html";
			</script>
    </c:when>
    <c:when test="${ b==-4}">
       	 	<script>

			alert("恭喜你！注册成功！！")
			location.href="denglu.html";
			</script>
    </c:when>
    <c:when test="${ b==-6}">
       	 	<script>

			alert("请将信息填写完整！")
			location.href="denglu.html";
			</script>
    </c:when>
    <c:when test="${ b==-5}">
       	 	<script>

			alert("手机号或密码输入错误！")
			location.href="zhuce.html";
			</script>
    </c:when>
    <c:when test="${ b==24}">
       	 	<script>

			alert("登陆成功！")
			location.href="ViewServlet";
			</script>
    </c:when>
     <c:when test="${ b==-7}">
       	 	<script>

			alert("请输入问卷主题！")
			location.href="Fabu.html"
			</script>
    </c:when>
    <c:when test="${ b==-8}">
       	 	<script>

			alert("请输入文具内容！")
			location.href="FabuServlet"
			</script>
    </c:when>
</c:choose>
</body>
</html>