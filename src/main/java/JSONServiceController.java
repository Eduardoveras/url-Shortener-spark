/**
 * Created by Siclait on 18/7/16.
 */
import Entity.URL;
import Entity.User;
import JSONTools.GeoLocation;
import JSONTools.ResponseError;
import eu.bitwalker.useragentutils.UserAgent;

import static JSONTools.JSONUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;

public class JSONServiceController {

    public JSONServiceController() {

        // GETS
        // Fetch All Urls
        get("/json/allurls", (req, res) -> DatabaseManager.FetchAllURL(), json());

        // Fetch Original of a Specific Short Url
        get("/json/original/:short",  (req, res) -> {

            System.out.println("\n\nUsing Jason Service");
            String shortURL = req.params(":short");

            String url = DatabaseManager.FetchOriginalURL(shortURL);

            if(url != null)
                return url;

            res.status(400);
            return new ResponseError("No url with id %s found", shortURL);

        }, json());

        // Fetch a Specific Short Url
        get("/json/url/:short", (req, res) -> {

            System.out.println("\n\nUsing Jason Service");
            String shortURL = req.params(":short");

            URL url = DatabaseManager.FetchURL(shortURL);

            if(url != null)
                return url;

            res.status(400);
            return new ResponseError("No url with id %s found", shortURL);

        },  json());

        // Fetch All Users
        get("/json/allusers", (req, res) -> DatabaseManager.FetchAllUsers(), json());

        // Fetch Specific User
        get("/json/user/:username", (req, res) -> {

            System.out.println("\n\nUsing JSON Service");
            String username = req.params(":username");

            User user = DatabaseManager.FetchUser(username);

            if(user != null)
                return user;

            res.status(400);
            return new ResponseError("No user with id %s found", username);

        }, json());

        // Fetch Urls of a Specific User
        get("/json/:user/urls", (req, res) -> {

            System.out.println("\n\nUsing JSON Service");
            String username = req.params(":user");

            return DatabaseManager.FetchAllURLForUser(username);
        }, json());

        // Create a new User
        get("/json/newuser", (req, res) -> {

            System.out.println("\n\nUsing JSON Service");
            DatabaseManager.CreateNewUser(req.queryParams("username"), req.queryParams("firstname"), req.queryParams("lastname"), req.queryParams("password"));

            res.redirect("/");
            return "Creating New User";
        }, json());

        //DatabaseManager.CreateNewShortURL();
        get("/json/newurl", (req, res) -> {

            System.out.println("\n\nUsing JSON Service");

            UserAgent userAgent = UserAgent.parseUserAgentString(req.userAgent());
            GeoLocation geo = ResourceFetcher.GetCoordinates(req.ip());
            System.out.println("Lon: " + geo.getLongitude() + " Lat: " + geo.getLatitude());
            DatabaseManager.CreateNewShortURL(req.queryParams("url"), req.params("username"), userAgent.getBrowser().getName(), userAgent.getOperatingSystem().getName(), req.ip(), geo.getLongitude(), geo.getLatitude());

            res.redirect("/");
            return "Creating New User";
        }, json());

        //DatabaseManager.CheckUserCredentials();

        after("/json/*", (req, res) -> res.type("application/json"));
    }
}

