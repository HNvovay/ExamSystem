<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%if(session.getAttribute("user")==null || session.getAttribute("user")==""){
out.print("<script type='text/javascript'>alert('请先登录');location.href='login.jsp';</script>");
return;
} %>
