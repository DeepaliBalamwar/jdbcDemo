package com.example.jdbcTemplateDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcTemplateDemo.model.Tutorial;
import com.example.jdbcTemplateDemo.repository.TutorialRepository;

//@CrossOrigin(origins = "http://localhost:8081" )
@RestController
//@RequestMapping("/api")
public class TutorialController 
{
	@Autowired
	private TutorialRepository repo;
	
  @GetMapping("/getAllTutorials")
  public ResponseEntity<List<Tutorial>> getAllTutorials()
  {
		List<Tutorial> tutorials=new ArrayList<Tutorial>();
		repo.findAll().forEach(tutorials::add);
		return new ResponseEntity<>(tutorials, HttpStatus.OK);
  }
  
  @GetMapping("/getTutorial/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@RequestBody @PathVariable("id") long id) 
  {
	  Tutorial tutorial = repo.findById(id);
	  return new ResponseEntity<>(tutorial, HttpStatus.OK);
  }
  
  @PostMapping("/addTutorial")
  public ResponseEntity<String> createTutorial(@RequestBody Tutorial tutorial) 
  { 
      repo.save(new Tutorial(tutorial.getId() ,tutorial.getTitle(), tutorial.getDescription(), true));
      return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
  }
  
  @PutMapping("/updateTutorial/{id}")
   public ResponseEntity<String> updateTutorial(@PathVariable("id") int id, @RequestBody Tutorial book)
   {
	  Tutorial tutorial = repo.findById(id);
	    if (tutorial != null) 
	    {
	    	tutorial.setId(id);
	    	tutorial.setTitle(book.getTitle());
	    	tutorial.setDescription(book.getDescription());
	    	tutorial.setPublished(book.isPublished());
	    	
	    	repo.update(tutorial);
	    	return new ResponseEntity<>("Tutorial was updated successfully.", HttpStatus.OK);
	    } 
	    else 
	    {
	      return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.NOT_FOUND);
	    }
   }
  
  @DeleteMapping("/deleteTutorial/{id}")
  public ResponseEntity<String> deleteById(@PathVariable("id") int id)
  {
	  repo.deleteById(id);
      return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
  }
  
  @DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllStudents() 
	{
	      int numRows = repo.deleteAll();
	      return new ResponseEntity<>("Deleted " + numRows + " tutorials successfully.", HttpStatus.OK);  
	}
  
}
