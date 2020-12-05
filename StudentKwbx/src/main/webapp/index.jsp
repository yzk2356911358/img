<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="">
<link href="./css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<h1>课外补习班管理系统</h1>
	<div class="w3ls-login box">
		<img src="images/logo.png" alt="logo_img" />
		<!-- form starts here -->
		<form action="./login" method="post">
			<div class="agile-field-txt">
				<input type="text" name="username" placeholder="账号" required="" />
			</div>
			<div class="agile-field-txt">
				<input type="password" name="password" placeholder="密码" required=""
					id="myInput" />
				<div class="agile_label">
					<select name="type">
						<option value="s">学生</option>
						<option value="t">教师</option>
						<option value="g">管理员</option>
					</select>
				</div>
			</div>
			<div class="w3ls-bot">
				<input type="submit" value="登录">
			</div>
			<h3 style="color: red;">${error }</h3>
		</form>
	</div>
</body>

</html>