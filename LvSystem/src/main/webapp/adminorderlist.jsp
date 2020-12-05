<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="meta description">
<title>Home</title>

<!--=== Favicon ===-->
<link rel="shortcut icon" href="assets/img/favicon.ico"
	type="image/x-icon" />
<!-- All Vendor & plugins CSS include -->
<link href="assets/css/vendor.css" rel="stylesheet">
<!-- Main Style CSS -->
<link href="assets/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="./assets/css/layui.css">
<link rel="stylesheet" href="./assets/css/view.css" />
</head>
<body>

	<main>
		<table class="layui-table" lay-skin="line" lay-size="lg" id="table">
						<thead>
							<tr>
								<th>姓名</th>
								<th>电话</th>
								<th>身份证号码</th>
								<th>酒店名称</th>
								<th>价格</th>
								<th>入住日期</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="temp" items="${list }">
								<tr>
									<td>${temp.name }</td>
									<td>${temp.tel}</td>
									<td>${temp.sfz}</td>
									<td>${temp.hotelname}</td>
									<td>${temp.money}</td>
									<td>${temp.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	</main>
</body>
</html>
