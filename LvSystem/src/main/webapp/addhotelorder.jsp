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
<style type="text/css">
.file {
	position: relative;
	display: inline-block;
	background: #D0EEFF;
	border: 1px solid #99D3F5;
	border-radius: 4px;
	padding: 4px 12px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
}

.file input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
}

.file:hover {
	background: #AADFFD;
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}
</style>
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
											<li><a href="product-details.html"
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
		<div class="layui-content">
			<!--指示条-->
			<div class="layui-row">
				<div class="layui-card positionbox">
					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 20px;">
						<legend>入住酒店信息</legend>
					</fieldset>
					<form class="layui-form" action="./addorder" method="post">
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="col-red">*</span>酒店</label>
							<div class="layui-input-block">
								<input style="width: 300px;" type="text" name="hotelname"
									autocomplete="off" class="layui-input" value="${hotel.title }" >
							</div>
						</div>
					
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="col-red">*</span>电话</label>
							<div class="layui-input-block">
								<input style="width: 300px;" type="text" name="tel"
									autocomplete="off" class="layui-input" >
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="col-red">*</span>身份证号码</label>
							<div class="layui-input-block">
								<input style="width: 300px;" type="text" name="sfz"
									autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="col-red">*</span>价格</label>
							<div class="layui-input-block">
								<input style="width: 300px;" type="text" name="money" 
									autocomplete="off" class="layui-input" value="${hotel.money }" >
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="col-red">*</span>时间</label>
							<div class="layui-input-block">
								<input style="width: 300px;" type="date" name="date"
									autocomplete="off" class="layui-input">
							</div>
						</div>
						
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button type="submit" class="layui-btn layui-btn-normal">预定</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>
