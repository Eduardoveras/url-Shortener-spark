/**
 * Created by Siclait on 19/6/16.
 */

package Service;

import org.hibernate.QueryException;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

public class GenericORMService<T> {

    private static  EntityManagerFactory emf;
    private Class<T> classEntity;

    // Consturctor
    public GenericORMService(Class<T> classEntity){

        if(emf == null)
            emf = Persistence.createEntityManagerFactory("PersistenceUnit");

        this.classEntity = classEntity;
    }

    public EntityManager GetEntityManager(){ return emf.createEntityManager(); }

    // Class Methods
    public void Create(T entity){

        EntityManager em = GetEntityManager();

    }

}
