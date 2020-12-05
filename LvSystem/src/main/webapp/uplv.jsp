<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
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

<body class="layui-view-body">
	<div class="layui-content">
		<!--指示条-->
		<div class="layui-row">
			<div class="layui-card positionbox">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 20px;">
					<legend>修改旅游信息</legend>
				</fieldset>
				<form class="layui-form" action="./uplv" method="post"
					enctype="multipart/form-data">
					<input type="hidden" name="id" value="${shop.id}">
					<div class="layui-form-item">
						<label class="layui-form-label"><span class="col-red">*</span>标题</label>
						<div class="layui-input-block">
							<input style="width: 300px;" type="text" name="title"
								autocomplete="off" class="layui-input" value="${shop.title }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><span class="col-red">*</span>价格</label>
						<div class="layui-input-block">
							<input style="width: 300px;" type="text" name="moneya"
								autocomplete="off" class="layui-input" value="${shop.money }">
						</div>
					</div>

					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label"><span class="col-red">*</span>照片</label>
							<div class="layui-input-block">
								<a href="javascript:;" class="file">选择文件 <input type="file"
									name="file" id=""></a>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button type="submit" class="layui-btn layui-btn-normal">修改旅游信息</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>