<%@page import="cat.urv.deim.sob.Reservation"%>
<%@page import="cat.urv.deim.sob.Tour"%>
<%@page import="cat.urv.deim.dataccob.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="layout.css" type="text/css">
        
        <title>Site</title>
    </head>
    <body>
        <div class="wrapper row1">
  <header id="header" class="clear">
    <div id="hgroup">
        <h1><a href="index.jsp">Site Reservation</a></h1>
      <h2>The best site for your reservations</h2>
    </div>
    <nav>
      <ul>
<%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            User usuari;
            usuari = (User) session.getAttribute("dadesUsuari");
            ArrayList<Reservation> listReservations = (ArrayList<Reservation>) session.getAttribute("dadesComandes");
            Reservation reservation = null;
           
 
%>
    <%if(userLogin!=null){%>
        <li><a href="controller.do?form_action=infoaccount">WELCOME <%=userLogin%></a></li> <li><a href="controller.do?form_action=logout">SIGN OUT</a></li>
    <%}else{%>
        <li><a href="login.jsp">LOG IN</a></li> <li><a href="signup.jsp">SIGN UP</a></li>
    <%}%> 
      </ul>
    </nav>
  </header>
</div>    
    <table>
        <tr>
            <br>
            <%=usuari.getInfoaccount()%>
        </tr>
    </table>

    <br>
    <table border="2px" color="black" align="center">
        <caption><br><br><h1>RESERVATIONS:</h1><br></caption>
        <tr>
            <th scope="col">TOUR</th>
            <th ascope="col">SUMMARY</th>
        </tr>
        
       <%for(int j=0; j<listReservations.size();j++){%>
       <%reservation=listReservations.get(j);%>
       <tr>
            <td>
                <img src="images/demo/<%=reservation.getNameTour(reservation.getTotal_price())%>.gif" width="300" height="200">
            </td>
            <td>
                <%=reservation.getComandaInfo()%><br><b>DATE:  1st to 7th <%=reservation.getMounth(reservation.getTotal_price())%></b><br><%}%>
                <
            </td>   
        </tr>
    </table>
            
    </body>
</html>