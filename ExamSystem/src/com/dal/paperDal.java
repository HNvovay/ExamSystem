package com.dal;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.common.MybatisUtils;
import com.model.Judge;
import com.model.Mchoose;
import com.model.Paper;
import com.model.Schoose;

public class paperDal {
	
	public static boolean addPaper(String type,String paperName) {
		
		List<Schoose> schooses;
		List<Mchoose> mchooses;
		List<Judge> judges;
		
		String s_ids="",m_ids="",j_ids="";
		schooses=schooseDal.selectRandomSchoose(type);
		mchooses=mchooseDal.selectRandomMchoose(type);
		judges=judgeDal.selectRandomJudge(type);
		
		for(int i=0;i<schooses.size();i++) {	
			s_ids=s_ids+schooses.get(i).getId().toString()+",";
		}
		for(int i=0;i<mchooses.size();i++) {	
			m_ids=m_ids+mchooses.get(i).getId().toString()+",";
		}
		for(int i=0;i<judges.size();i++) {	
			j_ids=j_ids+judges.get(i).getId().toString()+",";
		}
		s_ids=s_ids.substring(0,s_ids.length()-1);
		m_ids=m_ids.substring(0,m_ids.length()-1);
		j_ids=j_ids.substring(0,j_ids.length()-1);
		Paper paper=new Paper(paperName,s_ids,m_ids,j_ids,"未发布");
		SqlSession session=MybatisUtils.getSession();
		int Rows=session.insert("com.model.Paper.addPaper", paper);
		if(Rows>0) {
			session.commit();
			session.close();
			return true;
		}else {
			session.close();
			return false;
		}
	}
	public static boolean addPaper(String paperName) {
		Paper paper=new Paper();
		paper.setPaperName(paperName);
		paper.setState("未发布");
		SqlSession session=MybatisUtils.getSession();
		int Rows=session.insert("com.model.Paper.addPaper", paper);
		if(Rows>0) {
			session.commit();
			session.close();
			return true;
		}else {
			session.close();
			return false;
		}
	}
	public static List<Paper> getList(){
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Paper> list=sqlSession.selectList("com.model.Paper.getList");
		sqlSession.close();
		return list;
	}
	public static List<Paper> findPaperByPaperName(String questionText) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Paper> list=sqlSession.selectList("com.model.Paper.findPaperByPaperName",questionText);
		sqlSession.close();
		return list;
	}
	public static Paper findById(int id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Paper paper=sqlSession.selectOne("com.model.Paper.findById", id);
		sqlSession.close();
		return paper;
	}
	public static List<Schoose> showSchoose(Paper paper){
		String idString=paper.getSchoose_id();
		String[] strings=idString.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<strings.length;i++) {
			ids.add(Integer.parseInt(strings[i]));
		}
		List<Schoose> list=schooseDal.findByIds(ids);
		return list;
	}
	public static List<Mchoose> showMchoose(Paper paper){
		String idString=paper.getMchoose_id();
		String[] strings=idString.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<strings.length;i++) {
			ids.add(Integer.parseInt(strings[i]));
		}
		List<Mchoose> list=mchooseDal.findByIds(ids);
		return list;
	}
	public static List<Judge> showJudge(Paper paper){
		String idString=paper.getJudge_id();
		String[] strings=idString.split(",");
		List<Integer> ids=new ArrayList<Integer>();
		for(int i=0;i<strings.length;i++) {
			ids.add(Integer.parseInt(strings[i]));
		}
		List<Judge> list=judgeDal.findByIds(ids);
		return list;
	}
	public static boolean addPaper_Schoose(int PaperId,String schoose_id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Paper paper=new Paper();
		paper.setId(PaperId);
		paper.setSchoose_id(schoose_id);
		int Rows=sqlSession.update("com.model.Paper.updateSchoose", paper);
		//判断是否执行成功
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
	}
	public static boolean addPaper_Mchoose(int PaperId,String mchoose_id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Paper paper=new Paper();
		paper.setId(PaperId);
		paper.setMchoose_id(mchoose_id);
		int Rows=sqlSession.update("com.model.Paper.updateMchoose", paper);
		//判断是否执行成功
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
	}
	public static boolean addPaper_Judge(int PaperId,String judge_id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Paper paper=new Paper();
		paper.setId(PaperId);
		paper.setJudge_id(judge_id);
		int Rows=sqlSession.update("com.model.Paper.updateJudge", paper);
		//判断是否执行成功
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
	}
	public static boolean changeState(int PaperId,String state) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Paper paper=new Paper();
		paper.setId(PaperId);
		paper.setState(state);
		int Rows=sqlSession.update("com.model.Paper.changeState", paper);
		//判断是否执行成功
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
	}
	public static boolean deletePaper(Integer id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.update("com.model.Schoose.deleteSchoose", id);
		//判断是否执行成功
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
	}
}
