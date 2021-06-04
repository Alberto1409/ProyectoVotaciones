<%-- 
    Document   : Registro
    Created on : 1/06/2021, 05:31:01 PM
    Author     : Kinjiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Registrar Usuarios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action = "http://localhost:8080/Votaciones2021/Registro" method="post">
            <center>
                <h1>Formulario de Registro</h1>
                <table BORDER ="1">

                    <tr>
                        <td>Usuario*</td><td><input type="text" name="usuario"><br></td>
                    </tr>
                    <tr>
                        <td>Nombre*</td><td><input type="text" name="nombre"><br></td>
                    </tr>
                    <tr>
                        <td>Correo*</td><td><input type="text" name="correo"><br></td>
                    </tr>
                    <tr>
                        <td>Contraseña*</td><td><input type="password" name="contra"><br></td>
                    </tr>
                    <tr>
                        <td>Domicilio<br></td>
                    </tr>
                    <tr>
                        <td>Municipio*</td><td><input type="text" name="municipio"><br></td>
                    </tr>
                    <tr>
                        <td>Codigo Postal*</td><td><input type="text" name="cp"><br></td>
                    </tr>
                    <tr>
                        <td>Colonia*</td><td><input type="text" name="colonia"><br></td>
                    </tr>
                    <tr>
                        <td>Calle*</td><td><input type="text" name="calle"><br></td>
                    </tr>
                    <tr>
                        <td>Numero Casa*</td><td><input type="text" name="casa"><br></td>
                    </tr>
                    <tr>
                        <td>Telefono*</td><td><input type="text" name="telefono"><br></td>
                    </tr>
                    <tr>
                        <td>RedSocial</td><td><input type="text" name="redsocial"><br></td>
                    </tr>

                </table>
                <input class="btn btn-primary" type="submit" value="Registarse">
                <a class="btn btn-primary" href="index.jsp" role="button">Regresar</a><br>
                <%
                    if (request.getAttribute("registro") != null) {

                %>
                <table>
                    <tr>
                        <td>
                            <div class="alert alert-success" role="alert">
                                ${registro}
                            </div>
                        </td>

                    </tr>
                </table>
                <%
                    }
                %>
                <%
                    if (request.getAttribute("falloR") != null) {
                %>
                <table>
                    <tr>
                        <td>
                            <div class="alert alert-danger" role="alert">
                                ${falloR}
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
