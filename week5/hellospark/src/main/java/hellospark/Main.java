package hellospark;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 7/11/16.
 */
public class Main {

    public static final String SESSION_USER_NAME = "userName";
    static Map<String, User> users = new HashMap<>();


    public static void main(String[] args) {
        Spark.init();

        Spark.get("/", (request, response) -> {
            HashMap m = new HashMap();

            String userName = request.session().attribute(SESSION_USER_NAME);

            if(userName != null && users.containsKey(userName)) {
                m.put("user", users.get(userName));
            }
            return new ModelAndView(m, "home.html");
        }, new MustacheTemplateEngine());

        Spark.get("/login", ((request, response) -> {
            HashMap m = new HashMap();
            return new ModelAndView(m, "login.html");
        }), new MustacheTemplateEngine());

        Spark.post("/login", (request, response) -> {
            String name = request.queryParams("loginName");

            User user = null;
            if(users.containsKey(name)){
                user = users.get(name);
            }
            else{
                user = new User(name);
            }
            request.session().attribute(SESSION_USER_NAME, user.getName());
            users.put(user.getName(), user);

            response.redirect("/");
            return "";
        });

        Spark.post("/logout", (request, response) -> {
            request.session().invalidate();
            response.redirect("/");
            return "";
        });
    }
}
