<%-- 
    Document   : premunicipal
    Created on : 1/06/2021, 08:14:31 PM
    Author     : Kinjiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Presidente Municipal</title>
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
        <form action = "http://localhost:8080/Votaciones2021/Premunicipal" method="post">
            <center>
            <h1>PRESIDENTE MUNICIPAL</h1>
            <table BORDER ="1">
                
            <tr>
                <td>PAN</td><td><input type="text" name="pan" value="0"><br></td>
            </tr>
            <tr>
                <td>PRD</td><td><input type="text" name="prd" value="0"><br></td>
            </tr>
            <tr>
                <td>PRI</td><td><input type="text" name="pri" value="0"><br></td>
            </tr>
            <tr>
                <td>VERDE ECOLOGISTA</td><td><input type="text" name="verdeeco" value="0"><br></td>
            </tr>
            <tr>
                <td>PT</td><td><input type="text" name="pt" value="0"><br></td>
            </tr>
            <tr>
                <td>MOVIMIENTO CIUDADANO</td><td><input type="text" name="movciudadano" value="0"><br></td>
            </tr>
            <tr>
                <td>MORENA</td><td><input type="text" name="morena" value="0"><br></td>
            </tr>
            <tr>
                <td>PES</td><td><input type="text" name="pes" value="0"><br></td>
            </tr>
            <tr>
                <td>RSP</td><td><input type="text" name="rsp" value="0"><br></td>
            </tr>
            <tr>
                <td>FUERZA MÉXICO</td><td><input type="text" name="fuerzamex" value="0"><br></td>
            </tr>
            <tr>
                <td>HAGAMOS</td><td><input type="text" name="hagamos" value="0"><br></td>
            </tr>
            <tr>
                <td>SOMOS</td><td><input type="text" name="somos" value="0"><br></td>
            </tr>
            <tr>
                <td>FUTURO</td><td><input type="text" name="futuro" value="0"><br></td>
            </tr>
            <tr>
                <td>INDEPENDIENTES:<br></td>
            </tr>
            <tr>
                <td>JOSE LUIS FLORES</td><td><input type="text" name="indep1" value="0"><br></td>
            </tr>
            <tr>
                <td>MARIA ISABEL NOLASCO</td><td><input type="text" name="indep2" value="0"><br></td>
            </tr>
            <tr>
                <td>NULO</td><td><input type="text" name="nulo" value="0"><br></td>
            </tr>
             
            </table>     
             <br><input class="btn btn-primary" type="submit" value="Enviar">
             <a class="btn btn-primary" href="menu.jsp" role="button">Regresar</a>
             <%
                    if (request.getAttribute("premunicipal") != null) {

                %>
                <table>
                    <tr>
                        <td>
                            <div class="alert alert-success" role="alert">
                                ${premunicipal}
                            </div>
                        </td>

                    </tr>
                </table>
                <%                    }
                %>
                <%
                    if (request.getAttribute("premunicipalE") != null) {
                %>
                <table>
                    <tr>
                        <td>
                            <div class="alert alert-danger" role="alert">
                                ${premunicipalE}
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