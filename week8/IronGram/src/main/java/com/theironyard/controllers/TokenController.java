package com.theironyard.controllers;

import com.theironyard.command.UserCommand;
import com.theironyard.entities.User;
import com.theironyard.exceptions.LoginFailedException;
import com.theironyard.exceptions.TokenExpiredException;
import com.theironyard.exceptions.UserNotFoundException;
import com.theironyard.services.PhotoRepository;
import com.theironyard.services.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 8/2/16.
 */
@RestController
public class TokenController {

    @Autowired
    UserRepository userRepository;

    public User checkLogin(UserCommand command) throws Exception{
        User user = userRepository.findFirstByName(command.getUsername());
        if(user == null){
            throw new UserNotFoundException();
        }

        if(!PasswordStorage.verifyPassword(command.getPassword(), user.getPassword())){
            throw new LoginFailedException();
        }

        if(!user.isTokenValid()){
            throw new TokenExpiredException();
        }

        return user;
    }

    @RequestMapping(path = "/token", method = RequestMethod.POST)
    public Map getToken(@RequestBody UserCommand command) throws Exception {
        User user = checkLogin(command);

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", user.getToken());
        return tokenMap;
    }

    @RequestMapping(path = "/token/regenerate", method = RequestMethod.PUT)
    public Map regenerateToken(@RequestBody UserCommand command) throws Exception{
        User user = checkLogin(command);
        String token = user.regenerate();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return tokenMap;
    }



}
