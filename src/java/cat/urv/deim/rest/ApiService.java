
package cat.urv.deim.rest;

import cat.urv.deim.dataccob.TourDAO;
import cat.urv.deim.sob.Tour;
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
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

@Stateless
@Path("/v1")
public class ApiService {
    
    /*
       METODOS USER RESERVTION TOURS
    
    
    *//*
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers (){
       
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson("hola");
            
        
        
        return Response.status(200).entity("").build(); //entity JSON convertido a String
    }*/
    
    @Path("/promos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPromos() throws ClassNotFoundException, SQLException{
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
        String json = "{ \"TOURS\": [";
        
        try{
            ArrayList<Tour> listTours = new ArrayList<>();

            cn.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.TOURS";
            PreparedStatement ps = cn.prepareStatement(query);
            Tour newTour;
            ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                newTour= new Tour(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getFloat(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
                listTours.add(newTour);
                
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
            out.println(json); 
            return json;
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
    public String getPromoById (@PathParam("id") Integer id) throws ClassNotFoundException, SQLException{
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
            return json;
    }
        /*
     @POST
    @Consumes("application/json")
    public String nouChat(String informacio) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/AgendaContactes", "agenda", "agenda");
        
        String usuari = getParameterJson(informacio, "ID_USER");
        String contacte = getParameterJson(informacio, "ID_CONTACTES");
        
        try{  
            con.setSchema("AGENDACONTACTES");
            
            String str = "INSERT INTO USUARIS_CONTACTES VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(str);
            stmt.setString(1, usuari);
            stmt.setString(2, contacte);
            stmt.executeUpdate();
            
            String str2 = "INSERT INTO USUARIS_CONTACTES VALUES (?,?)";
            PreparedStatement stmt2 = con.prepareStatement(str2);
            stmt2.setString(1, contacte);
            stmt2.setString(2, usuari);
            stmt2.executeUpdate();
            
        }catch(Exception e){
           return "Error";
        }finally{
            con.close();
        }
        return "Nou contacte afegit";
    }*/
    }
