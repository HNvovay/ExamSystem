package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dal.mchooseDal;
import com.dal.paperDal;
import com.model.Paper;
import com.model.User;
import com.sun.org.apache.xml.internal.security.Init;

@Controller

public class PaperController {
	
	@RequestMapping(value="/addRandomPaper")
	public void addRandomPaper(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String type=request.getParameter("type");
		String paperName=request.getParameter("paperName");
		if(paperDal.addPaper(type, paperName)){
			out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
		}else{
			out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
		}
	}
	@RequestMapping(value="/selectPaper")
	public void selectPaper(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<Paper> paper_list=paperDal.findPaperByPaperName(request.getParameter("selectText"));
		if(paper_list!=null){
			session.setAttribute("selectList", paper_list);
			out.print("<script type='text/javascript'>window.history.go(-1);</script>");
		}else{
			out.print("<script type='text/javascript'>alert('暂无结果');;window.history.go(-1);</script>");
		}
	}
	@RequestMapping(value="/addPaper")
	public void addPaper(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String paperName1=request.getParameter("paperName");
		if(paperDal.addPaper(paperName1)){
			out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
		}else{
			out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
		}
	}
	@RequestMapping(value="/changeState")
	public void changeState(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		String state="已发布";
		if(paperDal.changeState(Integer.valueOf(id), state)) {
			out.print("<script type='text/javascript'>alert('发布成功');window.history.go(-1);</script>");
		}else{
			out.print("<script type='text/javascript'>alert('发布失败');window.history.go(-1);</script>");
		}
	}
	@RequestMapping(value="/deletePaper")
	public void deleteMchoose(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(paperDal.deletePaper(Integer.parseInt(request.getParameter("id")))){
			out.print("<script type='text/javascript'>alert('删除成功');;window.history.go(-1);</script>");
		}else{
			out.print("<script type='text/javascript'>alert('删除失败');;window.history.go(-1);</script>");
		}
		
	}
	
}
