package com.example.jdbcTemplateDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcTemplateDemo.model.Tutorial;
import com.example.jdbcTemplateDemo.repository.TutorialRepository;

//@CrossOrigin(origins = "http://localhost:8081" )
@RestController
@RequestMapping("/api")
public class TutorialController 
{
	@Autowired
	private TutorialRepository repo;

  public TutorialController()
  {
	  System.out.println("This is Tutorial Controller");
  }
  
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
  
//  @PutMapping("/tutorials/{id}")
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
  
  @PostMapping("/add")
  public ResponseEntity<String> createTutorial(@RequestBody Tutorial tutorial) {
    try {
    	System.out.println("hello");
      System.out.println("Controller");
      repo.save(new  Tutorial(tutorial.getId(),tutorial.getTitle(), tutorial.getDescription(),tutorial.getPublished()));
      return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
