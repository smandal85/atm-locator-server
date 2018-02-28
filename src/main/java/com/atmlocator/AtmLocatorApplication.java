package com.atmlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Soumit Mandal
 * 
 *         This is the application starting point. It uses Spring Boot’s
 *         SpringApplication.run() method to launch an application
 * 
 */
@SpringBootApplication
public class AtmLocatorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AtmLocatorApplication.class);
	}

	public static void main(String[] args) throws Exception {

		System.out.println("*** Inside main method ***");

		SpringApplication.run(AtmLocatorApplication.class, args);
	}

}
