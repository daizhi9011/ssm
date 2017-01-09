package com.dz.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dz.mybatis.dao.IPersonDao;
import com.dz.mybatis.entity.Person;
import com.mysql.jdbc.Connection;

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
			//System.out.println(p);
			//List<Person> list = personDao.selectAllPersonMap();
			//List<Person> list = personDao.selectAllPersonType();
			//List<Person> list = personDao.selectAllPersonAnnotation();
			//System.out.println(list);
			//Map<String, Object> map = personDao.selectPersonById(1);
			//System.out.println(map.get("name"));
			//Person p1 = new Person();
			//p1.setName("David");
			//p1.setAge(25);
			//p1.setAddress("China");
			//boolean b = personDao.insertDB(p1);
			//注意当插入或者修改或者删除时一定要提交
//			Person p2 =new Person();
//			p2.setName("Peter");
//			p2.setId(10);
//			personDao.updateDB(p2);
//			personDao.deleteDB(3);
//			session.commit();
			
		} finally {
			session.close();
		}
	}
}
