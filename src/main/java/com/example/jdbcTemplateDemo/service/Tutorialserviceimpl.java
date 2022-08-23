package com.example.jdbcTemplateDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.jdbcTemplateDemo.model.Tutorial;
import com.example.jdbcTemplateDemo.repository.TutorialRepository;

@Service
public class Tutorialserviceimpl implements TutorialRepository{

	@Autowired
private	JdbcTemplate jdbcTemplate;
	
	public Tutorialserviceimpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public void save(Tutorial tutorial) 
	{
		jdbcTemplate.update("INSERT INTO tutorials ( id,title, description, published) VALUES(?,?,?,?)",
				new Object[] {tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), tutorial.getPublished() });
			
	}
}
