package com.atmlocator.services;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atmlocator.domain.AtmDetails;

/**
 * @author Soumit Mandal
 * 
 *         This class will query the REST API for retrieving list of ATMs and
 *         return result to the Controller
 */
@Service
@PropertySource("classpath:config.properties")
public class AtmLocatorService implements AtmLocatorServiceInterface {

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private Environment env;

	public AtmDetails[] getAllAtms() {

		System.out.println("*** Inside method AtmLocatorService.getAllAtms() ***");

		String getAtmUrl = env.getProperty("ing.atm.url");

		System.out.println("*** Print getAtmUrl =" + getAtmUrl);

		AtmDetails[] details = restTemplate.getForObject(getAtmUrl, AtmDetails[].class);
		return details;
	}

}
