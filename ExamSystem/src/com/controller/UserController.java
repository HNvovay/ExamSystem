package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;

@Controller

public class UserController {
	@RequestMapping(value="/login")
	public void login(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		session.setMaxInactiveInterval(30*60);
		User user=new User(request.getParameter("username"),request.getParameter("password"),Integer.valueOf(request.getParameter("role")));
		User user1=user.login(user.getUsername(), user.getPassword());
		if(user1!=null){
			if(user1.getRole()==1){
				session.setAttribute("user", user1);
				response.sendRedirect("student.jsp");
			}else if(user1.getRole()==2){
				session.setAttribute("user", user1);
				response.sendRedirect("teacher.jsp");
			}
		}else{
			out.print("<script type='text/javascript'>alert('验证失败');location.href='login.jsp';</script>");
		}
	}
	@RequestMapping(value="/updatePassword")
	public void updatePassword(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		User usersession=(User)session.getAttribute("user");
		User user=new User();
		if(request.getParameter("password").equals(usersession.getPassword())){
			if(request.getParameter("password1").equals(request.getParameter("password2"))){
				String username=usersession.getUsername();
				String password=request.getParameter("password1");
				if(user.updatePassword(username, password)){
					usersession.setPassword(password);
					session.setAttribute("user", usersession);
					out.print("<script type='text/javascript'>alert('修改成功');window.history.go(-1);</script>");
				}else{
					out.print("<script type='text/javascript'>alert('修改失败');window.history.go(-1);</script>");
				}
			}else{
				out.print("<script type='text/javascript'>alert('请重新确认密码');window.history.go(-1);</script>");
			}	
		}else{
			out.print("<script type='text/javascript'>alert('原密码错误');window.history.go(-1);</script>");
		}
	}
	
	@RequestMapping(value="/Exit")
	public void Exit(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
}
