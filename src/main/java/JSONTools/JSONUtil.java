/**
 * Created by Siclait on 18/7/16.
 */
package JSONTools;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JSONUtil {

    public static String toJSON(Object object){
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json(){
        return JSONUtil::toJSON;
    }

}
