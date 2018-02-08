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
	            "${pageContext.request.contextPath}/studentIndex/deleteStudent.action",
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
	
	function update(ID){
		layer.open({
  	      type: 2,
  	      title: '修改面板',
  	      shadeClose: true,
  	      shade: false,
  	      maxmin: true, //开启最大化最小化按钮
  	      area: ['893px', '500px'],
  	      content: "${pageContext.request.contextPath}/studentIndex/findUpdateStudent.action?ID="+ID
  	    });
	}
	
	function selectId(){
		$("input[name = selectedIds]").prop("checked",$("#selectedAll").is(":checked"));
	}
	
	function deleteAll(){
	    layer.alert('',{
			icon:2,title:'删除确认',content:'您确定要删除吗？',closeBtn:1},function(index){
				$.post(
	            "${pageContext.request.contextPath}/studentIndex/deleteAll.action",
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
	
	$(function(){
		if('${findStudentByCondition.gender}' == ""){
			$("#gender").val(0);
		}else{
			$("#gender").val('${findStudentByCondition.gender}');
		}
	}); 
	
	function removeAll(){
		$("#searchForm")[0].reset(); 
		window.location.href="${pageContext.request.contextPath}/studentIndex/findAllStudents.action";
	}
	
	function showStudent(ID){
		layer.open({
	  	      type: 2,
	  	      title: '修改面板',
	  	      shadeClose: true,
	  	      shade: false,
	  	      maxmin: true, //开启最大化最小化按钮
	  	      area: ['893px', '500px'],
	  	      content: "${pageContext.request.contextPath}/studentIndex/showStudent.action?ID="+ID
	  	    });
	}
	
	$(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/categoryIndex/findAllAdviceType.action",
			contentType:"application/json",
			type:"POST",
			dataType:"json",
			success: function(data) {
				var html="<option>-请选择-</option>";
				for(var i=0;i<data.length;i++){
					html +="<option value='"+data[i].sequenceNO+"'>"+data[i].title+"</option>";
				}
				$("#type").html(html);
	        }
		});
	});
</script>
</head>
<body>
	<form class="form-inline" action="${pageContext.request.contextPath}/adviceIndex/findAdviceByCondition.action" method="post" id="searchForm">
	  <input type="hidden" name="pageIndexStr" id="pageIndex" />
	  <div class="form-group">
	 	<label for="exampleInputName2">标题</label>
	    <input type="text" class="form-control" id="title" name="title" value="${findStudentByCondition.name}">
	  </div>
	  <div class="form-group">
	              起止日期<input type="text" class="form-control" value="<fmt:formatDate value='${findNoticeByCondition.startTime}' pattern='yyyy-MM-dd'/>" name="startTime" id="datetimepicker1">
		 --
		  <input type="text" class="form-control" value="<fmt:formatDate value='${findNoticeByCondition.endTime}' pattern='yyyy-MM-dd'/>" name="endTime" id="datetimepicker2">
	  </div>
	    <div class="form-group">
		    <label for="exampleInputPassword1">建议类型:</label>
		    <select class="form-control" name="category_id" id="type">
		    </select>
		  </div>
	  <button type="button" class="btn btn-default" onclick="removeAll();">清空</button> &nbsp;&nbsp;
	  <button type="submit" class="btn btn-default">搜索</button>
	</form>
	<form id="mainForm" action="" method="post">
		<table class="table table-bordered">
			<tr>
				<td>标题</td>
				<td>内容</td>
				<td>发布日期</td>
				<td>图片</td>
				<td>分类</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="advice">
			<tr>
				<td><a href="javascript:showStudent('${advice.ID}');">${advice.title}</a></td>
				<td>${advice.content}</td>
				<td><fmt:formatDate value='${advice.postedDate}' pattern='yyyy-MM-dd'/></td>
				<td><img src="http://owyysts4w.bkt.clouddn.com/${advice.picture}" width="100" height="80"></td>
				<td>${advice.category.title}</td>
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