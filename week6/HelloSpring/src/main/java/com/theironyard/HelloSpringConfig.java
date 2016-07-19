package com.theironyard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 7/19/16.
 */
@Configuration
public class HelloSpringConfig {

    @Bean
    public Map<String, Person> people(){
        Map<String, Person> people = new HashMap<>();
        people.put("Sally", new Person("sally", "henderson", 21));
        return people;
    }

    @Bean
    public Person bob(){
        return new Person("Bob", "Las Vegas", 21);
    }
}
