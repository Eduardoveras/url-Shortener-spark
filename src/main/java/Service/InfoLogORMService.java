/**
 * Created by Siclait on 19/6/16.
 */
package Service;

import Entity.InfoLog;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class InfoLogORMService extends GenericORMService<InfoLog>{

    private static InfoLogORMService instance;

    private InfoLogORMService(){
        super(InfoLog.class);
    }

    public static InfoLogORMService GetInstance(){

        if(instance == null)
            instance = new InfoLogORMService();

        return instance;
    }

    public static List<InfoLog> FindShortURLInstance(String shortURL){

        EntityManager em = GetEntityManager();

        TypedQuery<InfoLog> query = em.createQuery("select i from InfoLog as i where i.url.shortURL = '" +
                shortURL + "'", InfoLog.class);

        return query.getResultList();
    }

    public static Integer HowManyTimesUsedByBrowser(String shortURL, String browser){

        EntityManager em = GetEntityManager();

        TypedQuery<InfoLog> query = em.createQuery("select i from InfoLog as i where i.url.shortURL = '" +
                shortURL + "' and i.browser = '" +
                browser + "'", InfoLog.class);

        return query.getResultList().size();
    }
}
