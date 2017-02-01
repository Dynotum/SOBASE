package cat.urv.deim.sob.command;

import cat.urv.deim.dataccob.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

 @Override
 public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
            String nick = request.getParameter("nickname");   
            String pass = request.getParameter("pass");
            HttpSession session = request.getSession(true);
            // 1. process the request
            
            UserDAO n= new UserDAO();
            String a="";
        try {
            a = n.getLogin(nick, pass);
          // System.out.print(alias+" " + pass);
        } catch (SQLException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        ServletContext context = request.getSession().getServletContext();
        if((nick!=null)&&(!("").equals(nick))){
            if (a.equals(nick)) {     //if is correct go to main
                session.setAttribute("aliasLogin", a);
                context.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else{
                context.getRequestDispatcher("/login.jsp?dadesErronees=true").forward(request, response);}
    }else context.getRequestDispatcher("/login.jsp?dadesErronees=true").forward(request, response);
    }
}
