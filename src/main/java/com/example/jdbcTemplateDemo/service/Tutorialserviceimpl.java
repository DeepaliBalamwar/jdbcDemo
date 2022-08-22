package com.example.jdbcTemplateDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.jdbcTemplateDemo.model.Tutorial;

@Service
public class Tutorialservice {

	@Autowired
private	JdbcTemplate jdbcTemplate;
	
	public void save(Tutorial tutorial)
	{
		jdbcTemplate.update("INSERT INTO tutorials (title, description, published) VALUES(?,?,?)",
				new Object[] { tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished() });
	}
}
