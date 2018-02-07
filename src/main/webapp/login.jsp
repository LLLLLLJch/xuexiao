<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script src="${pageContext.request.contextPath}/third/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-12">
                <form method="post" action="index.html">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md" onclick="studentLogin">学生登录</p>&nbsp;&nbsp;&nbsp;&nbsp;<p class="m-t-md" onclick="teacherLogin">教师登录</p>
                    <input type="text" class="form-control uname" placeholder="用户名" name="name"/>
                    <input type="password" class="form-control pword m-b" placeholder="密码" name="password"/>
                    <a href="">忘记密码了？</a>
                    <input type="submit" class="btn btn-success btn-block" value="登录">
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
