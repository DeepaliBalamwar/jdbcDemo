package com.example.jdbcTemplateDemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jdbcTemplateDemo.model.Tutorial;
import com.example.jdbcTemplateDemo.service.Tutorialservice;

@Repository
public class JdbcTutorialRepositoryImpl implements TutorialRepository 
{  
	@Autowired
	private Tutorialservice tutorialservice;
	
	public void save(Tutorial tutorial)
	{
		 this.tutorialservice.save(tutorial);
		
	}
	
//	public Tutorial findById(long id)
//	{
//		try 
//		{
//			Tutorial tutorial=jdbcTemplate.queryForObject("Select * from tutorials where id=?", 
//					BeanPropertyRowMapper.newInstance(Tutorial.class),id);
//			return tutorial;
//		} 
//		catch (IncorrectResultSizeDataAccessException e) 
//		{
//			return null;
//		}
//		
//	}
//	
//	public int update(Tutorial tutorial)
//	{
//		return jdbcTemplate.update("update tutorials title=?,description=?,published=? where id=?",
//				new Object[] {tutorial.getTitle(),tutorial.getDescription(),tutorial.isPublished()});
//	}
//	
//	
//	public List<Tutorial> findAll()
//	{
//		return jdbcTemplate.query("Select * from tutorials",BeanPropertyRowMapper.newInstance(Tutorial.class));
//	}
}
