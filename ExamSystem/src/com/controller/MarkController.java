package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dal.MarkDal;
import com.dal.judgeDal;
import com.dal.mchooseDal;
import com.dal.paperDal;
import com.dal.schooseDal;
import com.model.Judge;
import com.model.Mark;
import com.model.Mchoose;
import com.model.Paper;
import com.model.Schoose;
import com.model.User;


@Controller
public class MarkController {
	@RequestMapping(value="/Mark_judge")
	public void Mark_judge(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Integer paper_id=Integer.valueOf(request.getParameter("paper_id"));
		Paper paper=paperDal.findById(paper_id);
		List<Schoose> list_schoose=paperDal.showSchoose(paper);
		List<Mchoose> list_mchoose=paperDal.showMchoose(paper);
		List<Judge> list_judge=paperDal.showJudge(paper);
		Integer mark=0;
		boolean flag=false;
		User user=(User)session.getAttribute("user");
		String username=user.getUsername();
		List<Mark> list_mark=MarkDal.findByUserName(username);
		for(int i=0;i<list_mark.size();i++) {
			Mark mark3=list_mark.get(i);
			if(mark3.getPaper_id()==paper_id) {
				flag=false;
				out.print("<script type='text/javascript'>alert('重复答题，无效！');window.history.go(-1);</script>");
				out.flush();
				out.close();
			}else {
				flag=true;
			}
		}
		if(flag) {
			for(int i=0;i<list_schoose.size();i++) {
				String answerName="answerSchoose"+i;
				Schoose schoose=(Schoose)list_schoose.get(i);
				String answer=request.getParameter(answerName);
				if(schoose.getAnswer().equals(answer)) {
					mark=mark+Integer.valueOf(schoose.getScore());
				}
			}
			System.out.println(mark);
			for(int i=0;i<list_mchoose.size();i++) {
				String answerName="answerMchoose"+i;
				Mchoose mchoose=(Mchoose)list_mchoose.get(i);
				String[] answerValues=request.getParameterValues(answerName);
				String answer="";
				for(int j=0;j<answerValues.length;j++) {
					answer=answer+answerValues[j];
				}
				if(mchoose.getAnswer().equals(answer)) {
					mark=mark+Integer.valueOf(mchoose.getScore());
				}
			}
			System.out.println(mark);
			for(int i=0;i<list_judge.size();i++) {
				String answerName="answerJudge"+i;
				Judge judge=(Judge)list_judge.get(i);
				Integer answer=Integer.valueOf(request.getParameter(answerName));
				if(judge.getAnswer()==answer) {
					mark=mark+Integer.valueOf(judge.getScore());
				}
			}
			
			
			Mark mark2=new Mark();
			mark2.setPaper_id(paper_id);
			mark2.setUsername(username);
			mark2.setMark(String.valueOf(mark));
			if(MarkDal.addMark(mark2)){
				out.print("<script type='text/javascript'>alert('成功答题');window.history.go(-1);</script>");
				out.flush();
				out.close();
			}else{
				out.print("<script type='text/javascript'>alert('失败答题');window.history.go(-1);</script>");
				out.flush();
				out.close();
			}
		}
		
	}
	@RequestMapping(value="/selectMark")
	public void selectMark(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(request.getParameter("selectStyle").equals("1")) {
			List<Mark> list_mark=MarkDal.findByUserName(request.getParameter("selectText"));
			session.setAttribute("selectList", list_mark);
			out.print("<script type='text/javascript'>window.history.go(-1);</script>");
		}
		if(request.getParameter("selectStyle").equals("2")) {
			List<Paper> list_paper=paperDal.findPaperByPaperName(request.getParameter("selectText"));
			List<Integer> list=new ArrayList<Integer>();
			for(Paper paper:list_paper) {
				list.add(paper.getId());
			}
			List<Mark> list_mark=MarkDal.findByPaperId(list);
			session.setAttribute("selectList", list_mark);
			out.print("<script type='text/javascript'>window.history.go(-1);</script>");
		}
		if(request.getParameter("selectStyle").equals("")) {
			out.print("<script type='text/javascript'>alert('请选择内容');window.history.go(-1);</script>");
		}
		
	}
		
}
