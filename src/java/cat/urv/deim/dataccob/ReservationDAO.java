/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.dataccob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import cat.urv.deim.sob.*; 
/**
 *
 * @author dyno
 */
public class ReservationDAO {
    
    
    public ArrayList<Reservation> geReservation(String alias) throws SQLException, ParseException {
        ArrayList<Reservation> reservations = new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.RESERVATIONS where IDUser=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, alias);
            Reservation newreservation;
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                newreservation=new Reservation(resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(1),
                        resultSet.getString(2));
                reservations.add(newreservation);
        }
        return reservations;
    }
    public Reservation newReservation(float preuTotal,int idOferta,  int persones, String alias) throws SQLException {
        //    public Reservation(float totalPrice,int IDTour, int quantity, String IDUser) {
        Reservation newreservations = null;
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "INSERT INTO demodb.RESERVATIONS(IDUser,IDTour,totalPrice,quantity) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, alias);
            ps.setInt(2, idOferta); 
            ps.setFloat(3, preuTotal);
            ps.setInt(4, persones);
            ps.execute();
           // newreservations = new Reservation(alias,idOferta,preuTotal, persones );
            newreservations = new Reservation(preuTotal,idOferta,persones,alias); //asi estaba antes de poner linea de arriba

        return newreservations;
    }
}
