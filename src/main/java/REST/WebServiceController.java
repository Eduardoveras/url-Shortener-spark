/**
 * Created by Siclait on 12/7/16.
 */
package REST;

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
    private final AtomicLong clientCounter = new AtomicLong();

    // This should always appear when the Client connects
    // Access this service via following format
    // http://localhost:8080/ws/greet or
    // http://localhost:8080/ws/greet?name=MyUsername
    @RequestMapping(value = "/ws/greet", method = GET)
    public Greeting Greet(@RequestParam(value = "name", defaultValue = "Guest") String name){

        if(name.equals("Guest"))
            System.out.println("\n\nClient ID#" + clientCounter.incrementAndGet() + " connecting...");

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    // Access this service via following format
    // http://localhost:8080/ws/authenticate?username=MyUsername&password=MyPassword
    @RequestMapping(value = "/ws/authenticate", method = GET)
    public Authentication Authenticate(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){

        System.out.println("\n\nChecking client credentials...");
        return new Authentication(counter.incrementAndGet(), WebServiceDBManager.CheckUserCredentials(username, password));
    }

}
