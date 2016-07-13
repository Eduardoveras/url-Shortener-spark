/**
 * Created by Siclait on 12/7/16.
 */
package REST;

import

import JSONTemplates.Authentication;
import JSONTemplates.Greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WebServiceController {

    private static final String template = "Hello, %s! Welcome to Acorta.do";
    private final AtomicLong counter = new AtomicLong();

    // This should always appear when the Client connects
    @RequestMapping(value = "/home", method = GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Guest") String name){

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    public Authentication Authenticate(@RequestParam() String username, @RequestParam() String password){

        WebServiceDBManager.CheckUserCredentials();

        return new Authentication(counter.incrementAndGet(), false);
    }

}
