/**
 * Created by Siclait on 18/7/16.
 */
import Entity.URL;
import Entity.User;
import JSONTools.ResponseError;
import org.h2.engine.Database;

import static JSONTools.JSONUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;

public class JSONServiceController {

    public JSONServiceController() {

        // GETS
        // Fetch All Urls
        get("/json/allurls", (req, res) -> DatabaseManager.FetchAllURL(), json());

        // Fetch Specific Short Url
        get("/json/original/:short",  (req, res) -> {
            String shortURL = req.params(":short");

            String url = DatabaseManager.FetchOriginalURL(shortURL);

            if(url != null)
                return url;

            res.status(400);
            return new ResponseError("No url with id %s found", shortURL);

        }, json());

        get("/json/url/:short", (req, res) -> {

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
            String username = req.params(":username");

            User user = DatabaseManager.FetchUser(username);

            if(user != null)
                return user;

            res.status(400);
            return new ResponseError("No user with id %s found", username);

        }, json());

        get("/json/:user/urls", (req, res) -> {
            String username = req.params(":user");

            return DatabaseManager.FetchAllURLForUser(username);
        }, json());

        // POSTS


        after("/json/*", (req, res) -> res.type("application/json"));
    }
}

