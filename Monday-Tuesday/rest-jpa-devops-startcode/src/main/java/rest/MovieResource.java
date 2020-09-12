package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    
    private static final MovieFacade FACADE =  MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCount() {
        long count = FACADE.getCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }
    
    @GET
    @Path("/populate")
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populateDB();
        return "{\"msg\":\"3 rows added\"}";
    }
    
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        List<Movie> list = FACADE.getAllMovies();
        return GSON.toJson(list);
        
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieById(@PathParam("id") int id) {
        Movie movie = FACADE.getByID(id);
        return GSON.toJson(movie);
    }
    
    @GET
    @Path("/title/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieByName(@PathParam("title") String title) {
        List<Movie> movieList = FACADE.getByTitle(title);
        return GSON.toJson(movieList);
    }
    
}
