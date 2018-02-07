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
		<form method="post"
		  enctype="multipart/form-data" class="form form-horizontal" id="updateForm">
		  <div class="form-group">
		  <input type="hidden" name="ID" value="${banji.ID}"/>
		  <table>
		  	<tr>
		  		<td>
		  			<label for="exampleInputEmail1">班级名称:</label>
		    		<input type="text" class="form-control" id="name" name="name" value="${banji.name}">
		   		</td>
		   		<td>
		  		    <label for="exampleInputPassword1">班主任:</label>
				    <select class="form-control" name="teachername" id="teacherID">
					    <option value="${teacher.ID}">${teacher.name}</option>
				    	<c:forEach items="${teachers}" var="teach">
					    	<option value="${teach.ID}">${teach.name}</option>
				    	</c:forEach>
				    </select>
		  		</td>
		  	</tr>
		  	<tr>
		  		<td>
				  	<button type="button" class="btn btn-default" onclick="update();">提交</button>
		  		</td>
		  	</tr>
		  </table>
		</form>
	</div>
	
<script src="${pageContext.request.contextPath}/third/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/third/layer-v3.1.1/layer/layer.js" type="text/javascript"></script>
<script>
	function update(){
		var options = {
			url:"${pageContext.request.contextPath}/banjiIndex/updateBanji.action",
			type:"post",
			dataType:"json",
			data:$("#updateForm").serialize(),
			success:function(data){
				if(data.status==0){
					layer.alert(data.msg, {  
                        title: "修改操作",  
                        btn: ['确定']  
                    },  
                    function (index, item) { 
                    	layer.close(index); 
                        location.reload(); 
                        window.parent.location.reload();
                    });  
	           	} else{
	           		layer.alert(data.msg, {  
                        title: "修改操作",  
                        btn: ['确定']  
                    },  
                    function (index, item) { 
                    	layer.close(index);
                        location.reload();  
                        window.parent.location.reload();
                    });  
	           	}
			}
		}
		$.ajax(options);
	}
</script>
	
</body>
</html>