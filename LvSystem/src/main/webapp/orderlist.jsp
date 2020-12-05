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

	<!-- Start Header Area -->
	<header class="header-area">
		<!-- main header start -->
		<div class="main-header d-none d-lg-block">
			<!-- header top start -->
			<div class="header-top bdr-bottom">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-lg-6">
							<div class="welcome-message">
								<p>欢迎来到旅游网站</p>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- header top end -->

			<!-- header middle area start -->
			<div class="header-main-area sticky">
				<div class="container">
					<div class="row align-items-center position-relative">
						<!-- start logo area -->
						<div class="col-lg-3">
							<div class="logo">
								<a href="hotelindex"> <img src="assets/img/logo/logo.png"
									alt="">
								</a>
							</div>
						</div>
						<!-- start logo area -->

						<!-- main menu area start -->
						<div class="col-lg-6 position-static">
							<div class="main-menu-area">
								<div class="main-menu">
									<!-- main menu navbar start -->
									<nav class="desktop-menu">
										<ul>
											<li><a href="./index" style="font-size: 40px;">主页</a></li>
											<li><a href="./hotelindex" style="font-size: 40px;">酒店信息</a></li>
											<li><a href="./orderlist"
												style="font-size: 40px;">我的订单</a></li>
										</ul>
									</nav>
									<!-- main menu navbar end -->
								</div>
							</div>
						</div>
						<!-- main menu area end -->

						<!-- mini cart area start -->
						<div class="col-lg-3">
							<div class="header-configure-wrapper">
								<div class="header-configure-area">
									<ul class="nav justify-content-end">
										<li class="user-hover"><a href="#"> <i
												class="lnr lnr-user"></i>
										</a>
											<ul class="dropdown-list">
												<li><a href="login.jsp">退出</a></li>
											</ul></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
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
