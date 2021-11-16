package com.dal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.common.MybatisUtils;
import com.model.Judge;
import com.model.Mchoose;
import com.model.Schoose;

public class judgeDal {
	public static boolean addJudge(Judge judge) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.insert("com.model.Judge.addJudge", judge);
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
		
	}
	public static List<Judge> getList(){
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Judge> list=sqlSession.selectList("com.model.Judge.getList");
		sqlSession.close();
		return list;
	}
	public static List<Judge> findJudgeByQuestionText(String questionText) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Judge> list=sqlSession.selectList("com.model.Judge.findJudgeByQuestionText",questionText);
		sqlSession.close();
		return list;
	}
	public static boolean updateJudge(Judge judge) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.update("com.model.Judge.updateJudge", judge);
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
	public static Judge findById(int id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Judge judge=sqlSession.selectOne("com.model.Judge.findById", id);
		sqlSession.close();
		return judge;
	}
	public static boolean deleteJudge(Integer id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.update("com.model.Judge.deleteJudge", id);
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
	public static List<Judge> selectRandomJudge(String type){
		List<Judge> list = null;
		switch (type) {
		case "A":
			SqlSession sqlSession=MybatisUtils.getSession();
			list=sqlSession.selectList("com.model.Judge.addJudgePaperA");
			sqlSession.close();
		break;
		case "B":
			SqlSession sqlSession1=MybatisUtils.getSession();
			list=sqlSession1.selectList("com.model.Judge.addJudgePaperB");
			sqlSession1.close();
		break;
		case "C":
			SqlSession sqlSession2=MybatisUtils.getSession();
			list=sqlSession2.selectList("com.model.Judge.addJudgePaperC");
			sqlSession2.close();
		break;
		}
		return list;
	}
	public static List<Judge> findByIds(List<Integer> ids) {
		SqlSession session = MybatisUtils.getSession();
		List<Judge> list = session.selectList("com.model.Judge.findByIds",
				ids);
		session.close();
		return list;
	}
}
