import static spark.Spark.get;

/**
 * Created by Eduardo veras on 19-Jun-16.
 */
public class Main {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
