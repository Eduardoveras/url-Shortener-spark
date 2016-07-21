import static spark.Spark.*;

/**
 * Created by Eduardo veras on 19-Jun-16.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

        staticFiles.location("/public"); // Static files

        //staticFileLocation("/public");

        DatabaseManager.BootDataBase();

        pageCreator pages = new pageCreator();
    }
}
