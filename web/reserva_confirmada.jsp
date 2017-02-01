
<%@page import="cat.urv.deim.dataccob.TourDAO"%>
<jsp:useBean id="user" class="cat.urv.deim.sob.User" scope="session" />
<%@page import="cat.urv.deim.sob.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="layout.css" type="text/css">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            Reservation comanda = (Reservation) session.getAttribute("comanda");
        %>

        <title></title>
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

                        <%if (userLogin != null) {%>
                        <li><a href="controller.do?form_action=infoaccount">WELCOME <%=userLogin%></a></li> <li><a href="controller.do?form_action=logout">SIGN OUT</a></li>
                            <%} else {%>
                        <li><a href="login.jsp">LOG IN</a></li> <li><a href="signup.jsp">SIGN UP</a></li>
                            <%}%> 
                    </ul>
                </nav>
            </header>
        </div>    
        <br>
        <br>
        <table align="center">
            <tr>
                <td class="borde_gris"><font class="text_arial_blanc">
                    <h1 align="center">CONGRATULATIONS <%=userLogin%>!</h2></br>
                        <h2 align="center">NOW YOU HAVE A NEW RESERVATION!</h2>                    
                        </font>
                </td>
            </tr>
        </table>


        <table border="2px" color="black" align="center" valign="top">
            <caption><br><br><h1>RESERVATION</h1><br></caption>
            <tr>
                <th scope="col">TOUR</th>
                <th ascope="col">SUMMARY</th>
            </tr>

            <tr>
                <td>
                    <img src="images/demo/<%=comanda.getNameTour(comanda.getOffer_id())%>.gif" width="600" height="400">
                </td>

                <td valign="top">
                    <br><%=comanda.getComandaReserva()%>
                    <br><b>DATE: </b> 1st to 7th <%=comanda.getMounth(comanda.getOffer_id())%><br>
                </td>   
            </tr>
        </table>                     
        <%session.setAttribute("first", "0");%>
    </body>
</html>