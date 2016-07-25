package com.theironyard.services;

import com.theironyard.entities.GithubUser;
import com.theironyard.exceptions.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeff on 7/25/16.
 */
@Service
public class GithubService {

    @Autowired
    RestTemplate restTemplate;

    public static final String BASE_URL = "https://api.github.com/users/";

    public GithubUser getByUsername(String username){

        GithubUser user;
        try{
            user = restTemplate.getForObject(BASE_URL+username, GithubUser.class);
        }
        catch (RestClientException e){
            throw new UsernameNotFoundException();
        }

        return user;
    }

    public List<GithubUser> getFollowers(GithubUser user){
        List<GithubUser> users = restTemplate.getForObject(user.getFollowersUrl(), ArrayList.class);

        return users;
    }

}
