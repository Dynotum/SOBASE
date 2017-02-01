<%@page import="java.util.ArrayList"%>
<%@page import="cat.urv.deim.sob.*"%>
<%@page import="cat.urv.deim.dataccob.*"%>

<!DOCTYPE html>
<html>
<head>
     <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            TourDAO listaOfertes = new TourDAO();
            
            Tour destination;
                ArrayList<Tour> listaTours = listaOfertes.getTours();
            destination=listaTours.get(0);
        %>
        
<title>Site Reservation</title>
<link rel="stylesheet" href="layout.css" type="text/css">
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
                  
    <%if(userLogin!=null){%>
        <li><a href="controller.do?form_action=infoaccount">WELCOME <%=userLogin%></a></li> <li><a href="controller.do?form_action=logout">SIGN OUT</a></li>
    <%}else{%>
        <li><a href="login.jsp">LOG IN</a></li> <li><a href="signup.jsp">SIGN UP</a></li>
    <%}%>  
 
      </ul>
    </nav>
  </header>
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container" class="clear">
      
    <!-- Slider -->
    <section id="slider" class="clear">
      <figure>
         <%if(destination.getAvailablePlaces()!=0){%>
                <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                    <img src="images/demo/mexico.gif" width="215" height="100" alt="">
                </a>
         <%}else{%>
                <img src="images/demo/mexico.gif"width="215" height="100" alt="">
         <%}%>
      
        <figcaption>
          <h2><%=destination.getTitle()%></h2>
          <p><%=destination.getShortDescription() %></p>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}
            destination=listaTours.get(1);%>
            
        </figcaption>
      </figure>
    </section>
    
    
    <!-- main content -->
    <div id="homepage">
      <!-- services area -->
      <section id="services" class="clear">
        <!-- article 1 -->
        <article class="one_third">
          <h2><%=destination.getTitle()%></h2>
         <%if(destination.getAvailablePlaces()!=0){%>
                <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                    <img src="images/demo/athens.gif" width="215" height="100" alt="">
                </a>
         <%}else{%>
                <img src="images/demo/athens.gif"width="215" height="100" alt="">
         <%}%>
          
          <p><%=destination.getShortDescription() %></p><br>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p><br>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}
            destination=listaTours.get(2);%>
         </article>
        <!-- article 2 -->
        <article class="one_third">
          <h2><%=destination.getTitle()%></h2>
                   <%if(destination.getAvailablePlaces()!=0){%>
                <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                    <img src="images/demo/london.gif" width="215" height="100" alt="">
                </a>
         <%}else{%>
                <img src="images/demo/london.gif"width="215" height="100" alt="">
         <%}%>
          <p><%=destination.getShortDescription() %></p><br>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p><br>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}
            destination=listaTours.get(3);%>
        </article>
        <!-- article 3 -->
        <article class="one_third lastbox">
          <h2><%=destination.getTitle()%></h2>
         <%if(destination.getAvailablePlaces()!=0){%>
                <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                    <img src="images/demo/rome.gif" width="215" height="100" alt="">
                </a>
         <%}else{%>
                <img src="images/demo/rome.gif"width="215" height="100" alt="">
         <%}%>          <p><%=destination.getShortDescription() %></p><br>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p><br>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}
            destination=listaTours.get(4);%>
        </article>
      </section>
      <!-- / services area -->
      <!-- ########################################################################################## -->
      <!-- ########################################################################################## -->
      <!-- ########################################################################################## -->
      <!-- ########################################################################################## -->
      <!-- One Quarter -->
      <section id="latest" class="last clear">
        <article class="one_quarter">
         <%if(destination.getAvailablePlaces()!=0){%>
                <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                    <img src="images/demo/amsterdam.gif" width="215" height="100" alt="">
                </a>
         <%}else{%>
                <img src="images/demo/amsterdam.gif"width="215" height="100" alt="">
         <%}%>            <figcaption>          
          <h2><%=destination.getTitle()%></h2>
          <p><%=destination.getShortDescription() %></p><br>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p><br>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}
            destination=listaTours.get(5);%>
            </figcaption>
          </figure>
        </article>
        <article class="one_quarter">
         <%if(destination.getAvailablePlaces()!=0){%>
                <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                    <img src="images/demo/brussels.gif" width="215" height="100" alt="">
                </a>
         <%}else{%>
                <img src="images/demo/brussels.gif"width="215" height="100" alt="">
         <%}%>            <figcaption>
          <h2><%=destination.getTitle()%></h2>
          <p><%=destination.getShortDescription() %></p><br>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p><br>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}
            destination=listaTours.get(6);%>         
            </figcaption>
          </figure>
        </article>
        <article class="one_quarter">
          <figure>
               <%if(destination.getAvailablePlaces()!=0){%>
                        <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                            <img src="images/demo/lisbon.gif" width="215" height="100" alt="">
                        </a>
                        <%}else{%>
                        <img src="images/demo/lisbon.gif" width="215" height="100" alt="">
                        <%}%>
            <figcaption>
          <h2><%=destination.getTitle()%></h2>
          <p><%=destination.getShortDescription() %></p><br>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p><br>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}
            destination=listaTours.get(7);%>
            </figcaption>
          </figure>
        </article>
        <article class="one_quarter lastbox">
         <%if(destination.getAvailablePlaces()!=0){%>
                <a  href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>">
                    <img src="images/demo/prague.gif" width="215" height="100" alt="">
                </a>
         <%}else{%>
                <img src="images/demo/prague.gif"width="215" height="100" alt="">
         <%}%>            <figcaption>
          <h2><%=destination.getTitle()%></h2>
          <p><%=destination.getShortDescription() %></p><br>
          <p>1st to 7th <%=destination.getMounth() %> <br/><b>Places Available: <%=destination.getAvailablePlaces() %></b></p><br>
          <p><b><%=destination.getPrice()  %> &euro; per person</b></p>
        <%if(destination.getAvailablePlaces()!=0){%>
                        <footer class="more"><a href="oferta.jsp?id_oferta=<%=destination.getIDTour()%>"> RESERVE &raquo;</a></footer>
                        <%}else{%>
                        <p>SOLD OUT</p>
                        <%}%>
            </figcaption>
          </figure>
        </article>
      </section>
      <!-- / One Quarter -->
    </div>
    <!-- / content body -->
  </div>
</div>
<!-- Footer -->
<div class="wrapper row3">
  <footer id="footer" class="clear">
    <p class="fl_left">Copyright &copy; 2012 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
  </footer>
</div>
</body>
</html>
