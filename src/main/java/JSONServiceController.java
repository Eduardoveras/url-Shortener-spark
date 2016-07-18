/**
 * Created by Siclait on 18/7/16.
 */
import spark.Spark.*;

import static spark.Spark.get;

public class JSONServiceController {

    public JSONServiceController() {
        get("/json/allurls", (request, response) -> {
                return DatabaseManager.FetchAllURL();
        });
        // more routes
    }
}
