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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css"/>
<script src="${pageContext.request.contextPath}/third/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/layer-v3.1.1/layer/layer.js" type="text/javascript"></script>
<script>
	function goPage(pageIndex) {
		$('#pageIndex').val(pageIndex);
		$('#searchForm').submit();
	}
	
	function goDeleteStudent(ID){
		layer.alert('',{
			icon:2,title:'删除确认',content:'您确定要删除这条记录吗？',closeBtn:1},function(index){
				$.post(
	            "${pageContext.request.contextPath}/noticeIndex/deleteNotice.action",
	            {"ID":ID},
	            function(data) {
	            	if(data.status == 0){
	            		layer.alert(data.msg, {  
	                        title: "删除操作",  
	                        btn: ['确定']  
	                    },  
	                    function (index, item) {  
	                        location.reload();  
	                    });  
	            	}else{
	            		layer.alert(data.msg, {  
	                        title: "删除操作",  
	                        btn: ['确定']  
	                    },  
	                    function (index, item) {  
	                        location.reload();  
	                    });  
	            	}
	            },
	            "json"
	        );
			});
	}
	
	function selectId(){
		$("input[name = selectedIds]").prop("checked",$("#selectedAll").is(":checked"));
	}
	
	function deleteAll(){
	    layer.alert('',{
			icon:2,title:'删除确认',content:'您确定要删除吗？',closeBtn:1},function(index){
				$.post(
	            "${pageContext.request.contextPath}/noticeIndex/deleteAll.action",
	            $("#mainForm").serialize(),
	            function(data) {
	            	if(data.status == 0){
	            		layer.alert(data.msg, {  
	                        title: "删除操作",  
	                        btn: ['确定']  
	                    },  
	                    function (index, item) {  
	                        location.reload();  
	                    });  
	            	}else{
	            		layer.alert(data.msg, {  
	                        title: "删除操作",  
	                        btn: ['确定']  
	                    },  
	                    function (index, item) {  
	                        location.reload();  
	                    });  
	            	}
	            },
	            "json"
	        );
		});
	}
	
	function removeAll(){
		$("#searchForm")[0].reset(); 
		if('${num}' == '1'){
			window.location.href="${pageContext.request.contextPath}/noticeIndex/findStudentNotice.action";
		}else{
			window.location.href="${pageContext.request.contextPath}/noticeIndex/findTeacherNotice.action";
		}
	}
	
	function showStudent(ID){
		layer.open({
	  	      type: 2,
	  	      title: '修改面板',
	  	      shadeClose: true,
	  	      shade: false,
	  	      maxmin: true, //开启最大化最小化按钮
	  	      area: ['893px', '500px'],
	  	      content: "${pageContext.request.contextPath}/noticeIndex/showNotice.action?ID="+ID
	  	    });
	}
</script>
</head>
<body>
	<form class="form-inline" action="${pageContext.request.contextPath}/noticeIndex/findNoticeByCondition.action" method="post" id="searchForm">
	  <div>
		  <input type="hidden" name="pageIndexStr" id="pageIndex" />
	                    标题<input type="text" class="form-control" id="title" name="title" value="${findNoticeByCondition.title}">
	  </div>
	  &nbsp;&nbsp;&nbsp;&nbsp;
	  <div>
	              起止日期<input type="text" class="form-control" value="<fmt:formatDate value='${findNoticeByCondition.startTime}' pattern='yyyy-MM-dd'/>" name="startTime" id="datetimepicker1">
		 --
		  <input type="text" class="form-control" value="<fmt:formatDate value='${findNoticeByCondition.endTime}' pattern='yyyy-MM-dd'/>" name="endTime" id="datetimepicker2">
	  </div>
	  <button type="button" class="btn btn-default" onclick="removeAll();">清空</button> &nbsp;&nbsp;
	  <button type="submit" class="btn btn-default">搜索</button>
	</form>
	<form id="mainForm" action="" method="post">
	<c:if test="${num == 2}">
		<input type="button" value="批量删除" onclick="deleteAll();" class="btn btn-default"/>
	</c:if>
		<table class="table table-bordered">
			<tr>
				<td>
				</td>
				<td>标题</td>
				<td>内容</td>
				<td>图片</td>
				<td>发布日期</td>
				<td>发布人</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="notice">
			<tr>
				<c:if test="${notice.publisher.ID == teacher.ID}">
					<td>
						<input type="checkbox" name="selectedIds" value="${notice.ID}">
					</td>
				</c:if>
				<c:if test="${notice.publisher.ID != teacher.ID}">
					<td>
						<input type="checkbox" name="selectedIds" disabled="disabled" value="${notice.ID}">
					</td>
				</c:if>
				<td><a href="javascript:showStudent('${notice.ID}');">${notice.title}</a></td>
				<td>${notice.content}</td>
				<td><img src="http://owyysts4w.bkt.clouddn.com/${notice.picture}" width="100" height="80"></td>
				<td><fmt:formatDate value='${notice.postedDate}' pattern='yyyy-MM-dd'/></td>
				<td>${notice.publisher.name}</td>
				<c:if test="${num == 2}">
					<c:if test="${notice.publisher.ID == teacher.ID}">
						<td><a href="javascript:goDeleteStudent('${notice.ID}');">删除</a></td>
					</c:if>
					<c:if test="${notice.publisher.ID != teacher.ID}">
						<td>删除</td>
					</c:if>
				</c:if>
				<c:if test="${num == 1}">
					<td>删除</td>
				</c:if>
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
					<li><a href="javascript:goPage('${page}')">${page}</a></li>
				</c:if>
				<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
				<c:if test="${pageBean.pageIndex==page}">
					<li class="active"><a href="javascript:goPage('${page}')">${page}</a></li>
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
	<script type="text/javascript">
	$("#datetimepicker1").datetimepicker({
		  minView: "month",//设置只显示到月份
		  format : "yyyy-mm-dd",//日期格式
		  autoclose:true,//选中关闭
		  todayBtn: true//今日按钮
		});
	$("#datetimepicker2").datetimepicker({
		  minView: "month",//设置只显示到月份
		  format : "yyyy-mm-dd",//日期格式
		  autoclose:true,//选中关闭
		  todayBtn: true//今日按钮
		});
	</script>
</body>
</html>