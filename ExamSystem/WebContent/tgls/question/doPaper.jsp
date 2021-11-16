<%@page import="com.model.Judge"%>
<%@page import="com.model.Mchoose"%>
<%@page import="com.model.Schoose"%>
<%@page import="java.util.List"%>
<%@page import="com.dal.paperDal"%>
<%@page import="com.model.Paper"%>
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
			<form id="Mark_judge" class="layui-form" action="${pageContext.request.contextPath}/Mark_judge">
			<input type="hidden" name="paper_id" value="<%=request.getParameter("id")%>">
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">单选题</label>
					<div class="layui-input-block">
						<i class="iconfont icon-huaban bt"></i>
					</div>
				</div>
				<%
			 	 Paper paper=paperDal.findById(Integer.valueOf(request.getParameter("id")));
				int count=0;
				List<Schoose> list_schoose=paperDal.showSchoose(paper);
				List<Mchoose> list_mchoose=paperDal.showMchoose(paper);
				List<Judge> list_judge=paperDal.showJudge(paper);
				Schoose schoose=null;Mchoose mchoose=null;Judge judge=null;
				if(list_schoose!=null){
				for(int i=0;i<list_schoose.size();i++){
					count++;
					schoose=(Schoose)list_schoose.get(i);
				%>
				<div class="layui-form-item" style="width: 3000px;">
					<label class="layui-form-label">第<%=count %>题:</label>
					<div class="layui-input-inline shortInput" >
						<%=schoose.getQuestionText() %>
						</br>
						</br>
						A：<%=schoose.getOptionA() %>   &nbsp B：<%=schoose.getOptionB() %>  &nbsp C：<%=schoose.getOptionC() %>  &nbsp D：<%=schoose.getOptionD() %>
					</div>					
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">选择</label>
					<div class="layui-input-block">
						<input type="radio" name="answerSchoose<%=i%>" value="A" title="A" >
						<input type="radio" name="answerSchoose<%=i%>" value="B" title="B">
						<input type="radio" name="answerSchoose<%=i%>" value="C" title="C" >
						<input type="radio" name="answerSchoose<%=i%>" value="D" title="D">
					</div>
				</div>
				<%}} %>
				
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">多选题</label>
					<div class="layui-input-block">
						<i class="iconfont icon-huaban bt"></i>
					</div>
				</div>
				
				<% if(list_mchoose!=null){
					for(int i=0;i<list_mchoose.size();i++){
						count++;
						mchoose=(Mchoose)list_mchoose.get(i);
					%>
					<div class="layui-form-item" style="width: 3000px;">
						<label class="layui-form-label">第<%=count %>题:</label>
						<div class="layui-input-inline shortInput" >
							<%=mchoose.getQuestionText() %>
							</br>
							</br>
							A：<%=mchoose.getOptionA() %>   &nbsp B：<%=mchoose.getOptionB() %>  &nbsp C：<%=mchoose.getOptionC() %>  &nbsp D：<%=mchoose.getOptionD() %>
						</div>					
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">选择</label>
						<div class="layui-input-block">
							
							<input type="checkbox" name="answerMchoose<%=i%>"  value="A" title="A">
							<input type="checkbox" name="answerMchoose<%=i%>"  value="B" title="B">
							<input type="checkbox" name="answerMchoose<%=i%>"  value="C" title="C">
							<input type="checkbox" name="answerMchoose<%=i%>"  value="D" title="D">
						</div>
					</div>
					<%}} %>
					
					
					
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">判断题</label>
					<div class="layui-input-block">
						<i class="iconfont icon-huaban bt"></i>
					</div>
				</div>
				
				
				<%if(list_judge!=null){
					for(int i=0;i<list_judge.size();i++){
						count++;
						judge=(Judge)list_judge.get(i);
					%>
					<div class="layui-form-item" style="width: 3000px;">
						<label class="layui-form-label">第<%=count %>题:</label>
						<div class="layui-input-inline shortInput" >
							<%=judge.getQuestionText() %>
							</br>
						</div>					
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">选择</label>
						<div class="layui-input-block">
							<input type="radio" name="answerJudge<%=i%>" value="1" title="√" >
							<input type="radio" name="answerJudge<%=i%>" value="0" title="X">
						</div>
					</div>
					<%}} %>
					
					
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submitBut"  >立即交卷</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>

		</div>
	</body>
</html>