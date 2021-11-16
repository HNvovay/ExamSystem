<%@page import="com.model.Judge"%>
<%@page import="com.model.Mchoose"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.model.Schoose"%>
<%@page import="java.util.List"%>
<%@page import="com.dal.paperDal"%>
<%@page import="com.model.Paper"%>
<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
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
		<!-- 仅供所有子页面使用 -->
		<script src="../../framework/printThis.js"></script>
		<!-- 公共样式 结束 -->
		

	</head>

	<body>
		<div class="cBody">
			<div class="console">
				<div class="layui-form-item">
					<a class="layui-btn layui-btn-sm layui-btn-normal" onclick="printTable('dayindaju1')">打印</a>
				</div>
			</div>
			<%
				User user=(User)session.getAttribute("user"); 
			 	 Paper paper=paperDal.findById(Integer.valueOf(request.getParameter("id")));
			%>
			<div class="layui-row" id="dayindaju1">
				<table class="layui-table printTable">
					<tbody>
						<tr>
							<td class="printName" colspan="8"><%=paper.getPaperName() %></td>
						</tr>
						<tr>
							<td class="printDis" colspan="8">
								<span>提示：HYH出品必属精品</span>
								<span class="right">试卷id：<%=request.getParameter("id") %></span>
								<span>出卷人：<%=user.getUsername() %></span>
							</td>
						</tr>
						<!-- 单选题 -->
						<tr>
							<th width="8%" class="textCenter">序号</th>
							<th width="20%">题目名称（单选题）</th>
							<th width="5%" class="textCenter">答案</th>
							<th width="12%" class="textCenter">A</th>
							<th width="12%" class="textCenter">B</th>
							<th width="12%" class="textCenter">C</th>
							<th width="12%" class="textCenter">D</th>
							<th>分值</th>
						</tr>
						
						<%List<Schoose> list_schoose=paperDal.showSchoose(paper);
						Schoose schoose=null;
						int count=0;
						if(list_schoose!=null){
						for(int i=0;i<list_schoose.size();i++){
							count++;
							schoose=(Schoose)list_schoose.get(i);
						%>
						<tr>
							<td class="textCenter"><%=count%></td>
							<td><%=schoose.getQuestionText() %></td>
							<td class="textCenter"><%=schoose.getAnswer() %></td>
							<td class="textCenter"><%=schoose.getOptionA() %></td>
							<td class="textCenter"><%=schoose.getOptionB() %></td>
							<td class="textCenter"><%=schoose.getOptionC() %></td>
							<td class="textCenter"><%=schoose.getOptionD() %></td>
							<td class="textCenter"><%=schoose.getScore()%></td>
						</tr>
						<%}} %>
			            <!-- 多选题 -->
						<tr>
							<th width="8%" class="textCenter">序号</th>
							<th width="20%">题目名称（多选题）</th>
							<th width="5%" class="textCenter">答案</th>
							<th width="12%" class="textCenter">A</th>
							<th width="12%" class="textCenter">B</th>
							<th width="12%" class="textCenter">C</th>
							<th width="12%" class="textCenter">D</th>
							<th>分值</th>
						</tr>
						
						<%
						try{
						List<Mchoose> list_mchoose=paperDal.showMchoose(paper);
						Mchoose mchoose=null;
						
						for(int i=0;i<list_mchoose.size();i++){
							count++;
							mchoose=(Mchoose)list_mchoose.get(i);
						%>
						<tr>
							<td class="textCenter"><%=count%></td>
							<td><%=mchoose.getQuestionText() %></td>
							<td class="textCenter"><%=mchoose.getAnswer() %></td>
							<td class="textCenter"><%=mchoose.getOptionA() %></td>
							<td class="textCenter"><%=mchoose.getOptionB() %></td>
							<td class="textCenter"><%=mchoose.getOptionC() %></td>
							<td class="textCenter"><%=mchoose.getOptionD() %></td>
							<td class="textCenter"><%=mchoose.getScore()%></td>
						</tr>
						<%}} catch(Exception e){}%>
						
						<!-- 判断题 -->
						<tr>
							<th width="8%" class="textCenter">序号</th>
							<th width="40%">题目名称（判断题）</th>
							<th  class="textCenter" colspan="5">答案</th>
							<th>分值</th>
						</tr>
						
						<%
						try{
						List<Judge> list_judge=paperDal.showJudge(paper);
						Judge judge=null;
						for(int i=0;i<list_judge.size();i++){
							count++;
							judge=(Judge)list_judge.get(i);
						%>
						<tr>
							<td class="textCenter"><%=count%></td>
							<td><%=judge.getQuestionText() %></td>
							<td class="textCenter" colspan="5"><%if(judge.getAnswer()==1)out.print("√");else out.print("X"); %></td>
							<td class="textCenter"><%=judge.getScore()%></td>
						</tr>
						<%}}catch(Exception e){}%>
						<tr>
							<td class="printOperator" colspan="8">
								<span>出卷人：<%=user.getUsername() %></span>
								<span class="right">打印日期：2020-05-10 </span>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
		
		<script>
			//打印方法
		    function printTable(id){
		    	$('#'+id).printThis({ importCss: true, importStyle: true });
		    }
		</script>
	</body>

</html>