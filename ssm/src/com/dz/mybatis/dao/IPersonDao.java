package com.dz.mybatis.dao;

import java.util.List;

import com.dz.mybatis.entity.Person;


public interface IPersonDao {
	public Person selectPersonByID(int id);
	
	public List<Person> selectAllPersonMap();
	public List<Person> selectAllPersonType();
}
