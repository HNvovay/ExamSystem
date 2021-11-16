<%@page import="com.dal.MarkDal"%>
<%@page import="com.dal.paperDal"%>
<%@page import="com.dal.userDal"%>
<%@page import="com.model.User"%>
<%@page import="com.model.Mark"%>
<%@page import="com.model.Paper"%>
<%@page import="com.model.Mchoose"%>
<%@page import="java.util.List"%>
<%@page import="com.model.Schoose"%>
<%@page import="com.dal.schooseDal"%>
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
		<link rel="stylesheet" type="text/css" href="css/demo.css"/>
		<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
		<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
		<script src="../../framework/jquery.mousewheel.min.js"></script>
		<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
		<!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

		<script src="../../js/out_intoData.js"></script>

	</head>

	<body>
		<style type="text/css">
		/*css black2 style pagination*/
			div.black2{padding:7px;margin:3px;text-align:center;}
			div.black2 a{border:#000000 1px solid;padding:2px 5px;margin:2px;color:#000000;text-decoration:none;}
			div.black2 a:hover{border:#000000 1px solid;color:#fff;background-color:#000;}
			div.black2 a:active{border:#000000 1px solid;color:#fff;background-color:#000;}
			div.black2 span.current{border:#000000 1px solid;padding:2px 5px;font-weight:bold;margin:2px;color:#fff;background-color:#000000;}
			div.black2 span.disabled{border:#eee 1px solid;padding:2px 5px;margin:2px;color:#ddd;}
		</style>
		<div class="cBody">
			<div class="layui-tab" lay-filter="myPage">
				<ul class="layui-tab-title">
					<li class="layui-this" lay-id="SchooseList">成绩</li>
				</ul>
				
				
				<!--单选  -->
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show" >
						
						<form id="form1" class="layui-form" action="${pageContext.request.contextPath}/selectMark">
						<input type="hidden" name="judge" value="selectSchoose">
							<div class="layui-form-item">
								<div class="layui-input-inline">
				                    <select form="form1"  name="selectStyle">
				                        <option value="">请选择学生或者试卷</option>
				                        <option value="1">学生</option>
				                        <option value="2">试卷</option>
				                    </select>
	              			 	 </div>
								<div class="layui-input-inline">
									<input type="text" name="selectText"  lay-verify="required"  placeholder="输入单选题相关内容" autocomplete="off" class="layui-input">
								</div>
								<button class="layui-btn" lay-submit lay-filter="formDemo" onclick="history.go(0)">检索</button>
								<button type="button" class="layui-btn" onclick="Refresh()">刷新</button>
								
				 	                   
							</div>
						</form>
						<table class="layui-table">
							<thead>
								<tr>
									<th >id</th>
									<th >学生姓名</th>
									<th >试卷名称</th>
									<th >分数</th>
								</tr>
							</thead>
						<jsp:useBean id="paperdal" class="com.dal.paperDal"></jsp:useBean>
						<%
						Mark mark=null;
						List<Mark> list=null;
						try{
							if(session.getAttribute("selectList")==null){
								list=MarkDal.getList();	
							}else{
								list=(List)session.getAttribute("selectList");
							}
						}catch(Exception exception){
							out.print("<script type='text/javascript'>window.history.go(0);</script>");}
						try{
						for(int i=0;i<list.size();i++)
						{	try{
							mark=(Mark)list.get(i);	
						%>
								<tr>
									<td><%=mark.getId()%></td>
									<td><%=mark.getUsername() %></td>
									<td><%=paperDal.findById(mark.getPaper_id()).getPaperName()%></td>
									<td><%=mark.getMark()%></td>
									
								</tr>
							<%}catch(Exception e){break;}}
							}catch(Exception exception){
							out.print("<script type='text/javascript'>window.history.go(0);</script>");}%>	
							</tbody>
						</table>
						
						
					</div>

	
			<script>
			
			function Refresh(){
				<%session.removeAttribute("selectList");%>
				location.reload();
			}
			
				//打印方法
			    function printTable(id){
			    	$('#'+id).printThis({ importCss: true, importStyle: true });
			    }
			    layui.use('form', function(){
					  var form = layui.form;
					  form.render();
					});
			</script>
		</div>
	</body>
</html>