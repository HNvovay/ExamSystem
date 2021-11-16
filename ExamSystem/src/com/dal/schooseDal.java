package com.dal;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.common.MybatisUtils;
import com.model.Mchoose;
import com.model.Schoose;

public class schooseDal {
	public static boolean addSchoose(Schoose schoose) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.insert("com.model.Schoose.addSchoose", schoose);
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
		
	}
	public static List<Schoose> getList(){
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Schoose> list=sqlSession.selectList("com.model.Schoose.getList");
		sqlSession.close();
		return list;
	}
	
	public static Schoose findById(int id) {
		SqlSession sqlSession=MybatisUtils.getSession();
		Schoose schoose=sqlSession.selectOne("com.model.Schoose.findById", id);
		sqlSession.close();
		return schoose;
	}
	public static List<Schoose> findSchooseByQuestionText(String questionText) {
		SqlSession sqlSession=MybatisUtils.getSession();
		List<Schoose> list=sqlSession.selectList("com.model.Schoose.findSchooseByQuestionText",questionText);
		sqlSession.close();
		return list;
	}
	public static boolean updateSchoose(Schoose schoose) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.update("com.model.Schoose.updateSchoose", schoose);
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
	public static boolean deleteSchoose(Integer id) {
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
	public static List<Schoose> selectRandomSchoose(String type){
		List<Schoose> list = null;
		switch (type) {
		case "A":
			SqlSession sqlSession=MybatisUtils.getSession();
			list=sqlSession.selectList("com.model.Schoose.addSchoosePaperA");
			sqlSession.close();
		break;
		case "B":
			SqlSession sqlSession1=MybatisUtils.getSession();
			list=sqlSession1.selectList("com.model.Schoose.addSchoosePaperB");
			sqlSession1.close();
		break;
		case "C":
			SqlSession sqlSession2=MybatisUtils.getSession();
			list=sqlSession2.selectList("com.model.Schoose.addSchoosePaperC");
			sqlSession2.close();
		break;
		}
		return list;
	}
	public static List<Schoose> findByIds(List<Integer> ids) {
		SqlSession session = MybatisUtils.getSession();
		List<Schoose> list = session.selectList("com.model.Schoose.findByIds",
				ids);
		session.close();
		return list;
	}
}
