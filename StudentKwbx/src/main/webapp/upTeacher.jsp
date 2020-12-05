<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.2</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="../css/font.css">
<link rel="stylesheet" href="../css/xadmin.css">
<script type="text/javascript" src="../lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../js/xadmin.js"></script>

</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" action="./UpStudent" method="post">

				<div class="layui-form-item">
					<div class="layui-input-inline">
						<input type="hidden" id="yid" name="yid" class="layui-input"
							value="${teacher.id }">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="username" class="layui-form-label"> <span
						class="x-red">*</span>学号
					</label>
					<div class="layui-input-inline">
						<input type="text" id="id" name="id" class="layui-input"
							value="${teacher.id }">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="username" class="layui-form-label"> <span
						class="x-red">*</span>学号
					</label>
					<div class="layui-input-inline">
							<select>
							<option>12</option>
							</select>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> </label>
					<button class="layui-btn">修改</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		layui.use([ 'laydate', 'form' ], function() {
			var laydate = layui.laydate;
			var form = layui.form;
			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});
	</script>
</body>

</html>
