package com.dz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dz.mybatis.dao.IPersonDao;
import com.dz.mybatis.entity.Person;

public class Test2 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IPersonDao personDao = session.getMapper(IPersonDao.class);
			Person p = personDao.selectPersonByID(1);
			System.out.println(p);
			//List<Person> list = personDao.selectAllPersonMap();
			List<Person> list = personDao.selectAllPersonType();
			System.out.println(list);
		} finally {
			session.close();
		}
	}
}
