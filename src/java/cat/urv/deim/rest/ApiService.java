
package cat.urv.deim.rest;

import cat.urv.deim.dataccob.TourDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
public class ApiService {
    
    /*
       METODOS USER RESERVTION TOURS
    
    
    */
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers (){
       
        
        
        
        
        return Response.status(200).entity("").build(); //entity JSON convertido a String
    }
    
    @GET
    @Path("/promos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPromoById (@PathParam("id") Integer id){
       
        TourDAO t = new TourDAO();
        
       //t.getOferta(0)
        
        // GSON GOOGLE
        
        
        return Response.status(200).entity("").build(); //entity JSON convertido a String
    }
}
    