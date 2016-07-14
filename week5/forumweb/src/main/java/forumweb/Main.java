package forumweb;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by jeff on 7/13/16.
 */
public class Main {
    static Map<String, User> users = new HashMap<>();
    static List<Message> messages = new ArrayList<>();
    public static final String SESSION_USERNAME = "userName";

    public static void main(String[] args) {
        addTestUsers();
        addTestMessages();

        Spark.staticFileLocation("public");
        Spark.init();

        Spark.get("/", (request, response) -> {
            String reply = request.queryParams("replyId");
            int replyId = Message.TOP_LEVELID;
            if(reply != null){
                replyId = Integer.valueOf(reply);
            }

            Map templateData = new HashMap();
            List<Message> threads = new ArrayList<>();
            for(Message message : messages){
                if(message.getReplyId() == replyId){
                    threads.add(message);
                }
            }

            Session session = request.session();
            String userName = session.attribute(SESSION_USERNAME);
            templateData.put("userName", userName);
            templateData.put("messages", threads);
            templateData.put("replyId", replyId);
            return new ModelAndView(templateData, "home.html");
        }, new MustacheTemplateEngine());

        Spark.post("/login", (request, response) -> {
            String userName = request.queryParams("loginName");
            if(userName == null){
                throw new Exception("Login name not entered");
            }

            User user = users.get(userName);
            if(user == null){
                user = new User(userName);
                users.put(userName, user);
            }

            Session session = request.session();
            session.attribute(SESSION_USERNAME, userName);
            response.redirect("/");
            return "";
        });

        Spark.post("/logout", (request, response) -> {
            request.session().invalidate();
            response.redirect("/");
            return "";
        });

        Spark.post("/create-message", (request, response) -> {
            Session session = request.session();
            String userName = session.attribute(SESSION_USERNAME);
            if(userName == null){
                throw new Exception("Not logged in");
            }

            String text = request.queryParams("messageText");
            if(text == null){
                throw new Exception("Didn't get necessary message text");
            }

            String replyIdString = request.queryParams("replyId");
            int replyId = Integer.valueOf(replyIdString);

            Message m = new Message(messages.size(), replyId, userName, text);
            messages.add(m);

            String url = "/";

            if (replyId >= 0){
                url += "?replyId="+replyId;
            }

            response.redirect(url);
            return "";
        });
    }

    static void addTestUsers(){
        users.put("Alice", new User("Alice"));
        users.put("Bob", new User("Bob"));
        users.put("Charlie", new User("Charlie"));
    }

    static void addTestMessages(){
        messages.add(new Message(0, -1, "Alice", "Hello world!"));
        messages.add(new Message(1, -1, "Bob", "This is another thread!"));
        messages.add(new Message(2, 0, "Charlie", "Cool thread, Alice"));
        messages.add(new Message(3, 2, "Alice", "Thanks"));
    }
}
