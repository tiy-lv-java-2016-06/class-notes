import com.sun.org.apache.xpath.internal.operations.Mod;
import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jeff on 7/11/16.
 */
public class Main {

    static User user;

    public static void main(String[] args) {
        Spark.init();

        Spark.get("/", (request, response) -> {
            HashMap m = new HashMap();
            ArrayList<Food> food = new ArrayList<>();
            food.add(new Food("Pizza"));
            food.add(new Food("Burgers"));
            food.add(new Food("Hot Dogs"));
            food.add(new Food("Slurpies"));
            m.put("food", food);

            if(user != null) {
                m.put("user", user);
            }
            return new ModelAndView(m, "home.html");
        }, new MustacheTemplateEngine());

        Spark.get("/login", ((request, response) -> {
            HashMap m = new HashMap();
            return new ModelAndView(m, "login.html");
        }), new MustacheTemplateEngine());

        Spark.post("/login", (request, response) -> {
            String name = request.queryParams("loginName");
            user = new User(name);
            response.redirect("/");
            return "";
        });
    }
}
