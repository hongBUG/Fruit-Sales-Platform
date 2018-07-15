package com.xu.test.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBConnectionTest {
	//MyBatis配置文件
	private String resource = "beans.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;
	
	@Test
	public void testConnection() throws Exception {
		// 获取Sping类加载配置对象
		System.out.println("hello");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);
		System.out.println(context);
		// 从配置对象中创建会话工厂， 并注入MyBatis配置文件的信息
		sqlSessionFactory = (SqlSessionFactory) context.getBean("sessionFactory");
		sqlSession = sqlSessionFactory.openSession();
		if (sqlSession != null) {
			System.out.println("数据库连接成功， 目前SQL配置数目：");
			System.out.println(sqlSession.getConfiguration().getMappedStatements().size());
		} else {
			System.out.println("数据库连接失败！");
		}
		
	}
}
