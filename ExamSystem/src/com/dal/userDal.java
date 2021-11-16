package com.dal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.common.*;
import com.model.Schoose;
import com.model.User;

public class userDal {
	public static User login(User user) {
		SqlSession sqlSession=MybatisUtils.getSession();
		User user1=sqlSession.selectOne("com.model.User.login", user);
		if(user1!=null) {
			sqlSession.close();
			return user1;
		}else {
			sqlSession.close();
			return null;
		}
		
	}
	public static boolean updatePassword(User user) {
		SqlSession sqlSession=MybatisUtils.getSession();
		int Rows=sqlSession.update("com.model.User.updatePassword", user);
		if(Rows>0) {
			sqlSession.commit();
			sqlSession.close();
			return true;
		}else {
			sqlSession.close();
			return false;
		}
		
	}
	public static List<User> getListStudent(){
		SqlSession sqlSession=MybatisUtils.getSession();
		User user=new User();
		user.setRole(1);
		List<User> list=sqlSession.selectList("com.model.User.getListStudent",user);
		sqlSession.close();
		return list;
	}
}

