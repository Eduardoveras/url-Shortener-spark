/**
 * Created by Siclait on 12/7/16.
 */
package REST;

import Entity.URL;
import JSONTemplates.Authentication;
import JSONTemplates.Data;
import JSONTemplates.Greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
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

    // Access this service via following format
    // http://localhost:8080/ws/newurl?original=XXXXXX&username=MyUsername&browser=X&os=Y&ip=MyIP&longitude=Lo&latitude=La
    @RequestMapping(value = "/ws/newurl", method = GET)
    public Authentication NewURL(@RequestParam(name = "original") String original, @RequestParam(name = "username") String username, @RequestParam(name = "browser") String browser, @RequestParam(name = "os") String OS, @RequestParam(name = "ip") String ip, @RequestParam(name = "longitude") String longitude, @RequestParam(name = "latitude") String latitude){

        // TODO: Modify this service for clients
        System.out.println("\n\nCreating new URL...");
        return new Authentication(counter.incrementAndGet(), WebServiceDBManager.CreateNewShortURL(original, username, browser, OS, ip, longitude, latitude));
    }

    // Access this service via following format
    // http://localhost:8080/ws/fetchoriginal?short=XXXXXX
    @RequestMapping(value = "/ws/fetchoriginal", method = GET)
    public Data FetchOriginal(@RequestParam(name = "short") String shortURL){

        System.out.println("\n\nFetching an original URL...");
        return new Data(counter.incrementAndGet(), "OriginalURL", WebServiceDBManager.FetchOriginalURL(shortURL));
    }

    // Access this service via following format
    // http://localhost:8080/ws/myurls?username=admin
    @RequestMapping(value = "/ws/myurls", method = GET)
    public Data MyURLs(@RequestParam(name = "username") String username){

        System.out.println("\n\nFetching URLs for " + username + "...");
        String buffer = "[";
        int count = 0;

        List<URL> urls = WebServiceDBManager.FetchAllURLForUser(username);

        if(urls.size() == 0)
            buffer += "]";

        for (URL url:
             urls) {
            if(count != urls.size() - 1)
                buffer += url.getShortURL() + ", ";
            else
                buffer += url.getShortURL() + "]";
            count++;
        }

        return new Data(counter.incrementAndGet(), "ShortURL", buffer);
    }

}
