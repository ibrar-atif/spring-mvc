package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PersonDao;
import com.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	
	@Autowired
	PersonDao personDao;
	@Override
	public Person getPerson(int id) {
		
		return personDao.getPerson(id);
	}

}
