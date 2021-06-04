<%-- 
    Document   : menu
    Created on : 31/05/2021, 08:46:09 PM
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
        <%
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("login") == null) {
                RequestDispatcher rd = null;
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        %>
        <form>
            <table>
                <tr>
                    <td>
                        <div class="alert alert-secondary" role="alert">
                            <%=sesion.getAttribute("usuario")%>
                        </div>
                    </td>
                </tr>
            </table>
            <center>
                <h1>Vota por un Mexico Mejor</h1>
                <h2>Menu de Votaciones</h2>
                <table BORDER ="1">

                </table>
                <a class="btn btn-primary" href="premunicipal.jsp" role="button">Presidente Municipal</a>
                <a class="btn btn-primary" href="dipfederal.jsp" role="button">Diputado Federal</a>
                <a class="btn btn-primary" href="diplocal.jsp" role="button">Diputado Local</a>
                <a class="btn btn-primary" href="cerrar.jsp" role="button">Cerrar Sesion</a>
                <%
                    if (sesion.getAttribute("estadoU").equals("Uno")) {
                %>
                <a class="btn btn-primary" href="Formularios" role="button">Resultados Votaciones</a>
                <a class="btn btn-primary" href="Usuarios" role="button">Habilitar usuarios</a>
                <a class="btn btn-primary" href="Usuarios2" role="button">Inhabilitar usuarios</a>
                <%
                    }
                %>
            </center>
        </form>
    </body>
</html>
