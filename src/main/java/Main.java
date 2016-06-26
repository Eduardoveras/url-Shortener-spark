import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

/**
 * Created by Eduardo veras on 19-Jun-16.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        port(getHerokuAssignedPort());

        staticFileLocation("/public");

        DatabaseManager.BootDataBase();

        pageCreator pages = new pageCreator();
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
