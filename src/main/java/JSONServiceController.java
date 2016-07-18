/**
 * Created by Siclait on 18/7/16.
 */
import static JSONTools.JSONUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;

public class JSONServiceController {

    public JSONServiceController() {
        get("/json/allurls", (reqt, res) -> DatabaseManager.FetchAllURL(), json());
        // more routes

        after("/json/*",(req, res) -> {res.type("application/json");});
    }
}
