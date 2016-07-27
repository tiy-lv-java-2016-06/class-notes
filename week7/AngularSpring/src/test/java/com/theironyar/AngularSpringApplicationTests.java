package com.theironyar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyar.entities.User;
import com.theironyar.services.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AngularSpringApplication.class)
@WebAppConfiguration
public class AngularSpringApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	WebApplicationContext wap;

	MockMvc mockMvc;

	@Before
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}

	@Test
    public void addUser() throws Exception {
	    User user = new User();
        user.setUsername("Alice");
        user.setAddress("7 Hearts Ave");
        user.setEmail("alice@wonderland.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                .content(json)
                .contentType("application/json")
        );

        assertTrue(userRepository.count() == 1);
    }

    @Test
    public void deleteUser() throws Exception {
        User user = new User();
        user.setUsername("Alice");
        user.setAddress("7 Hearts Ave");
        user.setEmail("alice@wonderland.com");
        userRepository.save(user);

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/user/" + user.getId())
        );

        assertFalse(userRepository.exists(user.getId()));

    }

}
