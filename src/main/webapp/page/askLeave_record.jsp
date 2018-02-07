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
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/third/css/bootstrap.css"/>
<script src="${pageContext.request.contextPath}/third/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/layer-v3.1.1/layer/layer.js" type="text/javascript"></script>
<script>
	function goPage(pageIndex) {
		$('#pageIndex').val(pageIndex);
		$('#searchForm').submit();
	}
	
	$(function(){
		if('${findStudentByCondition.gender}' == ""){
			$("#gender").val(0);
		}else{
			$("#gender").val('${findStudentByCondition.gender}');
		}
	}); 
	
	function removeAll(){
		$("#searchForm")[0].reset(); 
		window.location.href="${pageContext.request.contextPath}/banjiIndex/findAllBanJi.action";
	}
	
</script>
</head>
<body>
	<form id="mainForm" action="" method="post">
		<table class="table table-bordered">
			<tr>
				<td>申请人</td>
				<td>类型</td>
				<td>内容</td>
				<td>状态</td>
				<td>申请时间</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>结果</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="askLeave">
			<tr>
				<td>${askLeave.releasePeople}</td>
				<td>
					<c:if test="${askLeave.type == 14}">病假</c:if>
					<c:if test="${askLeave.type == 15}">事假</c:if>
					<c:if test="${askLeave.type == 16}">婚假</c:if>
					<c:if test="${askLeave.type == 17}">丧假</c:if>
					<c:if test="${askLeave.type == 18}">产假</c:if>
					<c:if test="${askLeave.type == 19}">年休假</c:if>
				</td>
				<td>${askLeave.content}</td>
				<td>
					<c:if test="${askLeave.status == 11}">待处理</c:if>
					<c:if test="${askLeave.status == 12}">已处理</c:if>
				</td>
				<td><fmt:formatDate value='${askLeave.postedDate}' pattern='yyyy-MM-dd'/></td>
				<td><fmt:formatDate value='${askLeave.startTime}' pattern='yyyy-MM-dd'/></td>
				<td><fmt:formatDate value='${askLeave.endTime}' pattern='yyyy-MM-dd'/></td>
				<td>
					<c:if test="${askLeave.dealResult == 24}">同意</c:if>
					<c:if test="${askLeave.dealResult == 25}">拒绝</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
	<nav aria-label="Page navigation" style="float:right;">
		<ul class="pagination">
			<c:if test="${pageBean.pageIndex==1}">
				<li class="disabled"><a href="javascript:void(0);"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>
			<c:if test="${pageBean.pageIndex!=1}">
				<li><a href="javascript:goPage(${pageBean.pageIndex-1})"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>
			<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
				<c:if test="${pageBean.pageIndex!=page}">
					<li><a href="${pageContext.request.contextPath}/askLeaveIndex/findMineAskLeave.action?pageIndexStr=${page}&&ID=${teacher.sequenceNO}">${page}</a></li>
				</c:if>
				<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
				<c:if test="${pageBean.pageIndex==page}">
					<li class="active"><a href="${pageContext.request.contextPath}/askLeaveIndex/findMineAskLeave.action?pageIndexStr=${page}&&ID=${teacher.sequenceNO}">${page}</a></li>
				</c:if>
			</c:forEach>

			<c:if test="${pageBean.pageIndex==pageBean.totalPage}">
				<li class="disabled"><a href="javascript:void(0);"
					aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
			<c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
				<li><a href="javascript:goPage(${pageBean.pageIndex+1})"
					aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
		</ul>
	</nav>
</body>
</html>