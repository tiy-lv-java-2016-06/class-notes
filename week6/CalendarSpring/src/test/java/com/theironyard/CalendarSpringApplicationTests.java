package com.theironyard;

import com.theironyard.controllers.CalendarSpringController;
import com.theironyard.services.EventRepository;
import com.theironyard.services.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertTrue;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CalendarSpringApplication.class)
@WebAppConfiguration
public class CalendarSpringApplicationTests {

	@Autowired
	WebApplicationContext wap;

	@Autowired
	EventRepository events;

	@Autowired
	UserRepository users;

	MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}

	@Test
	public void testLogin() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/login")
				.param("name", "TestUser")
		).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

		assertTrue(users.count() == 1);
	}

	@Test
	public void testCreateEvent() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/create-event")
				.param("description", "Test Event")
				.param("dateTime", LocalDateTime.now().toString())
				.sessionAttr(CalendarSpringController.SESSION_USERNAME, "TestUser")
		);

		assertTrue(events.count() == 1);
	}


}
