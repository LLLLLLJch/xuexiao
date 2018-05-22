<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	a:link    {color:black;}
	a:visited {color:blue;}
	a:hover   {color:red;}
	a:active  {color:yellow;}
	.main{
     text-align: center; /*让div内部文字居中*/
    background-color: #fff;
    border-radius: 20px;
    width: 504px;
    height: 602px;
    margin-top:100px;
    margin-left:auto;
    margin-right:auto;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/third/css/bootstrap.css"/>
<script src="${pageContext.request.contextPath}/third/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/layer-v3.1.1/layer/layer.js" type="text/javascript"></script>
</head>
<body>
	<form class="form-inline" action="${pageContext.request.contextPath}/createTableIndex/CreateTableSQL.action" method="post" id="searchForm">
		<div class="main">
			TableName<input type="text" value="${tableName}" name="tableName"/>
			<div style="width:250px;height:300px;float: left;">
				文本
				<textarea style="width: 200px;height: 200px;" rows="" cols="" name="table">${table}</textarea>
			</div> 
			<div style="width:250px;height:300px;float: left;">
				SQL
				<textarea style="width: 200px;height: 200px;" rows="" cols="">${SQL}</textarea>
			</div> 
			<input type="submit" value="提交"/>
		</div>
	</form>
</body>
</html>