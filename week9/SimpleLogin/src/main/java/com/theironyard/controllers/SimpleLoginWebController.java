package com.theironyard.controllers;

import com.stripe.exception.*;
import com.stripe.model.Charge;
import com.theironyard.entities.User;
import com.theironyard.exceptions.LoginFailedException;
import com.theironyard.exceptions.NotLoggedIn;
import com.theironyard.exceptions.UserNotFoundException;
import com.theironyard.services.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 8/10/16.
 */
@Controller
@RequestMapping("/web")
public class SimpleLoginWebController {

    public static final String SESSION_USERNAME = "username";

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        User user = userRepository.findFirstByUsername((String)session.getAttribute(SESSION_USERNAME));
        if(user != null) {
            model.addAttribute("user", user);
        }
        return "home";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) throws PasswordStorage.InvalidHashException, PasswordStorage.CannotPerformOperationException {
        User user = userRepository.findFirstByUsername(username);

        if(user == null){
            user = new User(username, PasswordStorage.createHash(password));
            userRepository.save(user);
        }

        if(!PasswordStorage.verifyPassword(password, user.getPassword())){
            throw new LoginFailedException();
        }

        session.setAttribute(SESSION_USERNAME, username);

        return "redirect:/web";
    }

    @RequestMapping(path = "/pay", method = RequestMethod.POST)
    public String pay(HttpSession session, String stripeToken) throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        User user = userRepository.findFirstByUsername((String)session.getAttribute(SESSION_USERNAME));


        if(user == null){
            throw new NotLoggedIn();
        }

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", 2000);
        chargeParams.put("currency", "usd");
        chargeParams.put("source", stripeToken);
        chargeParams.put("description", "Charge for the privilege of using our site");

        Charge.create(chargeParams);
        user.setPaid(true);
        userRepository.save(user);

        return "home";
    }

}
