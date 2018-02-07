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
	  <input type="hidden" name="ID" value="${student.ID}"/>
	  <table>
	  	<tr>
	  		<td><label for="exampleInputEmail1">姓名:</label>
	    		<input readonly="readonly" type="text" class="form-control" value="${student.name}">
	   		</td>
	  		<td> <label for="exampleInputPassword1">年龄:</label>
	   		    <input readonly="readonly" type="text" class="form-control" value="${student.age}">
	    	</td>
	  	</tr>
	  	<tr>
	  		<td>
	  		    <label for="exampleInputPassword1">性别:</label>
	  		    <input readonly="readonly" type="text" class="form-control" value="${student.gender}">
	  		</td>
	  		<td>
	  			<label for="exampleInputPassword1">住址:</label>
	   		    <input readonly="readonly" type="text" class="form-control" value="${student.address}">
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>
	  			<label for="exampleInputPassword1">出生日期:</label>
	  			<input readonly="readonly" type="text" class="form-control" value="<fmt:formatDate value='${student.birthday}' pattern='yyyy-MM-dd'/>">
	  		</td>
	  		<td>
	  		    <label for="exampleInputPassword1">所在班级:</label>
			    <input readonly="readonly" type="text" class="form-control" value="${student.banji.name}">
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>
	  			<img src="http://owyysts4w.bkt.clouddn.com/${student.picture}" width="150" height="130">
	  		</td>
	  	</tr>
	  </table>
	</div>
	</div>
</body>
</html>