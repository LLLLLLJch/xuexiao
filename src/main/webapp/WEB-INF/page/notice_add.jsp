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


<script>
	
</script>
</head>
<body>
	<div style="width:400px; margin-left:50px">
		<form action="" method="post"
		  enctype="multipart/form-data" class="form form-horizontal" id="form-add">
		  <div class="form-group">
		    <label for="exampleInputEmail1">标题:</label>
		    <input type="text" class="form-control" id="title" name="title">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">内容:</label>
		    <textarea class="form-control" name="content" rows="3"></textarea>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">图片:</label>
		     <img alt="" id="imgId" src="" width=100
			 height=100> <input type="hidden" name="picture"
			 id="mainImage" /> <input type="file" name="pictureFile"
			 onchange="uploadPic();" />
		  </div>
		   <div class="form-group">
		    <label for="exampleInputPassword1">发布范围</label>
		    <select class="form-control" name="level">
		    	<option value="all">所有人可见</option>
		    	<option value="teacher">老师可见</option>
		    </select>
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
	$("#form-add").ajaxSubmit(options);
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
	myKindEditor = KindEditor.create('#form-add[name=detail]', kingEditorParams);
});

function add(){
	console.log($("#form-add").serialize());
	var options = {
			url:"${pageContext.request.contextPath}/noticeIndex/addNotice.action",
			type:"post",
			dataType:"json",
			data:$("#form-add").serialize(),
			success:function(data){
				console.log(data);
				if(data.status==0){
					 layer.open({
						  content: data.msg
						  ,btn: ['继续发布', '返回公告页面']
						  ,yes: function(index, layero){
							  if('${num ==1}'){
								  window.location.href="${pageContext.request.contextPath}/noticeIndex/findStudentNotice.action";
							  }
							  if('${num ==2}'){
								  window.location.href="${pageContext.request.contextPath}/noticeIndex/findTeacherNotice.action";
							  }
						  }
						  ,btn2: function(index, layero){
							  if('${num ==1}'){
								  window.location.href="${pageContext.request.contextPath}/noticeIndex/findStudentNotice.action";
							  }
							  if('${num ==2}'){
								  window.location.href="${pageContext.request.contextPath}/noticeIndex/findTeacherNotice.action";
							  }
						  }
						  ,cancel: function(){ 
						    
						  }
						}); 
	           	} else{
	           		layer.open({
						  content: data.msg
						  ,btn: ['继续添加', '返回学生页面']
						  ,yes: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/studentIndex/goAddPage.action";
						  }
						  ,btn2: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/studentIndex/findAllStudents.action";
						  }
						  ,cancel: function(){ 
						    
						  }
						}); 
	           	}
			}
		}
		$.ajax(options);
}
</script>
</body>
</html>