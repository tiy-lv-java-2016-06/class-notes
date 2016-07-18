package com.theironyard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeff on 7/18/16.
 */
@RestController
public class HelloSpringJsonController {

    @RequestMapping(path = "/person.json", method = RequestMethod.GET)
    public Person jsonPerson(String name, String city, int age){
        return new Person(name, city, age);
    }
}
