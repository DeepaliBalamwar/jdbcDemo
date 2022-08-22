package com.example.jdbcTemplateDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcTemplateDemo.model.Tutorial;
import com.example.jdbcTemplateDemo.repository.JdbcTutorialRepositoryImpl;
import com.example.jdbcTemplateDemo.repository.TutorialRepository;
import com.example.jdbcTemplateDemo.service.Tutorialservice;

@CrossOrigin(origins = "http://localhost:8081" )
@RestController
@RequestMapping("/api")
public class TutorialController 
{
  @Autowired
  private JdbcTutorialRepositoryImpl tutorialRepositoryImpl;
  
//  @GetMapping("/tutorials")
//  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title)
//  {
//	  try 
//	  {
//		List<Tutorial> tutorials=new ArrayList<Tutorial>();
//		if(title==null)
//		{
//			employeeServiceImpl.findAll().forEach(tutorials::add);
//		}
//		else
//		{
//			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		 return new ResponseEntity<>(tutorials, HttpStatus.OK);
//	  }
//	  catch (Exception e) 
//	  {
//		  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	  }
//  }
  
  @PutMapping("/tutorials/{id}")
//   public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id)
//   {
////	  Tutorial tutorials = employeeServiceImpl.findById(id);
////	    if (tutorials != null) 
////	    {
////	     return new ResponseEntity<>(tutorials, HttpStatus.OK);
////	    } 
////	    else 
////	    {
////	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////	    }
//   }
  
//  @GetMapping("/tutorials/{id}")
//  public ResponseEntity<List<Tutorial>> getTutorialById(@PathVariable("id") long id) {
//	    List<Tutorial> tutorial = employeeServiceImpl.findById(id);
//	    if (tutorial != null) {
//	      return new ResponseEntity<>(tutorial, HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }	
  
  @PostMapping("/tutorials")
  public ResponseEntity<String> createTutorial(@RequestBody Tutorial tutorial) {
    try {
      tutorialRepositoryImpl.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
      return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
