package com.example.jdbcTemplateDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.jdbcTemplateDemo.model.Tutorial;
import com.example.jdbcTemplateDemo.repository.TutorialRepository;
import com.example.jdbcTemplateDemo.rowMapper.TutorialRowMapper;

@Service
public class Tutorialservice implements TutorialRepository
{
	@Autowired
	private	JdbcTemplate jdbcTemplate;
	
	public Tutorialservice(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate=jdbcTemplate;
	}

	@Override
	public int save(Tutorial book) 
	{
		return jdbcTemplate.update("INSERT INTO tutorials (id,title, description, published) VALUES(?,?,?,?)",
				new Object[] {book.getId() ,book.getTitle(), book.getDescription(), book.isPublished() });
	}

	@Override
	public int update(Tutorial book) 
	{
		return jdbcTemplate.update("UPDATE tutorials SET title=?, description=?, published=? where id=?",
				new Object[] {book.getTitle(), book.getDescription(), book.isPublished(),book.getId()});
	}

	@Override
	public Tutorial findById(long id) 
	{
		Tutorial book = jdbcTemplate.queryForObject("SELECT * FROM tutorials WHERE id=?",new TutorialRowMapper(), id);
		return book;
	}

	@Override
	public List<Tutorial> findAll() 
	{
	    return jdbcTemplate.query("SELECT * from tutorials", new TutorialRowMapper());
	}

	@Override
	public int deleteById(int id) 
	{
	    return jdbcTemplate.update("DELETE FROM tutorials WHERE id=?", id);
	}

	@Override
	public int deleteAll() 
	{
	    return jdbcTemplate.update("DELETE from tutorials");
	}
}
