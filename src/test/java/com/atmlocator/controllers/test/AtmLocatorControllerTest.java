package com.atmlocator.controllers.test;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.atmlocator.AtmLocatorApplication;
import com.atmlocator.controllers.AtmLocatorController;
import com.atmlocator.domain.Address;
import com.atmlocator.domain.AtmDetails;
import com.atmlocator.domain.GeoLocation;
import com.atmlocator.services.AtmLocatorService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AtmLocatorApplication.class)
@WebAppConfiguration
public class AtmLocatorControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private AtmLocatorController atmLocatorController;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Mock
	private AtmLocatorService atmLocatorService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(atmLocatorController).build();
	}

	@Test
	public void test_get_all_success() throws Exception {

		GeoLocation geoLocation1 = new GeoLocation("52.36139", "4.939421");
		Address address1 = new Address("Insulindeweg", "478", "1094 MH", "Amsterdam", geoLocation1);
		AtmDetails atmDetails1 = new AtmDetails(address1, 0, "ING");

		GeoLocation geoLocation2 = new GeoLocation("52.185824", "5.399119");
		Address address2 = new Address("De Beurs", "1", "3823 GA", "Amersfoort", geoLocation2);
		AtmDetails atmDetails2 = new AtmDetails(address2, 0, "ING");

		AtmDetails[] atmDetailsList = new AtmDetails[] { atmDetails1, atmDetails2 };

		Mockito.when(atmLocatorService.getAllAtms()).thenReturn(atmDetailsList);

		mockMvc.perform(get("/all-atms"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(2)));
	}
}
