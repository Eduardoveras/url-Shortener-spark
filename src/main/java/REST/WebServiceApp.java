/**
 * Created by Siclait on 12/7/16.
 */
package REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceApp {

    public static void main(String[] args){
        System.out.println("Attempting to run Acorta.do...");
        SpringApplication.run(WebServiceApp.class, args);
        System.out.println("Success!");
    }

}
