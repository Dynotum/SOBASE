<%@page import="cat.urv.deim.sob.Tour"%>
<%@page import="cat.urv.deim.dataccob.TourDAO"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="layout.css" type="text/css">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            int id_oferta = Integer.parseInt(request.getParameter("id_oferta"));
            TourDAO d_offer= new TourDAO();
            Tour oferta = d_offer.getOferta(id_oferta);
            int placesRes=0;
            if(null!=request.getParameter("placesReserva")&&!("").equals(request.getParameter("placesReserva"))){
            placesRes=Integer.parseInt(request.getParameter("placesReserva"));}
        %>
        <title>Site Reservation</title>
    </head>
    
    <div class="wrapper row1">
  <header id="header" class="clear">
    <div id="hgroup">
        <h1><a href="index.jsp">Site Reservation</a></h1>
      <h2>The best site for your reservations</h2>
    </div>
    <nav>
      <ul>
                  
        <%if(userLogin!=null){%>
            <li><a href="controller.do?form_action=infoaccount">WELCOME <%=userLogin%></a></li> <li><a href="controller.do?form_action=logout">SIGN OUT</a></li>
        <%}else{%>
            <li><a href="login.jsp?idOferta=<%=oferta.getIDTour()%>">LOG IN</a></li> <li><a href="signup.jsp">SIGN UP</a></li>
        <%}%>  
 
      </ul>
    </nav>
  </header>
</div>                                        
                    
        <br>
            <table class="totample">
                <tr>
                    <td class="borde_gris"><img src="images/demo/<%=oferta.getDestinationName()%>.gif" width="630x" height="300px"></td>
                    <td class="borde_gris"><font class="text_arial_blanc">
                    <h2><%=oferta.getTitle()%></h2><br><br>
                    <b>DESCRIPTION: </b><br><%=oferta.getShortDescription()%><br>
                    <br><%=oferta.getLongDescription()%><br>
                    <br><b>DATES: </b> 1st to 7th <%=oferta.getMounth()%><br>
                    <br><b>AVAILABLE SPACES: </b><%=oferta.getAvailablePlaces() %><br>
                    <br><b>PRICE: &euro; </b><%=oferta.getPrice() %>  <br>
                   

                    <form name="updateAccount" action="controller.do" method="get">
                        <table id="taula_login">
                            <tr>
                                <td class="text_esquerra"><br><b>NUMBER OF SPACES </b></td>
                                <td class="content_dreta"><br>
                                    <%if(placesRes!=0){%>
                                    <input type="text" size="3" name="placesReserva" value=<%=placesRes%> autofocus/>
                                    <%}else{%>
                                    <input type="text" size="3" name="placesReserva" autofocus/>
                                    <%}%>
                                </td>
                            </tr>
                            <tr>
                                <%if(userLogin!=null){%>
                            <input type="hidden" name="form_action" value="reservar"/>
                                <%session.setAttribute("preuPers", oferta.getPrice());%>
                                <%session.setAttribute("placesDisp", oferta.getAvailablePlaces());%>
                                <%session.setAttribute("idOferta", oferta.getIDTour());%>
                                <%String j="1"; session.setAttribute("first", j);%>
                                <%}else{%>
                                <input type="hidden" name="form_action" value="offertologin"/>
                                <input type="hidden" name="idOferta" value="<%=oferta.getIDTour() %>"/>
                                <input type="hidden" name="first" value="1"/>
                                <%}%>
                                <%if(userLogin!=null){%>
                                <td class="contingut_centre"><input class="text_arial" id="buttonEnter" type="Submit" value="Reservar"></td>         
                                <%}else{%>
                                <td class="contingut_centre"><input class="text_arial" id="buttonEnter" type="Submit" value="Reservar"></td> <!-- Without login -->         
                                <%}%>
                            </tr>
                            <tr><td colspan="2">
                                    <font class="error">
                                        
                                    <%
                                        if(null!=request.getParameter("error")&&("true").equals(request.getParameter("error"))){
                                        out.println("<br><b>ERROR. THERE'S NOT ENOUGH SPACES</b>");}
                            %>
                                    </font></td></tr>
                        </table>
                    </form></font></td>
                </tr>
            </table>
    </body>
</html>
