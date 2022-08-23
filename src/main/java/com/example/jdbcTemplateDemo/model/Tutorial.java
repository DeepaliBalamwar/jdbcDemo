package com.example.jdbcTemplateDemo.model;

public class Tutorial {

	 private long id;
	  private String title;
	  private String description;
	  private String published;
	  
	  public Tutorial(long id,String title, String description, String published) {
	    this.id=id;
		  this.title = title;
	    this.description = description;
	    this.published = published;
	  }

	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}
	  
}
