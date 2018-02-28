package com.atmlocator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.atmlocator.domain.AtmDetails;
import com.atmlocator.services.AtmLocatorService;

/**
 * @author Soumit Mandal
 * 
 *         This is the Controller class for the application.Accepts the URL from
 *         the client (/all-atms).Returns a ResponseEntity list of AtmDetails
 */
@Controller
@CrossOrigin(origins = { "http://localhost:4200" })
public class AtmLocatorController {

	@Autowired
	private AtmLocatorService atmLocatorService;

	@GetMapping("all-atms")
	public ResponseEntity<AtmDetails[]> getAllAtmsList() {

		System.out.println("*** Inside method AtmLocatorController.getAllAtmsList() ***");

		AtmDetails[] atmList = atmLocatorService.getAllAtms();
		return new ResponseEntity<AtmDetails[]>(atmList, HttpStatus.OK);
	}

}
