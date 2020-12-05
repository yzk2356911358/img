<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="./css/xadmin.css">
<!-- <link rel="stylesheet" href="./css/theme5.css"> -->
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>

</head>
<body class="index">
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.jsp" style="font-size: 40px;">食品商城</a>
		</div>
		<div class="left_open">
			<a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
		</div>

		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">欢迎</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a href="./login.jsp">退出</a>
					</dd>
				</dl></li>

		</ul>
	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont left-nav-li">&#xe6b8;</i>
						<cite>系统菜单</cite> <i class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('牲畜','./ShopList?fl=sc')">
								<i class="iconfont">&#xe6a7;</i> <cite>牲畜</cite>
						</a></li>
						<li><a onclick="xadmin.add_tab('家禽','ShopList?fl=jq')">
								<i class="iconfont">&#xe6a7;</i> <cite>家禽</cite>
						</a></li>
						<li><a onclick="xadmin.add_tab('海鲜','./ShopList?fl=hx')">
								<i class="iconfont">&#xe6a7;</i> <cite>海鲜</cite>
						</a></li>
						<li><a onclick="xadmin.add_tab('海鲜','./ShopList?fl=sg')">
								<i class="iconfont">&#xe6a7;</i> <cite>水果</cite>
						</a></li>
						<li><a onclick="xadmin.add_tab('海鲜','./ShopList?fl=scc')">
								<i class="iconfont">&#xe6a7;</i> <cite>蔬菜</cite>
						</a></li>
					</ul></li>

			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>

</body>

</html>