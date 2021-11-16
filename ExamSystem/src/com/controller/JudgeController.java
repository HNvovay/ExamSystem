package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dal.judgeDal;
import com.dal.mchooseDal;
import com.dal.paperDal;
import com.dal.schooseDal;
import com.model.Judge;
import com.model.Mchoose;
import com.model.Paper;
import com.model.Schoose;


@Controller
public class JudgeController {
		@RequestMapping(value="/addJudge")
		public void addJudge(HttpServletRequest request,HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Judge judge=new Judge(
					request.getParameter("questionText"),
					Integer.valueOf(request.getParameter("answer")),
					request.getParameter("score")
					);
			if(judgeDal.addJudge(judge)){
				out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/selectJudge")
		public void selectJudge(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			List<Judge> judge_list=judgeDal.findJudgeByQuestionText(request.getParameter("selectText"));
			if(judge_list!=null){
				session.setAttribute("selectList", judge_list);
				out.print("<script type='text/javascript'>window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('暂无结果');;window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/updateJudge")
		public void updateJudge(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			Judge judgeupdate=new Judge(
					Integer.parseInt(request.getParameter("id_update")),
					request.getParameter("questionText"),
					Integer.parseInt(request.getParameter("answer")),
					request.getParameter("score")
					);
			if(judgeDal.updateJudge(judgeupdate)){
				out.print("<script type='text/javascript'>alert('修改成功');window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('修改失败');window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/deleteJudge")
		public void deleteJudge(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(judgeDal.deleteJudge(Integer.parseInt(request.getParameter("id")))){
				out.print("<script type='text/javascript'>alert('删除成功');window.history.go(-1);</script>");
			}else{
				out.print("<script type='text/javascript'>alert('删除失败');window.history.go(-1);</script>");
			}
			
		}
		@RequestMapping(value="/addPaper_Judge")
		public void addPaper_Judge(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String judge_id="";
			String[] check2=request.getParameterValues("check");
			int id2=Integer.valueOf(request.getParameter("addPaperId"));
			for(int i=0;i<check2.length;i++){
				judge_id=judge_id+check2[i]+",";
			}
			judge_id=judge_id.substring(0,judge_id.length()-1);
			Paper paper2=paperDal.findById(id2);
			if(paper2.getJudge_id()==null||paper2.getJudge_id()==""){
				if(paperDal.addPaper_Judge(id2, judge_id)){
					out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
				}else{
					out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
				}
			}else{
				judge_id=paper2.getJudge_id()+","+judge_id;
				if(paperDal.addPaper_Judge(id2, judge_id)){
					out.print("<script type='text/javascript'>alert('添加成功');window.history.go(-1);</script>");
				}else{
					out.print("<script type='text/javascript'>alert('添加失败');window.history.go(-1);</script>");
				}
			}
			
		}
}
