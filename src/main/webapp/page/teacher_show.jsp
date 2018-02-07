<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/third/css/bootstrap.css"/>
</head>
<body>
	<div style="width:400px; margin-left:50px">
	<div class="form-group">
	  <input type="hidden" name="ID" value="${teacher.ID}"/>
	  <table>
	  	<tr>
	  		<td><label for="exampleInputEmail1">姓名:</label>
	    		<input readonly="readonly" type="text" class="form-control" value="${teacher.name}">
	   		</td>
	  		<td> <label for="exampleInputPassword1">年龄:</label>
	   		    <input readonly="readonly" type="text" class="form-control" value="${teacher.age}">
	    	</td>
	  	</tr>
	  	<tr>
	  		<td>
	  		    <label for="exampleInputPassword1">性别:</label>
	  		    <c:if test="${teacher.gender == 2}">
		  		    <input readonly="readonly" type="text" class="form-control" value="男">
	  		    </c:if>
	  		    <c:if test="${teacher.gender == 3}">
		  		    <input readonly="readonly" type="text" class="form-control" value="女">
	  		    </c:if>
	  		</td>
	  		<td>
	  			<label for="exampleInputPassword1">住址:</label>
	   		    <input readonly="readonly" type="text" class="form-control" value="${teacher.address}">
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>
	  			<label for="exampleInputPassword1">出生日期:</label>
	  			<input readonly="readonly" type="text" class="form-control" value="<fmt:formatDate value='${teacher.birthday}' pattern='yyyy-MM-dd'/>">
	  		</td>
	  		<td>
	  		    <label for="exampleInputPassword1">所教课程:</label>
			    <input readonly="readonly" type="text" class="form-control" value="${teacher.course.name}">
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>
	  		    <label for="exampleInputPassword1">职位:</label>
			    <input readonly="readonly" type="text" class="form-control" value="${teacher.category.title}">
	  		</td>
	  		<td>
	  			<img src="http://owyysts4w.bkt.clouddn.com/${teacher.picture}" width="150" height="130">
	  		</td>
	  	</tr>
	  </table>
	</div>
	</div>
</body>
</html>