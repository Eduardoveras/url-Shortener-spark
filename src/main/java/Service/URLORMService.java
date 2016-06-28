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

    public static List<URL> FindUserURL(String username){

        EntityManager em = GetEntityManager();

        TypedQuery<URL> query = em.createQuery("select u from URL as u where u.user.username = '" + username + "'", URL.class);

        return query.getResultList();
    }

    public static String ShowShortURLForUser(String originalURL, String username){

        EntityManager em = GetEntityManager();

        TypedQuery<URL> query = em.createQuery("select u from URL as u where u.user.username = '" +
                username + "' and u.originalURL = '" +
                originalURL + "'", URL.class);

        List<URL> urls = query.getResultList();

        return urls.get(0).getShortURL();
    }
}
