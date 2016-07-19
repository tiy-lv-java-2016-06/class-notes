package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by jeff on 7/18/16.
 */
@RestController
public class HelloSpringJsonController {

//    @Autowired
//    public Map<String, Person> people;

    @RequestMapping(path = "/person.json", method = RequestMethod.GET)
    public Person jsonPerson(String name, String city, int age){
        Person p = new Person(name, city, age);
//        people.put(p.getName(), p);
        return p;
    }
}
