package com.gdu.ex.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gdu.ex.domain.ExDto;

public class ExDao {
	
	// 필드
	private SqlSessionFactory factory;
	
	// Singleton Pattern
	private static ExDao dao = new ExDao();
	private ExDao() {
		try {
			String resource = "com/gdu/ex/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static ExDao getInstance() {
		return dao;
	}
	
	/*
	 	SqlSession이란?
	 	MyBatis에서 사용하는 인터페이스
	 	mapper에 있는 쿼리문을 읽어서 실행하는 객체
	*/
	
	// 메소드 1개가 쿼리문 1개를 실행한다.
	
	private final String NS = "com.gdu.ex.repository.ex.";
	public List<ExDto> list(){
		
		SqlSession ss = factory.openSession();
		List<ExDto> result = ss.selectList(NS + "list");
		return result;

		/*
		ss.selectList(); : SELECT 결과 행이 2개 이상일 때 사용한다.
		ss.selectOne();	 : SELECT 결과 행이 1개일 때 사용한다.
		ss.insert();	 : INSERT 실행할 때 사용한다.
		ss.update();	 : UPDATE
		ss.delete();	 : DELETE
		ss.close();
		*/
	}
	
	public ExDto detail(int exNo) {
		
		SqlSession ss = factory.openSession();
		ExDto result = ss.selectOne(NS + "detail", exNo);
		ss.close();
		return result;
	}
	
}
