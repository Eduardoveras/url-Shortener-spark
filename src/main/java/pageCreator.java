import Entity.URL;
import Entity.User;
import eu.bitwalker.useragentutils.UserAgent;
import spark.ModelAndView;
import spark.Session;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            List<URL> urls = DatabaseManager.FetchAllURLForUser(current_username);
            attributes.put("urls",urls);

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        get("/viewall", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Welcome");
            attributes.put("pagename","View All Users");
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            List<URL> urls = DatabaseManager.FetchAllURL();
            attributes.put("urls",urls);

            return new ModelAndView(attributes, "viewall.ftl");
        }, new FreeMarkerEngine());

        get("/register", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            attributes.put("pagename","Register");
            attributes.put("message", "Welcome");
            return new ModelAndView(attributes, "register.ftl");
        }, new FreeMarkerEngine());


        get("/login", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            attributes.put("pagename","Login");
            attributes.put("message", "Welcome");
            return new ModelAndView(attributes, "login.ftl");
        }, new FreeMarkerEngine());

        get("/instructions", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            attributes.put("pagename","Instructions");
            return new ModelAndView(attributes, "instructions.ftl");
        }, new FreeMarkerEngine());


        get("/logout", (req, res) -> {
            req.session().invalidate();
            res.redirect("/");

            return "<h1>You have bee logged out</h1>";
        }  );

        get("/users", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            attributes.put("pagename","Users Management");
            List<User> userList= DatabaseManager.FetchAllUsers();
            attributes.put("userList",userList);
            return new ModelAndView(attributes, "usersview.ftl");
        }, new FreeMarkerEngine());

        get("/p/:urlid/stats", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String urlid =request.params(":urlid");
            attributes.put("urlid",urlid);
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            attributes.put("pagename","Link Stats");
            String QrUrl = ResourceFetcher.getQrCodeURL(DatabaseManager.FetchOriginalURL(urlid));
            attributes.put("QrUrl",QrUrl);

            attributes.put("allBrowsers",DatabaseManager.FetchAllBrowser());
            attributes.put("allOs",DatabaseManager.FetchAllOS());
            attributes.put("allCountries",DatabaseManager.FetchAllCountries());




            Map<java.sql.Date, Integer> data = DatabaseManager.FetchURLDataByDate(urlid);
            Set<java.sql.Date> legend = DatabaseManager.ShowDateMapLegend(data);
            DateFormat df = new SimpleDateFormat("yyyy,MM,dd");
            ArrayList<String> arr = new ArrayList<String>();
            for (java.sql.Date key: legend) {

                String theValue= "new Date("+df.format(key) + "),"+ data.get(key);
                System.out.println(theValue);
                arr.add(theValue);
            }

            attributes.put("accDates",arr);

            return new ModelAndView(attributes, "stats.ftl");
        }, new FreeMarkerEngine());


        get("/p/:urlid", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("pagename","URL Page");
            attributes.put("message", "Welcome");
            attributes.put("user",DatabaseManager.FetchUser(current_username));
            String urlid =request.params(":urlid");
            System.out.println("THE PARAM IS:" + urlid);
            String originalURL = DatabaseManager.FetchOriginalURL(urlid);
            System.out.println("THE URL IS:" + originalURL);
            if(originalURL != null && !originalURL.isEmpty())
            {
                if (!originalURL.toLowerCase().matches("^\\w+://.*")) {
                    originalURL = "http://" + originalURL;
                }
                UserAgent userAgent = UserAgent.parseUserAgentString(request.userAgent());
                //userAgent.getBrowser();
                DatabaseManager.TriggerForEveryUse(urlid,userAgent.getBrowser().getName(),userAgent.getOperatingSystem().getName(),request.ip());
                response.redirect(originalURL);
            }
            return new ModelAndView(attributes, "404.ftl");
        }, new FreeMarkerEngine());



        get("*", (req, res) ->{

            if(!req.pathInfo().startsWith("/static")){
                res.status(404);
                Map<String, Object> attributes = new HashMap<>();
                return new ModelAndView(attributes, "404.ftl");
            }

            return null;
        }, new FreeMarkerEngine());



    }

    private static void generatePost() {



        post("/", (request, response) -> {
            String URL = request.queryParams("URL");
            String username = request.queryParams("username");
            UserAgent userAgent = UserAgent.parseUserAgentString(request.userAgent());
            DatabaseManager.CreateNewShortURL(URL,username, userAgent.getBrowser().getName(), userAgent.getOperatingSystem().getName(),"Dominican Republic");
            response.redirect("/");
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
                response.redirect("/");
            }
            else
            {
                System.out.println("Loggin Failed, check user and password");
                response.redirect("/login");
            }


            return username;
        });

        post("/viewall", (request, response) -> {

            String shortURL = request.queryParams("url");
            DatabaseManager.DeleteShortURL(shortURL);
            response.redirect("/viewall");
            return "omg";
        });



        post("/register", (request, response) -> {

            String username = request.queryParams("username");
            String pass = request.queryParams("password");
            String Name = request.queryParams("firstname");
            String lastName = request.queryParams("lastname");
            if (DatabaseManager.CheckUserCredentials(username))
            {
                System.out.println("The user "+username+" already exists, try again");
                response.redirect("/register");
            }
            else
            {
                DatabaseManager.CreateNewUser(username,Name,lastName,pass);
                request.session().attribute("user",username);
                response.redirect("/");
            }


            return username;
        });

        post("/users", (request, response) -> {
            String username = request.queryParams("username");
            DatabaseManager.MakeAdmin(username);
            response.redirect("/users");
            return username;
        });

    }



}
