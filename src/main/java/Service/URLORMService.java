/**
 * Created by Siclait on 19/6/16.
 */
package Service;

import Entity.URL;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class URLORMService extends GenericORMService<URL>{

    private static URLORMService instance;

    private URLORMService(){
        super(URL.class);
    }

    public static URLORMService GetInstance(){

        if(instance == null)
            instance = new URLORMService();

        return instance;
    }

}
