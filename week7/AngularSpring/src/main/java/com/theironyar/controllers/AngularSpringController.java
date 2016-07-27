package com.theironyar.controllers;

import com.theironyar.entities.User;
import com.theironyar.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by jeff on 7/27/16.
 */
@RestController
@RequestMapping("/user")
public class AngularSpringController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void addUser(HttpServletRequest request, @RequestBody User user){
        userRepository.save(user);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public void editUser(@RequestBody User user){
        userRepository.save(user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userRepository.delete(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        return userRepository.findOne(id);
    }
}
