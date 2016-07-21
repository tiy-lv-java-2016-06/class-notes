package com.theironyard.controllers;

import com.theironyard.entities.Game;
import com.theironyard.entities.User;
import com.theironyard.repositories.GameRepository;
import com.theironyard.repositories.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jeff on 7/19/16.
 */
@Controller
public class GameTrackerController {

    @Autowired
    GameRepository games;

    @Autowired
    UserRepository users;

    @PostConstruct
    public void init(){
        if(games.count() < 1){
            File gameFile = new File("Videogames.csv");
            Scanner scanner;
            try {
                scanner = new Scanner(gameFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }

            scanner.nextLine();
            while(scanner.hasNextLine()){
                String[] lineSplit = scanner.nextLine().split(",");
                Integer year;
                try{
                    year = Integer.parseInt(lineSplit[1]);
                }
                catch (NumberFormatException e){
                    continue;
                }

                Game game = new Game(lineSplit[0], "pc", "generic",
                        year, users.findOne(5));

                games.save(game);
            }

        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session, String genre, Integer releaseYear,
                       String search, @RequestParam(defaultValue = "0") int page){
        User user = getUserFromSession(session);
        if(user != null){
            model.addAttribute("user", user);
        }

        List<Game> gameList = null;
        PageRequest pr = new PageRequest(page, 10, Sort.Direction.DESC, "name");

        if(search != null){
            gameList = games.findByNameStartingWithIgnoreCase(search);
        }
        else if(genre != null){
             model.addAttribute("pageResult", games.findByGenre(pr, genre));
        }
        else if(releaseYear != null){
            gameList = games.findByReleaseYearOrderByNameDesc(releaseYear);
        }
        else {
            Page<Game> pageResult = games.findAll(pr);
            model.addAttribute("pageResult", pageResult);
        }
        model.addAttribute("nextPage", page+1);
        model.addAttribute("prevPage", page-1);
        model.addAttribute("games", gameList);
        return "home";
    }

    @RequestMapping(path = "/add-game", method = RequestMethod.POST)
    public String addGame(HttpSession session, String gameName, String gamePlatform, String gameGenre, int gameYear) throws Exception {
        User user = getUserFromSession(session);
        if(user == null){
            throw new Exception("Not allowed");
        }

        Game game = new Game(gameName, gamePlatform, gameGenre, gameYear, user);
        games.save(game);
        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = users.findFirstByName(userName);
        if(user == null){
            user = new User(userName, PasswordStorage.createHash(password));
            users.save(user);
        }
        else if(!PasswordStorage.verifyPassword(password, user.getPassword())){
            throw new Exception("Incorrect Password you slimy hacker");
        }
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    public User getUserFromSession(HttpSession session){
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);

        return user;
    }

}
