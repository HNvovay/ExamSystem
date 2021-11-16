package com.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dal.paperDal;
import com.dal.schooseDal;
import com.model.Paper;
import com.model.Schoose;


@Controller
public class SchooseController {
		@RequestMapping(value="/addSchoose")
		public void addSchoose(HttpServletRequest request,HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Schoose schoose=new Schoose(
					request.getParameter("questionText"),
					request.getParameter("answer"),
					request.getParameter("optionA"),
					request.getParameter("optionB"),
					request.getParameter("optionC"),
					request.getParameter("optionD"),
					request.getParameter("score")
					);
			if(schooseDal.addSchoose(schoose)){
				out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/updateSchoose")
		public void updateSchoose(HttpServletRequest request,HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Schoose schooseupdate=new Schoose(
					Integer.parseInt(request.getParameter("id_update")),
					request.getParameter("questionText"),
					request.getParameter("answer"),
					request.getParameter("optionA"),
					request.getParameter("optionB"),
					request.getParameter("optionC"),
					request.getParameter("optionD"),
					request.getParameter("score")
					);
			if(schooseDal.updateSchoose(schooseupdate)){
				out.print("<script type='text/javascript'>alert('修改成功');window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('修改失败');window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/deleteSchoose")
		public void deleteSchoose(HttpServletRequest request,HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(schooseDal.deleteSchoose(Integer.parseInt(request.getParameter("id")))){
				out.print("<script type='text/javascript'>alert('删除成功');;window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('删除失败');;window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/selectSchoose")
		public void selectSchoose(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			List<Schoose> list=schooseDal.findSchooseByQuestionText(request.getParameter("selectText"));
			if(list!=null){
				session.setAttribute("selectList", list);
				out.print("<script type='text/javascript'>window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('暂无结果');;window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/addPaper_Schoose")
		public void addPaper_Schoose(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String schoose_id="";
			String[] check=request.getParameterValues("check");
			int id=Integer.valueOf(request.getParameter("addPaperId"));
			for(int i=0;i<check.length;i++){
				schoose_id=schoose_id+check[i]+",";
			}
			schoose_id=schoose_id.substring(0,schoose_id.length()-1);
			Paper paper=paperDal.findById(id);
			if(paper.getSchoose_id()==null||paper.getSchoose_id()==""){
				if(paperDal.addPaper_Schoose(id, schoose_id)){
					out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
				}else{
					out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
				}
			}else{
				schoose_id=paper.getSchoose_id()+","+schoose_id;
				if(paperDal.addPaper_Schoose(id, schoose_id)){
					out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
				}else{
					out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
				}
			}
		}
		
}
