<%-- 
    Document   : cerrar
    Created on : 1/06/2021, 08:01:16 PM
    Author     : Kinjiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            RequestDispatcher rd = null;
            HttpSession sesion = request.getSession();
            sesion.invalidate();
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        %>
    </body>
</html>
