import Entity.User;
import spark.ModelAndView;
import spark.Session;
import spark.template.freemarker.FreeMarkerEngine;

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
                String CookieUSER= request.session().attribute("user");

                //User user = DatabaseManager
                //attributes.put("user", user);
            }
            else
            {
                //User user = DatabaseManager.FetchUser("guest");

                //attributes.put("user", user);
            }


        });
    }

    private static void generateGets() {

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Welcome");
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());



        get("/login", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Welcome");
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());



        get("/p/:urlid", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Welcome");
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());





    }

    private static void generatePost() {



        post("/", (request, response) -> {

            String URL = request.queryParams("URL");
            String username = request.queryParams("username");
            //DatabaseManager.CreateNewShortURL(URL,username,request.userAgent(),request.userAgent(),"Dominican Republic");

            return username;
        });

    }



}
