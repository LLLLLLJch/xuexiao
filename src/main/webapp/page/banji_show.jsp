<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/third/css/bootstrap.css"/>
</head>
<body>
	<div style="width:400px; margin-left:50px">
	<div class="form-group">
	  <input type="hidden" name="ID" value="${student.ID}"/>
	  <table>
	  	<tr>
	  		<td><label for="exampleInputEmail1">班级名称:</label>
	    		<input readonly="readonly" type="text" class="form-control" value="${banJi.name}">
	   		</td>
	  		<td> <label for="exampleInputPassword1">总人数:</label>
	   		    <input readonly="readonly" type="text" class="form-control" value="${StudentNumber}">
	    	</td>
	  	</tr>
	  	<tr>
	  		<td>
	  		    <label for="exampleInputPassword1">班主任:</label>
	  		    <input readonly="readonly" type="text" class="form-control" value="${teacher.name}">
	  		</td>
	  	</tr>
	  </table>
	</div>
	</div>
</body>
</html>