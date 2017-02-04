/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.dataccob;

import cat.urv.deim.sob.Tour;
import java.util.*;

/**
 *
 * @author dyno
 */
public class TourService implements IKey {
     
    TourDAO db = new TourDAO();

    TourService(int id_oferta){
        try{
         db.getOferta(id_oferta);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public List<Tour> getTours(){
        
        try{
            List<Tour> tours = db.getTours();
            return tours;
            
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList<Tour>();
        }
        
    }
    
    public Tour getOferta(int id_oferta){
        try{
            return db.getOferta(id_oferta);
            
        }catch(Exception e){
            return null;
        }
    }
    
    public void modificaOferta(int places_disp, int id_oferta){
        
    } 
    
}
