/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.dataccob;
import cat.urv.deim.sob.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author dyno
 */
public class TourDAO {
    
    public ArrayList<Tour> getTours() throws SQLException {
            ArrayList<Tour> listTours = new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.TOURS";
            PreparedStatement ps = con.prepareStatement(query);
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
        }
        return listTours;
    }
    
    public Tour getOferta(int id_oferta) throws SQLException {
        Tour oferta = null;
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.TOURS where IDTour=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_oferta);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                oferta=new Tour(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getFloat(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
        }
        return oferta;
    }
    public void modificaOferta(int places_disp, int id_oferta) throws SQLException {
        Tour oferta = null;
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "UPDATE DEMODB.TOURS SET AVAILABLEPLACES=? WHERE IDTOUR=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, places_disp);
            ps.setInt(2, id_oferta);
            ps.execute();
    }
}
