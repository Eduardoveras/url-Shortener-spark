import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by Eduardo veras on 19-Jun-16.
 */
public class pageCreator {

    public pageCreator() throws Exception {

        //DatabaseManager.BootUP();
        //DatabaseManager.PrintData();

        generateGets();
        generatePost();
    }

    private static void generateGets() {

        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Welcome");
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());


    }

    private static void generatePost() {

    }



}
