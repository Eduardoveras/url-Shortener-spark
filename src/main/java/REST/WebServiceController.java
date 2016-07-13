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
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    // Access this service via following format
    // http://localhost:8080/ws/register?username=MyUsername&firstname=X&lastname=Y&password=MyPassword
    @RequestMapping(value = "/ws/register", method = GET)
    public Authentication Register(@RequestParam(name = "username") String username, @RequestParam(name = "firstname") String firstName, @RequestParam(name = "lastname") String lastName, @RequestParam(name = "password") String password){

        System.out.println("\n\nRegistering new user...");
        return new Authentication(counter.incrementAndGet(), WebServiceDBManager.CreateNewUser(username, firstName, lastName, password));
    }

    @RequestMapping(value = "/ws/newURL/", method = GET)
    public Authentication NewURL(@RequestParam(name = "original") String original, @RequestParam(name = "username") String username, @RequestParam(name = "browser") String browser, @RequestParam(name = "os") String OS, @RequestParam(name = "ip") String ip, @RequestParam(name = "longitude") String longitude, @RequestParam(name = "latitude") String latitude){

        // TODO: Modify this service for clients
        System.out.println("\n\nCreating new URL...");
        return new Authentication(counter.incrementAndGet(), WebServiceDBManager.CreateNewShortURL(original, username, browser, OS, ip, longitude, latitude));
    }

    @RequestMapping("/ws/fetchOriginal")
    public void FetchOriginal(){

        System.out.println("\n\nFetching an original URL...");

    }

}
