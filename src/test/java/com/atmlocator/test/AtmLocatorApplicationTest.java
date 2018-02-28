package com.atmlocator.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atmlocator.controllers.AtmLocatorController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmLocatorApplicationTest {

	@Autowired
	private AtmLocatorController atmLocatorController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(atmLocatorController).isNotNull();
    }

}
