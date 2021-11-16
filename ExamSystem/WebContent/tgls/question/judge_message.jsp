<%@page import="com.model.Judge"%>
<%@page import="com.model.Mchoose"%>
<%@page import="com.dal.schooseDal"%>
<%@page import="com.model.Schoose"%>
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
		<!-- <script src="../../framework/cframe.js"></script> --><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>
			.layui-form{
				margin-right: 30%;
			}
		</style>

	</head>

	<body >
	<%if(request.getParameter("id")==null){ %>
	<script type="text/javascript">
	function a(){
        var sessionStorage=window.sessionStorage;
        document.getElementById("id").value=sessionStorage.getItem('id');
        sessionStorage.clear();
        var formObj = document.getElementById('passForm');
        formObj.submit();
	}
	window.addEventListener("load",a,true);
	</script>
	<%} %>
	<form action="judge_message.jsp" id="passForm" method="post"><input id = "id" type = "hidden" name="id"> </form>
	
	<jsp:useBean id="judgedal" class="com.dal.judgeDal"></jsp:useBean>
	
		<div class="cBody">
			<form id="updateJudge" class="layui-form" action="../judge.jsp">
			<input type="hidden" name="judge" value="updateJudge">
			<input type="hidden" name="id_update" value="<%= request.getParameter("id")%>">
			<%	 Judge judge=new Judge();
				if(request.getParameter("id")!=null){
					judge=judgedal.findById(Integer.parseInt(request.getParameter("id")));
				}
			%>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">题目文本</label>
					<div class="layui-input-block">
						<textarea id="questionText" readonly="readonly" name="questionText" placeholder="50字以内" required class="layui-textarea" ><%=judge.getQuestionText() %></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">分值</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="score" id="score" disabled required autocomplete="off" class="layui-input" value="<%=judge.getScore()%>">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">答案</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="answer" disabled required autocomplete="off" id="answer" placeholder="例如：单选A，多选AB" class="layui-input" value="<%=judge.getAnswer()%>">
					</div>
					<i class="iconfont icon-huaban bt"></i>
				</div>

			
			</form>

		</div>
	</body>