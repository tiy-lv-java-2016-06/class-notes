package com.theironyard.controllers;

import com.theironyard.entities.GithubUser;
import com.theironyard.services.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeff on 7/25/16.
 */
@Controller
public class GithubApiDemoController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GithubService githubService;

    @RequestMapping(path = "/users/{username}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable String username){
        GithubUser user = githubService.getByUsername(username);
        model.addAttribute("githubUser", user);
        model.addAttribute("followers", githubService.getFollowers(user));

        return "home";
    }
}
