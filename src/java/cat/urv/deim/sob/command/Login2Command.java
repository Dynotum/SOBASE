package cat.urv.deim.sob.command;

import cat.urv.deim.dataccob.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login2Command implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            String alias = request.getParameter("nickname");   
            String pass = request.getParameter("pass");
            String idOfertaST = request.getParameter("idOferta3");
            int idOferta = Integer.parseInt(idOfertaST);
            String placesResST = request.getParameter("placesRes3");
            int placesReserva = Integer.parseInt(placesResST);
            HttpSession session = request.getSession(true);
            // 1. process the request
            
            UserDAO n= new UserDAO();
            String a="";
        try {
            a = n.getLogin(alias, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Login2Command.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = request.getSession().getServletContext();
        if((alias!=null)&&(!("").equals(alias))){
            if (a.equals(alias)) {     //if is correct go to main
                session.setAttribute("aliasLogin", a);
                context.getRequestDispatcher("/oferta.jsp?id_oferta="+idOferta+"&placesReserva="+placesReserva).forward(request, response);
            }
            else{
                context.getRequestDispatcher("/login.jsp?dadesErronees=true&idOferta="+idOferta+"&placesReserva="+placesReserva).forward(request, response);}
        }
        else context.getRequestDispatcher("/login.jsp?dadesErronees=true&idOferta="+idOferta+"&placesReserva="+placesReserva).forward(request, response);
    }
}
