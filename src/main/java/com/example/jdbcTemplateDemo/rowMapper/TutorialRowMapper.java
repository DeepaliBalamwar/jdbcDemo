package com.example.jdbcTemplateDemo.rowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.TreePath;
import org.springframework.jdbc.core.RowMapper;

import com.example.jdbcTemplateDemo.model.Tutorial;

public class TutorialRowMapper implements RowMapper
{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tutorial tutorial=new Tutorial();
		tutorial.setId(rs.getInt("Tutorial_ID"));
		tutorial.setTitle(rs.getString("Tutorial_Title"));
		tutorial.setDescription(rs.getString("Tutorial_Description"));
		tutorial.setPublished(true);

		return tutorial;
	}
  
	
}
