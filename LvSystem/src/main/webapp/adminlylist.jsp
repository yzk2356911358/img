<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="./assets/css/layui.css">
<link rel="stylesheet" href="./assets/css/view.css" />
</head>
<body class="layui-view-body">
	<div class="layui-content">
		<!--面包屑导航-->
		<div class="layui-row">
			<div class="layui-card">
				<div class="table-responsive">
				<button type="button" class="layui-btn"><a href="addshop.jsp" style="color: #F0F8FF">新增旅游信息</a> </button>
					<table class="layui-table" lay-skin="line" lay-size="lg" id="table">
						<thead>
							<tr>
								<th width="15%">编号</th>
								<th>图片</th>
								<th>标题</th>
								<th>价格</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="temp" items="${list }">
								<tr>
									<td>${temp.id }</td>
									<td><img alt="" src="file/${temp.img }" style="40px;height: 40px;"></td>
									<td>${temp.title}</td>
									<td>${temp.money}</td>
									<td><a href="./getlv?id=${temp.id }">修改</a> <a
										href="./dellv?id=${temp.id }">删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>