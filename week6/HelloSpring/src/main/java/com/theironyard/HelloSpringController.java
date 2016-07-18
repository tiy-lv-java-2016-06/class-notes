package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jeff on 7/18/16.
 */
@Controller
public class HelloSpringController {

    public static final String SESSION_USERNAME = "userName";

    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public String person(Model model, String name, String city, @RequestParam(defaultValue = "18") int age){
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        return "personage";

    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        String userName = (String) session.getAttribute(SESSION_USERNAME);
        model.addAttribute("name", userName);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName){
        session.setAttribute(SESSION_USERNAME, userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();
        response.sendRedirect("/");
        return "";
    }
}
