package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM Movie r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }
    
     public void populateDB(){
            EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Movie(1986, "Topgun", new String[]{"Tom Cruise", "Val Kilmer","Kelly McGills"}));
            em.persist(new Movie(2003, "Kill Bill", new String[]{"Uma Thurman", "Daryl Hannah"}));
            em.persist(new Movie(1991, "Point Break", new String[]{"Patrick Swayze", "Keanu Reeves"}));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public Movie getByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Movie m1 = em.find(Movie.class, id);

            return m1;
        } finally {
            em.close();
        }

    }
    
    public List<Movie> getByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        try{
             Query query = em.createQuery("SELECT m FROM Movie m WHERE m.title = :title");
            query.setParameter("title", title);
            List<Movie> list = query.getResultList();
            return list;
        } finally {
            em.close();
        }
    }
    
    public List<Movie> getAllMovies() {
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT m FROM Movie m");
            List<Movie> list = query.getResultList();
            return list;
        } finally {
            em.close();
        }
    }
    

}
