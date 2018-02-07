<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	function goDeleteStudent(ID){
		layer.alert('',{
			icon:2,title:'删除确认',content:'您确定要删除这条记录吗？',closeBtn:1},function(index){
				$.post(
	            "${pageContext.request.contextPath}/banjiIndex/deleteBanji.action",
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
  	      content: "${pageContext.request.contextPath}/banjiIndex/findUpdateBanji.action?ID="+ID
  	    });
	}
	
	function selectId(){
		$("input[name = selectedIds]").prop("checked",$("#selectedAll").is(":checked"));
	}
	
	function deleteAll(){
	    layer.alert('',{
			icon:2,title:'删除确认',content:'您确定要删除吗？',closeBtn:1},function(index){
				$.post(
	            "${pageContext.request.contextPath}/banjiIndex/deleteAll.action",
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
		window.location.href="${pageContext.request.contextPath}/banjiIndex/findAllBanJi.action";
	}
	
	function showBanji(ID){
		layer.open({
	  	      type: 2,
	  	      title: '修改面板',
	  	      shadeClose: true,
	  	      shade: false,
	  	      maxmin: true, //开启最大化最小化按钮
	  	      area: ['893px', '500px'],
	  	      content: "${pageContext.request.contextPath}/banjiIndex/showBanji.action?ID="+ID
	  	    });
	}
</script>
</head>
<body>
	<form class="form-inline" action="${pageContext.request.contextPath}/banjiIndex/findBanjiByCondition.action" method="post" id="searchForm">
	  <input type="hidden" name="pageIndexStr" id="pageIndex" />
	  <label for="exampleInputName2">班级名称</label>
	    <input type="text" class="form-control" id="name" name="name" value="${name}">
	  </div>
	  <button type="button" class="btn btn-default" onclick="removeAll();">清空</button> &nbsp;&nbsp;
	  <button type="submit" class="btn btn-default">搜索</button>
	</form>
	<form id="mainForm" action="" method="post">
	<input type="button" value="批量删除" onclick="deleteAll();" class="btn btn-default"/>
		<table class="table table-bordered">
			<tr>
				<td>
					<input type="checkbox" id="selectedAll" onclick="selectId();">
				</td>
				<td>班级编号</td>
				<td>班级名称</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${pageBean.list}" var="banji">
			<tr>
				<td>
					<input type="checkbox" name="selectedIds" value="${banji.ID}">
				</td>
				<td>${banji.ID}</td>
				<td><a href="javascript:showBanji('${banji.ID}');">${banji.name}</a></td>
				<td><a href="javascript:update('${banji.ID}')">修改</a></td>
				<td><a href="javascript:goDeleteStudent('${banji.ID}');">删除</a></td>
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
</body>
</html>