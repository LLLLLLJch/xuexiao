<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>请假信息</title>
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
		  	<label for="dtp_input2" class="col-md-2 control-label">开始日期</label>
		    <div class="input-group date form_date col-md-5" data-date="" data-date-format="" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
               <input id="startTime" name="startTime" class="form-control" size="16" type="text" value="" readonly>
               <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
         	   <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
         	</div>
		  </div>
		   <div class="form-group">
		  	<label for="dtp_input2" class="col-md-2 control-label">截至日期</label>
		    <div class="input-group date form_date col-md-5" data-date="" data-date-format="" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
               <input id="endTime" name="endTime" class="form-control" size="16" type="text" value="" readonly>
               <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
         	   <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
         	</div>
		  </div>
		   <div class="form-group">
		    <label for="exampleInputEmail1">内容:</label>
		    <textarea class="form-control" name="content" rows="3"></textarea>
		  </div>
		   <div class="form-group">
		    <label for="exampleInputPassword1">请假类型:</label>
		    <select class="form-control" name="category.ID" id="categoryID">
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

$(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/categoryIndex/findAskLeaveType.action",
		contentType:"application/json",
		type:"POST",
		dataType:"json",
		success: function(data) {
			var html="<option>-请选择-</option>";
			for(var i=0;i<data.length;i++){
				html +="<option value='"+data[i].sequenceNO+"'>"+data[i].title+"</option>";
			}
			$("#categoryID").html(html);
        }
	});
});

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
			url:"${pageContext.request.contextPath}/askLeaveIndex/addAskLeave.action",
			type:"post",
			dataType:"json",
			data:$("#form-add").serialize(),
			success:function(data){
				console.log(data);
				if(data.status==0){
					 layer.open({
						  content: data.msg
						  ,btn: ['继续申请']
						  ,yes: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/askLeaveIndex/goAddPage.action";
						  },cancel: function(){ 
						    
						  }
						}); 
	           	} else{
	           		layer.open({
						  content: data.msg
						  ,btn: ['继续申请']
						  ,yes: function(index, layero){
							  window.location.href="${pageContext.request.contextPath}/askLeaveIndex/goAddPage.action";
						  },cancel: function(){ 
						    
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