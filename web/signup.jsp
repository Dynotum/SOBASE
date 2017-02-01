<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up</title>
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
                        <%@ page session="true" %>
                        <%
                            String userLogin = (String) session.getAttribute("aliasLogin");
                        %>        
                        <%if (userLogin != null) {%>      
                        <li><a href="controller.do?form_action=infoaccount"><b>WELCOME <%=userLogin%></a></li>
                        <li><a href="controller.do?form_action=logout"><b>LOG OUT</a></li>
                            <%} else {%>
                        <li><a href="login.jsp"><b>LOG IN</a></li>
                        <li><a href="signup.jsp"><b>SIGN UP</a></li>
                            <%}%>
                    </ul>
                </nav>
            </header>
        </div>

        <div class="container">

            <form action="controller.do" method="POST" > 
                <input type="hidden" name="form_action" value="signup" accept-charset="UTF-8"/>

                <fieldset>

                    <!-- Form Name -->
                    <br><h1 align="center">SIGN UP</h1><br>
                    <br><h2 align="center">CREATE A NEW USER</h2><br>

        
                    <table border="2px" color="black" align="center" valign="top">
                        <div class="form-group">
                            <tr>    
                                <td>
                                    <p align="left"><label class="col-md-4 control-label" >Nickname: </label></p>
                                </td>

                                <td>
                                    <%if (request.getParameter("nickname") != null) {%>
                                        <p><input align="left" name="nickname" value="<%=request.getParameter("nickname")%>" placeholder="i.e. Juan198" class="form-control" type="text"></p>
                                    <%} else {%>
                                        <input align="left" type="text" name="nickname" placeholder="i.e. Juan198"/>
                                    <%}%>
                                </td>
                            </tr>
                        </div> 
                                

                    <div class="form-group">
                            <tr>    
                                <td>
                                    <p align="left"><label class="col-md-4 control-label">Password: </label> </p>
                                </td>                        
                                <td>
                                    <p><input name="pass" placeholder="******" class="form-control" type="text"></p>
                                </td>
                            </tr>
                    </div>

                    <!-- Text input-->

                    <div class="form-group">
                            <tr>
                                <td>
                                    <p align="left"><label class="col-md-4 control-label">Name: </label></p> 
                                </td>  
                                <td>
                                    <%if (request.getParameter("name") != null) {%>
                                        <p><input align="left" name="name" value="<%=request.getParameter("name")%>" placeholder="First Name" class="form-control" type="text"></p>
                                    <%} else {%> 
                                        <p><input  name="name" placeholder="First Name" class="form-control"  type="text"></p>
                                    <%}%>
                                </td>
                        </tr>
                    </div>


                    <!-- Text input-->

                    <div class="form-group">
                        <tr>
                            <td>
                                <p align="left"><label class="col-md-4 control-label" >Last Name: </label> </p>

                            </td>
                            <td>
                                <%if (request.getParameter("lastName") != null) {%>
                                    <p><input align="left" name="lastName" value="<%=request.getParameter("lastName")%>" placeholder="Last Name" class="form-control" type="text"></p>
                                <%} else {%>
                                    <p><input name="lastName" placeholder="Last Name" class="form-control"  type="text"></p>
                                <%}%>                               
                            </td>
                        </tr>
                    </div>


                    <!-- Text input-->
                    <div class="form-group">
                        <tr>
                            <td>
                                <p align="left"><label class="col-md-4 control-label">E-Mail:</label>  </p>                              
                            </td>
                            <td>
                                <%if (request.getParameter("email") != null) {%>
                                    <p><input align="left" name="email" value="<%=request.getParameter("email")%>" placeholder="E-Mail Address" class="form-control" type="text"></p>
                                <%} else {%>
                                    <p><input name="email" placeholder="E-Mail Address" class="form-control"  type="text"></p>
                                <%}%>                                
                            </td>
                        </tr>
                    </div>
                </table>  

                    <!-- Select Basic -->


                    <%
                        if ((request.getParameter("ok") != null) && request.getParameter("ok").equals("false")) {
                            out.println("SOMETHING BAD HAPPENED! FULL ALL THE TEXTBOX");
                        }
                        if ((request.getParameter("notOK") != null) && request.getParameter("notOK").equals("1")) {
                            out.println("<br>USER FIELD. 2-20 charecters");
                        }
                        if ((request.getParameter("notOK") != null) && request.getParameter("notOK").equals("2")) {
                            out.println("<br>PASSWORD FIELD. 2-20 charecters");
                        }
                        if ((request.getParameter("notOK") != null) && request.getParameter("notOK").equals("3")) {
                            out.println("<br>NAME FIELD.  max 20 charecters");
                        }
                        if ((request.getParameter("notOK") != null) && request.getParameter("notOK").equals("4")) {
                            out.println("<br>LAST NAME FIELD. max 20 charecters");
                        }
                        if ((request.getParameter("notOK") != null) && request.getParameter("notOK").equals("4")) {
                            out.println("<br>EMAIL FIELD. max 25 charecters");
                        }

                    %>
                    <!-- Button -->
                    <div class="form-group" aling="center">
                        <center>
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4">
                            <br><input class="text_arial" id="buttonEnter" type="Submit" value="Enviar" align="center"><!-- <button type="submit" button class="btn btn-warning" >Submit <span class="glyphicon glyphicon-send"></span></button>-->
                            <p><a href="login.jsp" align="center">LOG IN</a></p>
                        </div>
                    </div>
                    </center>
                </fieldset>
            </form>
        </div>
    </div>
</body>

