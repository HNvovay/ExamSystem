<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="../../css/base.css">
		<link rel="stylesheet" type="text/css" href="../../css/iconfont.css">
		<script type="text/javascript" src="../../framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
		<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
		<script src="../../framework/jquery.mousewheel.min.js"></script>
		<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="../../framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>
			.layui-form{
				margin-right: 30%;
			}
		</style>

	</head>
	<body>
		<div class="cBody">
			<form id="addSchoose" class="layui-form" action="${pageContext.request.contextPath}/addRandomPaper">
			<input type="hidden" name="judge" value="addRandomPaper">
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">试卷名称</label>
					<div class="layui-input-block">
						<input type="text" name="paperName"   autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">试卷类型</label>
					<div class="layui-input-block">
						<input type="radio" name="type" value="A" title="试卷A">
						<input type="radio" name="type" value="B" title="试卷B">
						<input type="radio" name="type" value="C" title="试卷C">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">试卷A</label>
					<div class="layui-input-inline shortInput">
						<label >20道单选题,15道多选题,15道判断题,总分100</label>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">试卷B</label>
					<div class="layui-input-inline shortInput">
						<label >10道单选题,10道多选题,10道判断题,总分60</label>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">试卷C</label>
					<div class="layui-input-inline shortInput">
						<label >5道单选题,5道多选题,5道判断题,总分30</label>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submitBut"  >立即生成</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>