package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dal.mchooseDal;
import com.dal.paperDal;
import com.dal.schooseDal;
import com.model.Mchoose;
import com.model.Paper;
import com.model.Schoose;


@Controller
public class MchooseController {
		@RequestMapping(value="/addMchoose")
		public void addMchoose(HttpServletRequest request,HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Mchoose schoose=new Mchoose(
					request.getParameter("questionText"),
					request.getParameter("answer"),
					request.getParameter("optionA"),
					request.getParameter("optionB"),
					request.getParameter("optionC"),
					request.getParameter("optionD"),
					request.getParameter("score")
					);
			if(mchooseDal.addMchoose(schoose)){
				out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/updateMchoose")
		public void updateMchoose(HttpServletRequest request,HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Mchoose mchooseupdate=new Mchoose(
					Integer.parseInt(request.getParameter("id_update")),
					request.getParameter("questionText"),
					request.getParameter("answer"),
					request.getParameter("optionA"),
					request.getParameter("optionB"),
					request.getParameter("optionC"),
					request.getParameter("optionD"),
					request.getParameter("score")
					);
			if(mchooseDal.updateMchoose(mchooseupdate)){
				out.print("<script type='text/javascript'>alert('修改成功');window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('修改失败');window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/deleteMchoose")
		public void deleteMchoose(HttpServletRequest request,HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(mchooseDal.deleteMchoose(Integer.parseInt(request.getParameter("id")))){
				out.print("<script type='text/javascript'>alert('删除成功');;window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('删除失败');;window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/selectMchoose")
		public void selectMchoose(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			List<Mchoose> mchoose_list=mchooseDal.findMchooseByQuestionText(request.getParameter("selectText"));
			if(mchoose_list!=null){
				session.setAttribute("selectList", mchoose_list);
				out.print("<script type='text/javascript'>window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('暂无结果');;window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/addPaper_Mchoose")
		public void addPaper_Mchoose(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String mchoose_id="";
			String[] check1=request.getParameterValues("check");
			int id1=Integer.valueOf(request.getParameter("addPaperId"));
			for(int i=0;i<check1.length;i++){
				mchoose_id=mchoose_id+check1[i]+",";
			}
			mchoose_id=mchoose_id.substring(0,mchoose_id.length()-1);
			Paper paper1=paperDal.findById(id1);
			if(paper1.getMchoose_id()==null||paper1.getMchoose_id()==""){
				if(paperDal.addPaper_Mchoose(id1, mchoose_id)){
					out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
				}else{
					out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
				}
			}else{
				mchoose_id=paper1.getMchoose_id()+","+mchoose_id;
				if(paperDal.addPaper_Mchoose(id1, mchoose_id)){
					out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
				}else{
					out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
				}
			}
			
		}
}
