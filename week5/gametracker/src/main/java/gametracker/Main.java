package gametracker;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 7/12/16.
 */
public class Main {
    public static final String SESSION_USERNAME = "userName";
    static Map<String, User> users = new HashMap<>();


    public static void main(String[] args) {
        Spark.init();

        Spark.get("/", (request, response) -> {
            Session session = request.session();
            String name = session.attribute(SESSION_USERNAME);
            User user = users.get(name);

            HashMap templateData = new HashMap();
            ModelAndView rval;
            if(user == null){
                rval = new ModelAndView(templateData, "login.html");
            }
            else{
                templateData.put("user", user);
                rval = new ModelAndView(templateData, "home.html");
            }
            return rval;
        }, new MustacheTemplateEngine());

        Spark.post("/login", (request, response) -> {
            String name = request.queryParams("loginName");
            User user = users.get(name);

            if(user == null){
                user = new User(name);
                users.put(name, user);
            }

            Session session = request.session();
            session.attribute(SESSION_USERNAME, name);

            response.redirect("/");
            return "";
        });

        Spark.post("/logout", (request, response) -> {
            request.session().invalidate();
            response.redirect("/");
            return "";
        });

        Spark.post("/create-game", (request, response) -> {
            Session session = request.session();
            String name = session.attribute(SESSION_USERNAME);
            User user = users.get(name);
            if(user == null){
                response.redirect("/");
                return "";
            }

            String gameName = request.queryParams("gameName");
            String gameGenre = request.queryParams("gameGenre");
            String gamePlatform = request.queryParams("gamePlatform");
            int gameYear = Integer.valueOf(request.queryParams("gameYear"));
            Game game = new Game(gameName, gameGenre, gamePlatform, gameYear);

            user.addGame(game);

            response.redirect("/");
            return "";
        });
    }
}
