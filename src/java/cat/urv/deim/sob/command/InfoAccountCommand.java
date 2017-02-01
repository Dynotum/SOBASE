package cat.urv.deim.sob.command;
import cat.urv.deim.dataccob.*;
import cat.urv.deim.sob.*;
import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class InfoAccountCommand implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String userLogin = (String) session.getAttribute("aliasLogin");
       
        UserDAO users=new UserDAO();
        ReservationDAO orders=new ReservationDAO();
        User user = null;
        ArrayList<Reservation> orderss = null;
        try {
            user = users.getUser(userLogin);
            orderss = orders.geReservation(userLogin);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(InfoAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("dadesUsuari", user);
        session.setAttribute("dadesComandes", orderss);
        ServletContext context = request.getSession().getServletContext();
                context.getRequestDispatcher("/accountUser.jsp").forward(request, response);}
}
