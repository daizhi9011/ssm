package com.dz.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.dz.mybatis.entity.Person;


public interface IPersonDao {
	public Person selectPersonByID(int id);
	
	public List<Person> selectAllPersonMap();
	
	public List<Person> selectAllPersonType();
	@Select("select * from person")
	public List<Person> selectAllPersonAnnotation();
	
	public Map<String, Object> selectPersonById(int id);
	
	public boolean insertDB(Person p);
	
	public boolean updateDB(Person p);
	
	public boolean deleteDB(int id);
}
