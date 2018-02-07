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
		  <input type="hidden" name="ID" value="${student.ID}"/>
		  <table>
		  	<tr>
		  		<td><label for="exampleInputEmail1">姓名:</label>
		    		<input type="text" class="form-control" id="name" name="name" value="${student.name}">
		   		</td>
		  		<td> <label for="exampleInputPassword1">年龄:</label>
		   		    <input type="text" class="form-control" id="age" name="age" value="${student.age}">
		    	</td>
		  	</tr>
		  	<tr>
		  		<td>
		  		    <label for="exampleInputPassword1">性别:</label>
				    <select class="form-control" name="gender" id="gender">
				    	  <option value="${oldID}">${gender}</option>
				    	  <option value="${newID}">${newgender}</option>
				    </select>
		  		</td>
		  		<td>
		  			<label for="exampleInputPassword1">住址:</label>
		   		    <input type="text" class="form-control" id="address" name="address" value="${student.address}">
		  		</td>
		  	</tr>
		  	<tr>
		  		<td>
		  			<label for="exampleInputPassword1">出生日期:</label>
		  			<div class="input-group date form_date col-md-5" data-date="" data-date-format="" data-link-field="dtp_input2" data-link-format="yyyy-MM-dd">
		               <input id="birthday" name="birthday" class="form-control" size="16" type="text" value="<fmt:formatDate value='${student.birthday}' pattern='yyyy-MM-dd'/>" readonly>
		               <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
		         	   <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
		         	</div>
		  		</td>
		  		<td>
		  		    <label for="exampleInputPassword1">所在班级:</label>
				    <select class="form-control" name="banjiID" id="banji">
				    	<option value="${student.banji.sequenceNO}">${student.banji.name}</option>
				    	<c:forEach items="${banJis}" var="banji">
					    	<option value="${banji.sequenceNO}">${banji.name}</option>
				    	</c:forEach>
				    </select>
		  		</td>
		  	</tr>
		  	<tr>
		  		<td>
		  			<img onclick="updatePicture();" alt="" src="http://owyysts4w.bkt.clouddn.com/${student.picture}" name=""  width="150" height="130">
		  			<input id="pictureInput" value="${student.picture}" type="hidden" name="picture"/>
		  			<div class="form-group"  id="hidePicture" style="display:none">
					    <label for="exampleInputPassword1">图片:</label>
					     <img alt="" id="imgId" src="" width=100
						 height=100> <input type="hidden" name="picture"
						 id="mainImage" /> <input type="file" name="pictureFile"
						 onchange="uploadPic();"/>
					</div>
		  		</td>
		  	</tr>
		  </table>
		  <button type="button" class="btn btn-default" onclick="update();">提交</button>
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
<script>
	$('.form_date').datetimepicker({
	    language: 'zh-CN',
	    weekStart: 1,
	    todayBtn: 1,
	    autoclose: 1,
	    todayHighlight: 1,
	    startView: 2,
	    minView: 2,
	    forceParse: 0
	});
	
	function update(){
		var options = {
			url:"${pageContext.request.contextPath}/studentIndex/updateStudent.action",
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
	
	function updatePicture(){
		$("img").attr("src","");
		$("#hidePicture").remove();
		$("#hidePicture").attr("style","");
		
	}
	
	function uploadPic() {
		//定义参数
		var options = {
			url : "${pageContext.request.contextPath}/upload/uploadPic.action",
			dataType : "json",
			type : "post",
			success : function(data) {
				//七牛云上传图片
				$("#imgId").attr("src", data.filePath);
				//上传图片
				/* $("#imgId").attr("src", "/pic/" + data.fileName); */
				$("#mainImage").val(data.fileName);
			}
		};
		$("#updateForm").ajaxSubmit(options);
	}

	var myKindEditor ;
	KindEditor.ready(function(K) {
		var kingEditorParams = {
				//指定上传文件参数名称
				filePostName  : "pictureFile",
				//指定上传文件请求的url。
				uploadJson : '${pageContext.request.contextPath}/upload/pic.action',
				//上传类型，分别为image、flash、media、file
				dir : "image",
				afterBlur:function(){this.sync();}
		}
		var editor = K.editor(kingEditorParams);
		//多图片上传
		K('#picFileUpload').click(function() {
			editor.loadPlugin('multiimage', function() {
				editor.plugin.multiImageDialog({
					clickFn : function(urlList) {
						console.log(urlList);
						var div = K('#J_imageView');
						var imgArray = [];
						div.html('');
						K.each(urlList, function(i, data) {
							imgArray.push(data.url);
							alert(data.url);
							div.append('<img src="' + data.url + '" width="80" height="50">');
						});
						$("#subImages").val(imgArray.join(","));
						editor.hideDialog();
					}
				});
			});
		});
		//富文本编辑器
		myKindEditor = KindEditor.create('#updateForm[name=detail]', kingEditorParams);
	});
</script>
	
</body>
</html>