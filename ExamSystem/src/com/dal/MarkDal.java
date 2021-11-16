package com.dal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.common.MybatisUtils;
import com.model.Judge;
import com.model.Mark;
import com.model.Mchoose;
import com.model.Schoose;
import com.model.User;

public class MarkDal {
	public static List<Mark> getList(){
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Mark> list=sqlSession.selectList("com.model.Mark.getList");
		sqlSession.close();
		return list;
	}
	public static boolean addMark(Mark mark) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.insert("com.model.Mark.addMark", mark);
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
		
	}
	public static List<Mark> findByUserName(String username) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Mark> list=sqlSession.selectList("com.model.Mark.findByUserName",username);
		sqlSession.close();
		return list;
	}
	public static List<Mark> findByPaperId(List<Integer> list) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Mark> list1=sqlSession.selectList("com.model.Mark.findByPaperId",list);
		sqlSession.close();
		return list1;
	}
	public static List<Mark> findMarkByQuestionText(String questionText) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Mark> list=sqlSession.selectList("com.model.Mark.findMarkByQuestionText",questionText);
		sqlSession.close();
		return list;
	}
}
