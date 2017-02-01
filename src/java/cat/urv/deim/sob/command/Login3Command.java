package cat.urv.deim.sob.command;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login3Command implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            String idOferta = request.getParameter("idOferta");
            String placesReserva = request.getParameter("placesReserva");
            HttpSession session = request.getSession(true);
            // 1. process the request
                ServletContext context = request.getSession().getServletContext();
                int idOfertaint=Integer.parseInt(idOferta);
                int placesReservaint=0;
              
                if(placesReserva!=null&&!("").equals(placesReserva)){
                placesReservaint=Integer.parseInt(placesReserva);}
                context.getRequestDispatcher("/login.jsp?idOferta="+idOfertaint+"&placesReserva="+placesReservaint).forward(request, response);
    }
}
