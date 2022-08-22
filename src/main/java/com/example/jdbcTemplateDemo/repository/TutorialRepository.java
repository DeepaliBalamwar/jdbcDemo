package com.example.jdbcTemplateDemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jdbcTemplateDemo.model.Tutorial;


public interface TutorialRepository{
    public void save(Tutorial book);
//   int update(Tutorial book);
//   Tutorial findById(long id);
//   List<Tutorial>findAll();
}
