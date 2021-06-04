<%-- 
    Document   : index
    Created on : 31/05/2021, 09:08:19 PM
    Author     : Kinjiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>
        <form action = "http://localhost:8080/Votaciones2021/Ingresar" method="post">
            <center>
                <h1>Vota por un Mexico Mejor</h1>
                <table BORDER ="1">
                    <tr>
                        <td>Usuario: </td><td><input type="text" name="us"><br></td>
                    </tr>
                    <tr>
                        <td>Contraseña: </td><td><input type="password" name="contra"><br></td>
                    </tr>
                </table>
                <input class="btn btn-primary" type="submit" value="Ingresar">
                <a class="btn btn-primary" href="Registro.jsp" role="button">Registrarse</a>
                <%
                    HttpSession sesion = request.getSession();
                    if (sesion.getAttribute("fallo") != null) {
                %>
                <table>
                    <tr>
                        <td>
                            <div class="alert alert-danger" role="alert">
                                <%=sesion.getAttribute("fallo")%>
                            </div>
                        </td>

                    </tr>
                </table>
                <%
                      }
                %>
                <%
                    if (sesion.getAttribute("proceso") != null) {

                %>
                <table>
                    <tr>
                        <td>
                            <div class="alert alert-dark" role="alert">
                                <%=sesion.getAttribute("proceso")%>
                            </div>
                        </td>

                    </tr>
                </table>
                <%
                      }
                %>


            </center>
        </form>
    </body>
</html>
