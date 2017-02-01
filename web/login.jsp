<!DOCTYPE html>
<html lang="en"> <!--<![endif]-->
<head>
  <title>Login</title>
<link rel="stylesheet" href="layout.css" type="text/css">
        <%@ page session="true" %>
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
          <%
            String userLogin = (String) session.getAttribute("aliasLogin");
            int idOferta2=0;
            if(null!=request.getParameter("idOferta")&&!("").equals(request.getParameter("idOferta"))){
            idOferta2=Integer.parseInt(request.getParameter("idOferta"));}
            int placesRes2=0;
            if(null!=request.getParameter("placesReserva")&&!("").equals(request.getParameter("placesReserva"))){
            placesRes2=Integer.parseInt(request.getParameter("placesReserva"));}
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
    
  <section class="container">
    <div class="login">
        <p></p>
      <h1 align="center">LOG IN</h1>
      <form method="GET" action="controller.do"> <!-- get para pruebas de envio -->
          
           <%if(!("").equals(request.getParameter("idOferta"))&& idOferta2!=0){%>
        <input type="hidden" name="idOferta3" value="<%=idOferta2%>"/>
        <input type="hidden" name="placesRes3" value="<%=placesRes2%>"/>
        <input type="hidden" name="form_action" value="logintooffer"/>
        <%}else{%>
        <input type="hidden" name="form_action" value="login"/>
        <%}%>
        
        <p align="center"><input type="text" name="nickname" value="" placeholder="Nickname"></p>
        <p align="center"><input type="password" name="pass" value="" placeholder="Password"></p>
 
        
       <p align="center"><b>
                        <%
                            if((request.getParameter("dadesErronees")!=null) && request.getParameter("dadesErronees").equals("true")){
                                 out.println("INCORRECT INFORMATION");
                        }
                        %>
         </b></p>
                   
                    
        <p align="center"class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
    </div>

  </section>


</body>
</html>