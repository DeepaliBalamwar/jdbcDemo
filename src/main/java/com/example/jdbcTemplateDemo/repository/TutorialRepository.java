package com.example.jdbcTemplateDemo.repository;

import java.util.List;

import com.example.jdbcTemplateDemo.model.Tutorial;

public interface TutorialRepository
{
    public int save(Tutorial book);
	int update(Tutorial book);
	Tutorial findById(long id);
	List<Tutorial>findAll();
	public int deleteById(int id);
	public int deleteAll();
}
