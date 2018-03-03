package com.dao;

import org.springframework.stereotype.Repository;

import com.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao{

	@Override
	public Person getPerson(int id) {
		Person p = new Person();
		p.setAge("12");
		p.setCity("mumbai");
		p.setName("xyz");
		return p;
	}

}
