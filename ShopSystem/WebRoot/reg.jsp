<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>后台登录-X-admin2.2</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>

</head>
<body class="login-bg">

	<div class="login layui-anim layui-anim-up">
		<div class="message">商品管理系统1.0-注册</div>
		<div id="darkbannerwrap"></div>

		<form method="post" class="layui-form" action="./RegServlet">
			<input name="username" placeholder="用户名" type="text"
				class="layui-input">
			<hr class="hr15">
			<input name="password" placeholder="密码" type="password"
				class="layui-input">
			<hr class="hr15">
			<input name="gender" placeholder="性别" type="text"
				class="layui-input">
			<hr class="hr15">
			<input name="tel" placeholder="手机" type="text"
				class="layui-input">
			<hr class="hr15">
			<input name="email" placeholder="邮箱" type="text"
				class="layui-input">
			<hr class="hr15">
			<input name="addres" placeholder="地址" type="text"
				class="layui-input">
			<hr class="hr15">
			<input value="注册" style="width: 100%;" type="submit">
			<hr class="hr20">
			<h3 style="color: red;">${error }</h3>
			<a style="font-size: 13px;" href="./login.jsp">登录</a> 
		</form>
	</div>
</body>
</html>