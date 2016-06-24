import Entity.URL;
import Entity.User;
import spark.ModelAndView;
import spark.Session;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Eduardo veras on 19-Jun-16.
 */
public class pageCreator {

    static String current_username;

    public pageCreator() throws Exception {

        generateGets();
        generatePost();
        generateFilters();
    }

    private static void generateFilters()
    {
        before("/*", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            if (request.session().attribute("user")!= null)
            {
                current_username= request.session().attribute("user");
            }
            else
            {
                current_username="guest";
            }


        });
    }

    private static void generateGets() {

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Welcome");
            attributes.put("pagename","Home");
            attributes.put("user",current_username);
            ArrayList<URL> urls = DatabaseManager.FetchAllURLForUser(current_username);
            attributes.put("urls",urls);

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());



        get("/login", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("user",current_username);
            attributes.put("pagename","Login");
            attributes.put("message", "Welcome");
            return new ModelAndView(attributes, "login.ftl");
        }, new FreeMarkerEngine());



        get("/p/:urlid", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("pagename","URL Page");
            attributes.put("message", "Welcome");
            attributes.put("user",current_username);
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());





    }

    private static void generatePost() {



        post("/", (request, response) -> {
            String URL = request.queryParams("URL");
            String username = request.queryParams("username");
            DatabaseManager.CreateNewShortURL(URL,username,request.userAgent(),request.userAgent(),"Dominican Republic");

            return username;
        });

        post("/login", (request, response) -> {

            String username = request.queryParams("username");
            String pass = request.queryParams("password");
            if (DatabaseManager.CheckUserCredentials(username,pass))
            {
                System.out.println("Loggin successfull");
                System.out.println("Logged in as: "+username);
                System.out.println("With the password: "+pass);
                request.session().attribute("user",username);

            }
            else
            {
                System.out.println("Loggin Failed, check user and password");
            }
            //DatabaseManager.CreateNewShortURL(URL,username,request.userAgent(),request.userAgent(),"Dominican Republic");

            return username;
        });

    }



}
