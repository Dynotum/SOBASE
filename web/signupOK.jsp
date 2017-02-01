
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="layout.css" type="text/css">
        <%@ page session="true" %>
        <%
            String userLogin = (String) session.getAttribute("aliasLogin");
        %>
        <title></title>
    </head>
    <body>
        <div id="menu_inicial">
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
        </div><div>
            <table align="center">
                <tr>
                    <td>
                        <h1>USER REGISTRATION HAS BEEN SUCCESSFUL</h1><br>
                        <img src="images/demo/success.gif" width="500" height="300" alt="" align="center"><br><br>
                        <h3>Please <a href="login.jsp">SIGN IN</a> to start making Reservations</h3>
                    </td>
                </tr>
            </table>
            
        </div>
        <br>
        <br>
    </body>
</html>
