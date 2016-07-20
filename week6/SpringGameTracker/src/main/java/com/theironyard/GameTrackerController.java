package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        if(users.count() < 1){
            users.save(new User("Bob", "password"));
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session, String genre, Integer releaseYear, String search,
                       @RequestParam(defaultValue = "0") int page){
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);
        if (user != null) {
            model.addAttribute("user", user);
        }

        PageRequest pr = new PageRequest(page, 2);
        List<Game> gameList = null;

        if(search != null){
            gameList = games.findByNameStartingWithIgnoreCase(search);
        }
        else if(genre != null){
            gameList = games.findByGenre(genre);
        }
        else if(releaseYear != null){
            gameList = games.findByReleaseYearIsGreaterThanEqual(releaseYear);
        }
        else {
            //gameList = (List) games.findAll();
            Page<Game> pageResult = games.findAll(pr);
            model.addAttribute("page", pageResult);
        }
        model.addAttribute("games", gameList);
        model.addAttribute("nextPage", page+1);
        return "home";
    }

    @RequestMapping(path = "/add-game", method = RequestMethod.POST)
    public String addGame(HttpSession session, String gameName, String gamePlatform, String gameGenre, int gameYear){
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);

        Game game = new Game(gameName, gamePlatform, gameGenre, gameYear, user);
        games.save(game);
        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = users.findFirstByName(userName);
        if (user == null) {
            user = new User(userName, password);
            users.save(user);
        }
        else if (!password.equals(user.getPassword())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
