package cat.urv.deim.sob.command;

import cat.urv.deim.*;
import cat.urv.deim.dataccob.ReservationDAO;
import cat.urv.deim.dataccob.TourDAO;
import cat.urv.deim.sob.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class ReserveCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession(true);
            // 1. process the request
            int idOferta =  (int) session.getAttribute("idOferta");
            TourDAO oferta_=new TourDAO();
            int placesDisp = 0;
        try {
            Tour oferta=oferta_.getOferta(idOferta);
            placesDisp = oferta.getAvailablePlaces();
        } catch (SQLException ex) {
            Logger.getLogger(ReserveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
            String first = (String) session.getAttribute("first");
            String placesReservaST = request.getParameter("placesReserva");
            int placesReserva =Integer.parseInt(placesReservaST);
            System.out.print(placesReserva);
            float preuPers = (float) session.getAttribute("preuPers");
            String userLogin = (String) session.getAttribute("aliasLogin");
            TourDAO ofertaActualitzar=new TourDAO();
            ReservationDAO comanda=new ReservationDAO();
            Reservation order= new Reservation();
            int placesAct = placesDisp - placesReserva;
            ServletContext context = request.getSession().getServletContext();
            if(first.equals("1")){
            if(placesAct>=0){
        try {
            ofertaActualitzar.modificaOferta(placesAct, idOferta);
        } catch (SQLException ex) {
            Logger.getLogger(ReserveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            float preuTotal = preuPers * placesReserva;
            order = comanda.newReservation(preuTotal,idOferta,placesReserva, userLogin);
            //newreservations = new Reservation(preuTotal,idOferta,persones,alias); //asi estaba antes de poner linea de arriba

        } catch (SQLException ex) {
            Logger.getLogger(ReserveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
                session.setAttribute("comanda", order);
                context.getRequestDispatcher("/reserva_confirmada.jsp").forward(request, response);}
            else context.getRequestDispatcher("/oferta.jsp?id_oferta="+idOferta+"&placesReserva="+placesReserva+"&error=true").forward(request, response);
    }else context.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
