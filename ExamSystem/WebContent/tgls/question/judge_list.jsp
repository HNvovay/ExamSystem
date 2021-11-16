<%@page import="com.dal.paperDal"%>
<%@page import="com.model.Paper"%>
<%@page import="com.model.Judge"%>
<%@page import="com.dal.judgeDal"%>
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
		<script src="../../framework/cframe.js"></script>
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
					<li class="layui-this" lay-id="JudgeList">判断题</li>
				</ul>
				
				
				<!--单选  -->
				<div class="layui-tab-content">
						<form class="layui-form" action="${pageContext.request.contextPath}/selectJudge">
						<input type="hidden" name="judge" value="selectJudge">
							<div class="layui-form-item">
								<div class="layui-input-inline">
									<input type="text" name="selectText"  lay-verify="required"  placeholder="输入判断题相关内容" autocomplete="off" class="layui-input">
								</div>
								<button class="layui-btn" lay-submit lay-filter="formDemo" onclick="history.go(0)">检索</button>
								<button type="button" class="layui-btn" onclick="Refresh()">刷新</button>
								<button class="layui-btn" form="addPaper" >添加</button>
								
								<div class="layui-input-inline">
				                    <select form="addPaper" name="addPaperId">
				                        <option value="">试卷(仅对添加按钮有效)</option>
				                        <%
				                        try{
				                         	List<Paper> paList=paperDal.getList();
				                         	for(Paper paper:paList){
				                        	if(paper.getState().equals("未发布")){%>
				                        <option value="<%=paper.getId()%>"><%=paper.getPaperName() %></option>
				                        <%}}}catch(Exception e){out.print("<script type='text/javascript'>window.history.go(0);</script>");}; %>
				                    </select>
	              			 	 </div>
							</div>
						</form>
						<form id="addPaper" class="layui-form" action="${pageContext.request.contextPath}/addPaper_Judge">
						<input type="hidden" name="judge" value="addPaper_Judge">
						<table class="layui-table">
						
							<thead>
								<tr>
								<th width="30px">选择</th>
									<th >id</th>
									<th >题目文本</th>
									<th >答案</th>
									<th>分数</th>
									<th>操作</th>
								</tr>
							</thead>
					
							<tbody>
						<jsp:useBean id="paging" scope="page" class="com.common.Paging"></jsp:useBean>
						<jsp:useBean id="mchoosedal" class="com.dal.mchooseDal"></jsp:useBean>
						<%
						Judge judge=null;
						List list=null;
						try{
							if(session.getAttribute("selectList")==null){
								list=judgeDal.getList();		
							}else{
								list=(List)session.getAttribute("selectList");
							}
						}catch(Exception e){
							out.print("<script type='text/javascript'>window.history.go(0);</script>");
						}
						try{	
						paging.setList(list);
						paging.setToPage(request.getParameter("ToPage"));
						paging.Pnum();
						paging.judge();
						}catch(Exception e){
							out.print("<script type='text/javascript'>window.history.go(0);</script>");	
						}
						for(int i=0;i<paging.getPageSize();i++)
						{	try{
							judge=(Judge)paging.getList().get(i);	
						%>
								<tr>
									<td><input type="checkbox" name="check" lay-skin="primary" value="<%=judge.getId() %>"></td>
									<td><%=judge.getId() %></td>
									<td><%=judge.getQuestionText()%></td>
									<td><%if(judge.getAnswer()==1)out.print("√");else out.print("×");%></td>
									<td><%=judge.getScore() %></td>
									<td>
									<button type="button" class="layui-btn layui-btn-xs" onclick="updateSchoose(<%=judge.getId() %>)">修改</button>
									<button  type="button" class="layui-btn layui-btn-xs" onclick="messageSchoose(<%=judge.getId() %>)">详细信息</button>
									<button type="button" class="layui-btn layui-btn-xs" onclick="deleteSchoose(this,<%=judge.getId() %>)">删除</button>
									</td>
								</tr>
							<%}catch(Exception e){break;}}%>	
							</tbody>
						</table>
						</form>
						<div class="black2">
                    	<%if(paging.getShowPage()==1){%>                   	
							<span class="disabled"> < </span>
						<%}else{%>
							<a href="judge_list.jsp?ToPage=<%=paging.getShowPage()-1%>" ><</a>
						<%} %>
						<%for(int i=1;i<=paging.getPageCount();i++) {%>	
						<%if(paging.getShowPage()==i) {%>
							<span class="current"><%=i %></span>
							<%}else{%>			
							<a href="judge_list.jsp?ToPage=<%=i %>" ><%=i%></a>
							<%} %>
						<%} %>	
						<%if(paging.getShowPage()==paging.getPageCount()){ %>						
							<span class="disabled"> > </span>
						<%}else{%>
							<a href="judge_list.jsp?ToPage=<%=paging.getShowPage()+1 %>"> > </a>
						<%} %>
					</div>
					</div>

	
			<script>
			function go(){
				var obj=document.getElementById('addPaper');
				obj.submit();//表单中的参数会一起提交
				}
			
			function Refresh(){
				<%session.removeAttribute("selectList");%>
				location.reload();
			}
			
				layui.use('element', function() {
					var element = layui.element;

					//获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
					var layid = location.hash.replace(/^#test1=/, '');
					element.tabChange('myPage', layid); //假设当前地址为：http://a.com#test1=222，那么选项卡会自动切换到“发送消息”这一项

					//监听Tab切换，以改变地址hash值
					element.on('tab(myPage)', function() {
						location.hash = 'test1=' + this.getAttribute('lay-id');
						console.log(this.getAttribute('lay-id'));
					});
				});
				
				//查看单选信息
				function messageSchoose(id){
					
					layui.use('layer', function() {
						var layer = layui.layer;
						
						var sessionStorage=window.sessionStorage;
						sessionStorage.setItem('id', id); 
						//iframe层-父子操作
						layer.open({
							type: 2,
							area: ['70%', '60%'],
							fixed: false, //不固定
							scrollbar: true,
							maxmin: true,
							content: 'judge_message.jsp'
						});
					});
					
				}
				//删除单选按钮
				function deleteSchoose(_this,id){
					layer.confirm('确定删除吗', {
						  btn: ['确定','取消'] //按钮
						}, function(){
						$(_this).parent().parent().remove()
						  location.href="${pageContext.request.contextPath}/deleteJudge?id="+id
							
						}, function(){
							layer.msg('取消删除', {
								time: 2000 //20s后自动关闭
							});
						});
				}
			
				//修改单选按钮
				var updateFrame = null;
				function updateSchoose(id){
					var layer = layui.layer;
					var sessionStorage=window.sessionStorage;
					sessionStorage.setItem('id', id); 
					layui.use('layer', function() {
						
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "商品信息修改",
							type: 2,
							area: ['70%', '60%'],
							scrollbar: true,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
							content: 'judge_update.jsp'
						});
					});
				}
			</script>
		</div>
	</body>
</html>