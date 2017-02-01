/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpCommand implements Command{
    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        try {
            PreparedStatement ps;
            Connection con;
            // 1. process the request
            
            boolean ok=true;//true
            int notOK=0;
            
            if((request.getParameter("nickname").equals("")||(request.getParameter("nickname").length()<2)||(request.getParameter("nickname").length()>20))&&notOK==0){
                notOK=1;
                ok=false;
            }
            if((request.getParameter("pass").equals("")||(request.getParameter("pass").length()<2)||(request.getParameter("pass").length()>20))&&notOK==0){
                notOK=2;
                ok=false;
            }
            if((request.getParameter("name").equals("")||(request.getParameter("name").length()>20))&&notOK==0){
                notOK=3;
                ok=false;
            }
            if((request.getParameter("lastName").equals("")||(request.getParameter("lastName").length()>20))&&notOK==0){
                notOK=4;
                ok=false;
            }
            if((request.getParameter("email").equals("")||(request.getParameter("email").length()>50))&&notOK==0){
                notOK=5;
                ok=false;
            }
            if(ok){
            User user = new User();
            user.setNickname(request.getParameter("nickname"));
            user.setName(request.getParameter("name"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("pass"));
            request.setAttribute("user", user);}
            if(ok){
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String sentenciaSQL = "INSERT INTO demodb.USERS (nickname,password,name,lastName,email) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sentenciaSQL);
                    ps.setString(1, request.getParameter("nickname"));
                    ps.setString(2, request.getParameter("pass"));
                    ps.setString(3, request.getParameter("name"));
                    ps.setString(4, request.getParameter("lastName"));
                    ps.setString(5, request.getParameter("email"));
            ps.executeUpdate();}
            
            
            // 2. produce the view with the web result
            ServletContext context = request.getSession().getServletContext();
            if(ok){
            context.getRequestDispatcher("/signupOK.jsp").forward(request, response);
            }
            if(notOK!=0){
                context.getRequestDispatcher("/signup.jsp?ok=false&notOK="+notOK+
                        "&nickname="+request.getParameter("nickname")+"&name="
                        +request.getParameter("name")+
                        "&lastName="+request.getParameter("lastName")+
                        "&email="+request.getParameter("email")).forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignUpCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
