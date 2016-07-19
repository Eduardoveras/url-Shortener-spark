/**
 * Created by Siclait on 18/7/16.
 */
import JSONTools.ResponseError;

import static JSONTools.JSONUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;

public class JSONServiceController {

    public JSONServiceController() {
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

        after("/json/*",(req, res) -> {res.type("application/json");});
    }
}

