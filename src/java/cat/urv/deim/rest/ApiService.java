
package cat.urv.deim.rest;

import cat.urv.deim.dataccob.TourDAO;
import cat.urv.deim.dataccob.UserDAO;
import cat.urv.deim.sob.Reservation;
import cat.urv.deim.sob.Tour;
import cat.urv.deim.sob.User;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

@Path("/v1")
public class ApiService {
                                        /* TOURS*/
    @Path("/promos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPromos() throws ClassNotFoundException, SQLException{
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
        String json = "{ \"TOURS\": [";

        
        try{

            cn.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.TOURS";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            Tour newTour;

                while (resultSet.next()) {
                newTour = new Tour(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getFloat(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
             //   listTours.add(newTour);
                
                json = json.concat("{\"ID TOUR\":"  + resultSet.getInt(1) + ",\"TITULO\":\"" + resultSet.getString(2)+ "\",\"SHORT DESCRIPTION\":\"" 
                       + resultSet.getString(3)+ "\",\"LONG DESCRIPTION\":\"" + resultSet.getString(4) + "\",\"AVAILABLE PLACES\":\"" + resultSet.getInt(5)
                        + "\",\"PRICE\":\"" + resultSet.getFloat(6) + "\",\"DESTINATION\":\"" + resultSet.getString(7) + "\",\"MOUNTH\":\"" 
                        + resultSet.getString(8)+"\"},");
               }       
                
                json = json.substring(0, json.length() - 1);
                json = json.concat("]}");
                
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            cn.close();
        }
            return Response.status(200).entity(json).build();
    }
    
    /*
    @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public JSONObject sayPlainTextHello(JSONObject inputJsonObj) throws Exception {

    String input = (String) inputJsonObj.get("input");
    String output = "The input you sent is :" + input;
    JSONObject outputJsonObj = new JSONObject();
    outputJsonObj.put("output", output);

    return outputJsonObj;*/
    
    @GET
    @Path("/promos/{id}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getPromoById (@PathParam("id") Integer id) throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
        
        TourDAO t = new TourDAO();
        
        cn.setSchema("DEMODB");
            String query = "SELECT * FROM DEMODB.TOURS WHERE IDTOUR = ?";
            PreparedStatement ps=cn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            Tour newTour;
            String json = "{ \"TOURS\": [";
            
                try{
                while (resultSet.next()) {
                newTour= new Tour(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getFloat(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
                
                         json = json.concat("{\"ID TOUR\":"  + resultSet.getInt(1) + ",\"TITULO\":\"" + resultSet.getString(2)+ "\",\"SHORT DESCRIPTION\":\"" 
                       + resultSet.getString(3)+ "\",\"LONG DESCRIPTION\":\"" + resultSet.getString(4) + "\",\"AVAILABLE PLACES\":\"" + resultSet.getInt(5)
                        + "\",\"PRICE\":\"" + resultSet.getFloat(6) + "\",\"DESTINATION\":\"" + resultSet.getString(7) + "\",\"MOUNTH\":\"" 
                        + resultSet.getString(8)+"\"},");        
                }       
                
                json = json.substring(0, json.length() - 1);
                json = json.concat("]}");
                
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            cn.close();
        }//return Response.status(200).entity("").build(); //entity JSON convertido a String
            return Response.status(200).entity(json).build();
    }
     
    @Path("/users")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() throws ClassNotFoundException, SQLException{
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
        String json = "{ \"USERS\": [";

        
        try{
            ArrayList<User> listaUsers = new ArrayList<>();

            cn.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.USERS";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            User newUser;
                        
                while (resultSet.next()) {
                newUser = new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
                listaUsers.add(newUser);
                
                json = json.concat("{\"ID NICKNAME\":\""  + resultSet.getString(1) + "\",\"PASSWORD\":\"" + resultSet.getString(2)+ "\",\"NAME\":\"" 
                     + resultSet.getString(3)+ "\",\"LAST NAME\":\"" + resultSet.getString(4) + "\",\"EMAIL\":\"" + resultSet.getString(5)+"\"},");     
        }       
                
                json = json.substring(0, json.length() - 1);
                json = json.concat("]}");
                
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            cn.close();
        }
            return Response.status(200).entity(json).build();
    }
                                        /*USERS*/
    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getUserxById (@PathParam("id") String id) throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
        Connection cn2 = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");

        UserDAO t = new UserDAO();
        
            cn.setSchema("DEMODB");
            cn2.setSchema("DEMODB");
            
            User newUser;
            String query = "SELECT * FROM DEMODB.USERS WHERE NICKNAME = ?";
            PreparedStatement ps=cn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            String json = "{ \"USER\": [";

                try{
                while (resultSet.next()) {
                newUser= new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
            
                json = json.concat("{\"ID NICKNAME\":\""  + resultSet.getString(1) + "\",\"PASSWORD\":\"" + resultSet.getString(2)+ "\",\"NAME\":\"" 
                     + resultSet.getString(3)+ "\",\"LAST NAME\":\"" + resultSet.getString(4) + "\",\"EMAIL\":\"" + resultSet.getString(5)+"\"},");     
        }                 json = json.substring(0, json.length() - 1);

                
            Reservation newReservation;
         //   ArrayList<Reservation> reservations = new ArrayList<>();
            String query1 = "SELECT * FROM DEMODB.RESERVATIONS WHERE IDUSER = ?";
            PreparedStatement ps1 =cn2.prepareStatement(query1);
            ps1.setString(1, id);
            ResultSet resultSet1 = ps1.executeQuery();

            json = json.concat("],\"MY RESERVATIONS\": [");
            while (resultSet1.next()) {
                
                newReservation=new Reservation(resultSet1.getInt(3),
                        resultSet1.getInt(4),
                        resultSet1.getInt(5),
                        resultSet1.getInt(1),
                        resultSet1.getString(2));
           //     reservations.add(newReservation);
                
                json = json.concat("{\"ID RESERVATION\":"+ resultSet1.getInt(1) + ",\"ID USER\":\"" + resultSet1.getString(2) + "\",\"ID TOUR\":"+
                        resultSet1.getInt(3) + ",\"TOTAL PRICE\":"+ resultSet1.getInt(4) + ",\"QUANTITY\":" + resultSet1.getInt(5) + "},");
        }


                json = json.substring(0, json.length() - 1);
                json = json.concat("]}");//  json = json.concat("],\"USER\": [{\"ID NICKNAME\": \"simeon\",\"PASSWORD\":\"caca\"}]}");
                
        }catch(Exception e){
            e.printStackTrace();
           return Response.status(404).entity("error").build();

        }finally{
            cn.close();
            cn2.close();
        }//return Response.status(200).entity("").build(); //entity JSON convertido a String
            return Response.status(200).entity(json).build();
    }
    
    /*
    @POST
    //@Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    
    	@POST
	//@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON() {

		return Response.status(201).entity(result).build();

	}*/
    }
