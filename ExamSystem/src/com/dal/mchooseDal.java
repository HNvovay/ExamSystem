package com.dal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.common.MybatisUtils;
import com.model.Mchoose;
import com.model.Schoose;

public class mchooseDal {
	public static boolean addMchoose(Mchoose mchoose) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.insert("com.model.Mchoose.addMchoose", mchoose);
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
		
	}
	public static Mchoose findById(int id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Mchoose mchoose=sqlSession.selectOne("com.model.Mchoose.findById", id);
		sqlSession.close();
		return mchoose;
	}
	public static List<Mchoose> getList(){
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Mchoose> list=sqlSession.selectList("com.model.Mchoose.getList");
		sqlSession.close();
		return list;
	}
	public static boolean updateMchoose(Mchoose mchoose) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.update("com.model.Mchoose.updateMchoose", mchoose);
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
	public static List<Mchoose> findMchooseByQuestionText(String questionText) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Mchoose> list=sqlSession.selectList("com.model.Mchoose.findMchooseByQuestionText",questionText);
		sqlSession.close();
		return list;
	}
	public static boolean deleteMchoose(Integer id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.update("com.model.Mchoose.deleteMchoose", id);
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
	public static List<Mchoose> selectRandomMchoose(String type){
		List<Mchoose> list = null;
		switch (type) {
		case "A":
			SqlSession sqlSession=MybatisUtils.getSession();
			list=sqlSession.selectList("com.model.Mchoose.addMchoosePaperA");
			sqlSession.close();
		break;
		case "B":
			SqlSession sqlSession1=MybatisUtils.getSession();
			list=sqlSession1.selectList("com.model.Mchoose.addMchoosePaperB");
			sqlSession1.close();
		break;
		case "C":
			SqlSession sqlSession2=MybatisUtils.getSession();
			list=sqlSession2.selectList("com.model.Mchoose.addMchoosePaperC");
			sqlSession2.close();
		break;
		}
		return list;
	}
	public static List<Mchoose> findByIds(List<Integer> ids) {
		SqlSession session = MybatisUtils.getSession();
		List<Mchoose> list = session.selectList("com.model.Mchoose.findByIds",
				ids);
		session.close();
		return list;
	}
}
