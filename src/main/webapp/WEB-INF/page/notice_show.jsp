<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 100%; height: 100%; background-image: url(http://owyysts4w.bkt.clouddn.com/${notice.picture})">
		<div style="margin-top: 5px;margin-left: 200px">
			<h2>${notice.title}</h2>
		</div>
		<div>
			<h4>${notice.content}</h4>
		</div>
	</div>
</body>
</html>