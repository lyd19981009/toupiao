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
	<h2><label>问卷主题：</label>
	<input type="text"  name="zhuti" size=40 height=35 value="${zhuti }"> 
	</h2>
	<table >
   <thead>
      <tr>
      	<th>调查内容</th>
        <th>满意</th>
        <th>基本满意</th>
        <th>比较满意</th>
        <th>不满意</th>
        <th>很不满意</th>
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${alist }" var="lista">
  		<tr>
  		
  			 <td class="info">${lista.neirong }</td>
        	 <td class="success">${lista.manyiHao }%</td>
             <td class="success">${lista.manyiJiben }%</td>
             <td class="info">${lista.manyiBijiao  }%</td>
           	 <td class="info"> ${lista.manyiBu  }%</td>
             <td class="danger">${lista.manyiHenbu }%</td>
       </tr>
	</c:forEach>
                                        
  </tbody>
  </table>
	</div>

</body>
</html>