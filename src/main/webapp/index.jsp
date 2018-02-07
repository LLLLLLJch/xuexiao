<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>管理系统</title>

<meta name="keywords" content="">
<meta name="description" content="">

<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow: hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
								class="clear"> <span class="block m-t-xs"
									style="font-size: 20px;"> <i class="fa fa-area-chart"></i>
										<strong class="font-bold">hAdmin</strong>
								</span>
							</span>
							</a>
						</div>
						<div class="logo-element">hAdmin</div>
					</li>
					<li><a class="J_menuItem"
						href="${pageContext.request.contextPath}/Index/goIndex.action">
							<i class="fa fa-home"></i> <span class="nav-label">主页</span>
					</a></li>
					<li><a href="#"> <i class="fa fa fa-bar-chart-o"></i> <span
							class="nav-label">学生管理</span> <span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/studentIndex/findAllStudents.action">学生信息</a>
							</li>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/studentIndex/goAddPage.action">添加学生</a>
							</li>
						</ul></li>
					<li><a href="mailbox.html"><i class="fa fa-envelope"></i>
							<span class="nav-label">班级管理 </span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/banjiIndex/findAllBanJi.action">班级信息</a>
							</li>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/banjiIndex/goAddPage.action">添加班级</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="fa fa-edit"></i> <span
							class="nav-label">教师管理</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/teacherIndex/findAllTeacher.action">教师信息</a>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/teacherIndex/goAddPage.action">添加教师</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="fa fa-desktop"></i> <span
							class="nav-label">课程管理</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/courseIndex/findAllCourses.action">课程信息</a>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/courseIndex/goAddPage.action">添加课程</a>
							</li>
						</ul></li>
					<li><a href="#"><i class="fa fa-flask"></i> <span
							class="nav-label">请假管理</span><span id="askLeaveNumber" class="label label-warning pull-right"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/askLeaveIndex/goAddPage.action">请假申请</a>
							</li>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath}/askLeaveIndex/findMineAskLeave.action?ID=${teacher.sequenceNO}">请假记录</a>
							</li>
							<li><a class="J_menuItem" href="${pageContext.request.contextPath}/askLeaveIndex/findNoDeal.action?ID=${teacher.sequenceNO}">请假处理<span id="askLeaveNum" class="label label-warning pull-right"></span></a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-table"></i> <span
							class="nav-label">公告管理</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<c:if test="${num == 1}">
								<li><a class="J_menuItem" href="${pageContext.request.contextPath}/noticeIndex/findStudentNotice.action">公告信息</a></li>
							</c:if>
							<c:if test="${num == 2}">
								<li><a class="J_menuItem" href="${pageContext.request.contextPath}/noticeIndex/findTeacherNotice.action">公告信息</a></li>
							</c:if>
							<li><a class="J_menuItem" href="${pageContext.request.contextPath}/noticeIndex/goAddPage.action">发布公告</a>
							</li>
						</ul></li>
					<li class="line dk"></li>
					<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
						<span class="ng-scope">分类</span>
					</li>
					<li><a href="#"><i class="fa fa-picture-o"></i> <span
							class="nav-label">相册</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="basic_gallery.html">基本图库</a>
							</li>
							<li><a class="J_menuItem" href="carousel.html">图片切换</a></li>
							<li><a class="J_menuItem" href="blueimp.html">Blueimp相册</a>
							</li>
						</ul></li>
					<li><a class="J_menuItem" href="css_animation.html"><i
							class="fa fa-magic"></i> <span class="nav-label">CSS动画</span></a></li>
					<li><a href="#"><i class="fa fa-cutlery"></i> <span
							class="nav-label">工具 </span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="form_builder.html">表单构建器</a>
							</li>
						</ul></li>

				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-info "
							href="#"><i class="fa fa-bars"></i> </a>
						<form role="search" class="navbar-form-custom" method="post"
							action="search_results.html">
							<div class="form-group">
								<input type="text" placeholder="请输入您需要查找的内容 …"
									class="form-control" name="top-search" id="top-search">
							</div>
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i class="fa fa-envelope"></i>
								<span class="label label-warning">16</span>
						</a>
							<ul class="dropdown-menu dropdown-messages">
								<li class="m-t-xs">
									<div class="dropdown-messages-box">
										<a href="profile.html" class="pull-left"> <img alt="image"
											class="img-circle" src="img/a7.jpg">
										</a>
										<div class="media-body">
											<small class="pull-right">46小时前</small> <strong>小四</strong>
											是不是只有我死了,你们才不骂爵迹 <br> <small class="text-muted">3天前
												2014.11.8</small>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="dropdown-messages-box">
										<a href="profile.html" class="pull-left"> <img alt="image"
											class="img-circle" src="img/a4.jpg">
										</a>
										<div class="media-body ">
											<small class="pull-right text-navy">25小时前</small> <strong>二愣子</strong>
											呵呵 <br> <small class="text-muted">昨天</small>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="text-center link-block">
										<a class="J_menuItem" href="mailbox.html"> <i
											class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
										</a>
									</div>
								</li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i class="fa fa-bell"></i> <span
								class="label label-primary">8</span>
						</a>
							<ul class="dropdown-menu dropdown-alerts">
								<li><a href="mailbox.html">
										<div>
											<i class="fa fa-envelope fa-fw"></i> 您有16条未读消息 <span
												class="pull-right text-muted small">4分钟前</span>
										</div>
								</a></li>
								<li class="divider"></li>
								<li><a href="profile.html">
										<div>
											<i class="fa fa-qq fa-fw"></i> 3条新回复 <span
												class="pull-right text-muted small">12分钟钱</span>
										</div>
								</a></li>
								<li class="divider"></li>
								<li>
									<div class="text-center link-block">
										<a class="J_menuItem" href="notifications.html"> <strong>查看所有
										</strong> <i class="fa fa-angle-right"></i>
										</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</nav>
			</div>
			<div class="row J_mainContent" id="content-main">
				<iframe id="J_iframe" width="100%" height="100%"
					src="${pageContext.request.contextPath}/Index/goIndex.action"
					frameborder="0" data-id="index_v1.html" seamless></iframe>
			</div>
		</div>
		<!--右侧部分结束-->
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="js/hAdmin.js?v=4.1.0"></script>
	<script type="text/javascript" src="js/index.js"></script>

	<!-- 第三方插件 -->
	<script src="js/plugins/pace/pace.min.js"></script>
	<script type="text/javascript">
		$(function(){
			if("${teacher.category.ID}" == "6" || "${teacher.category.ID}" == "20" || "${teacher.category.ID}" == "21"){
				$.post(
					"${pageContext.request.contextPath}/teacherIndex/findAskLeaveByTeacherID.action",
		            {"ID":'${teacher.sequenceNO}'},
		            function(data) {
		            	$("#askLeaveNumber").html(data.length);
		            	$("#askLeaveNum").html(data.length);
		            },
		            "json"
			     );
			}
		});
	</script>

</body>

</html>
