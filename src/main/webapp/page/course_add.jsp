<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/third/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css"/>
</head>
<body>
	<div style="width:400px; margin-left:50px">
		<form action="" method="post"
		  enctype="multipart/form-data" class="form form-horizontal" id="form-add">
		  <div class="form-group">
		    <label for="exampleInputEmail1">课程名称:</label>
		    <input type="text" class="form-control" id="name" name="name">
		  </div>
		   <div class="form-group">
		    <label for="exampleInputPassword1">课程类型</label>
		    <select class="form-control" name="category.sequenceNO" id="banji">
		    </select>
		  </div>
		   <div class="form-group">
		    <label for="exampleInputEmail1">总分:</label>
		    <input type="text" class="form-control" id="score" name="score">
		  </div>
		  <button type="button" class="btn btn-default" onclick="add();">提交</button>
		</form>
	</div>
<script src="${pageContext.request.contextPath}/third/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/kindeditor-all-min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/zh-CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/layer-v3.1.1/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
function add(){
	console.log($("#form-add").serialize());
	var options = {
			url:"${pageContext.request.contextPath}/courseIndex/addCourse.action",
			type:"post",
			dataType:"json",
			data:$("#form-add").serialize(),
			success:function(data){
				console.log(data);
				if(data.status==0){
					 layer.open({
						  content: data.msg
						  ,btn: ['继续添加', '返回课程页面']
						  ,yes: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/courseIndex/goAddPage.action";
						  }
						  ,btn2: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/courseIndex/findAllCourses.action";
						  }
						  ,cancel: function(){ 
						    
						  }
						}); 
	           	} else{
	           		layer.open({
						  content: data.msg
						  ,btn: ['继续添加', '返回课程页面']
						  ,yes: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/courseIndex/goAddPage.action";
						  }
						  ,btn2: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/courseIndex/findAllCourses.action";
						  }
						  ,cancel: function(){ 
						    
						  }
						}); 
	           	}
			}
		}
		$.ajax(options);
}

$(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/categoryIndex/findAddCourseType.action",
		contentType:"application/json",
		type:"POST",
		dataType:"json",
		success: function(data) {
			var html="<option>-请选择-</option>";
			for(var i=0;i<data.length;i++){
				html +="<option value='"+data[i].sequenceNO+"'>"+data[i].title+"</option>";
			}
			$("#banji").html(html);
        }
	});
});
</script>
</body>
</html>