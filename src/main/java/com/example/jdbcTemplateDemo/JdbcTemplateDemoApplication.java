package com.example.jdbcTemplateDemo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateDemoApplication {
	private static Logger logger=Logger.getLogger("JdbcTemplateDemoApplication.class");
	public static void main(String[] args) {
		logger.info("1st logger ");
		logger.info("main program");
		logger.info("Jdbc tmplate");
		logger.warning("last logger");
		SpringApplication.run(JdbcTemplateDemoApplication.class, args);
		System.out.println("Hello");
	}

}
