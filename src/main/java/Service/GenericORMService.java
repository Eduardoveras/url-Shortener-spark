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

        em.getTransaction().begin();

        try{

            em.persist(entity);
            em.getTransaction().commit();

        } catch (EntityNotFoundException exp){
            System.out.println("\n\nEntity ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw  exp;
        } catch (TransactionRequiredException exp) {
            System.out.println("\n\nTransaction ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw  exp;
        } catch (PersistenceException exp){
            System.out.println("\n\nPersistence ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw  exp;
        } catch (Exception exp){
            System.out.println("\n\nGeneral ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw  exp;
        } finally{
            em.close();
        }
    }

    public void Edit(T entity) {

        EntityManager em = GetEntityManager();

        em.getTransaction().begin();

        try {

            em.merge(entity);
            em.getTransaction().commit();

        } catch (EntityNotFoundException exp) {
            System.out.println("\n\nEntity ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (TransactionRequiredException exp) {
            System.out.println("\n\nTransaction ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (PersistenceException exp) {
            System.out.println("\n\nPersistence ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (Exception exp) {
            System.out.println("\n\nGeneral ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } finally {
            em.close();
        }
    }

    public void Delete(T entity){

        EntityManager em = GetEntityManager();

        em.getTransaction().begin();

        try {

            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();

        } catch (EntityNotFoundException exp) {
            System.out.println("\n\nEntity ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (TransactionRequiredException exp) {
            System.out.println("\n\nTransaction ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (PersistenceException exp) {
            System.out.println("\n\nPersistence ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (Exception exp) {
            System.out.println("\n\nGeneral ERROR! --> " + exp.getMessage() +  "\n");
            em.getTransaction().rollback();
            throw exp;
        } finally {
            em.close();
        }
    }

    // Can only be sent primary keys
    public T Find(Object id) {

        EntityManager em = GetEntityManager();

        try {

            return em.find(classEntity, id);

        } catch (EntityNotFoundException exp) {
            System.out.println("\n\nEntity ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (PersistenceException exp) {
            System.out.println("\n\nPersistence ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } catch (Exception exp) {
            System.out.println("\n\nGeneral ERROR! --> " + exp.getMessage() + "\n");
            em.getTransaction().rollback();
            throw exp;
        } finally {
            em.close();
        }
    }
}
