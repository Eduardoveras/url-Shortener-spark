/**
 * Created by Siclait on 18/7/16.
 */
package JSONTools;

import static java.lang.String.format;

public class ResponseError {

    private String message;

    public ResponseError(String message, String... args){
        this.message = format(message, args);
    }

    public ResponseError(Exception e){
        this.message = e.getMessage();
    }

    public String getMessage(){
        return this.message;
    }

}
