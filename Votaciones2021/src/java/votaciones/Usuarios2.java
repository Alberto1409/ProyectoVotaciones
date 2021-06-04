package votaciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/Usuarios2"})
public class Usuarios2 extends HttpServlet {
    private String Respuesta = null;
    private String RespuestaE = null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Usuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Usuarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public String getRespuesta(){
        return Respuesta;
    }
    public void setRespuesta(String respuesta){
        Respuesta = respuesta;
    }public String getRespuestaE(){
        return RespuestaE;
    }
    public void setRespuestaE(String respuesta){
        RespuestaE = respuesta;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        PrintWriter out = response.getWriter();

        conexion con = new conexion();
        Statement stmt = null;

        //diplocal
        String idusuarios, usuario, nombre, correo, municipio, cp, colonia, calle, numero, telefono, redsocial, estado;
        ResultSet rs = null;
        
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("login") == null) {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        try {
            stmt = con.conexion(request, response).createStatement();
            rs = stmt.executeQuery("Select * From Usuarios");
            out.print("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">");
            out.print("<form action = \"http://localhost:8080/Votaciones2021/Usuarios2\" method=\"post\">");
            out.print("<center>");

            out.print("<br><h1>" + "Usuarios" + "</h1>");
            out.print("<br><br><table class='table table-sm table-striped table-dark'");
            out.print("<tr>");
            out.print("<th>" + "Id Usuario" + "</th>");
            out.print("<th>" + "Usuario" + "</th>");
            out.print("<th>" + "Nombre" + "</th>");
            out.print("<th>" + "Correo" + "</th>");
            out.print("<th>" + "Municipio" + "</th>");
            out.print("<th>" + "Codigo postal" + "</th>");
            out.print("<th>" + "Colonia" + "</th>");
            out.print("<th>" + "Calle" + "</th>");
            out.print("<th>" + "Numero" + "</th>");
            out.print("<th>" + "Telefono" + "</th>");
            out.print("<th>" + "Red social" + "</th>");
            out.print("<th>" + "Estado" + "</th>");

            out.print("</tr>");

            while (rs.next()) {
                idusuarios = rs.getString(1);
                usuario = rs.getString(2);
                nombre = rs.getString(3);
                correo = rs.getString(4);
                municipio = rs.getString(6);
                cp = rs.getString(7);
                colonia = rs.getString(8);
                calle = rs.getString(9);
                numero = rs.getString(10);
                telefono = rs.getString(11);
                redsocial = rs.getString(12);
                estado = rs.getString(13);

                out.print("<tr>");

                out.print("<td>");
                out.print("" + idusuarios);
                out.print("</td>");

                out.print("<td>");
                out.print("" + usuario);
                out.print("</td>");

                out.print("<td>");
                out.print("" + nombre);
                out.print("</td>");

                out.print("<td>");
                out.print("" + correo);
                out.print("</td>");

                out.print("<td>");
                out.print("" + municipio);
                out.print("</td>");

                out.print("<td>");
                out.print("" + cp);
                out.print("</td>");

                out.print("<td>");
                out.print("" + colonia);
                out.print("</td>");

                out.print("<td>");
                out.print("" + calle);
                out.print("</td>");

                out.print("<td>");
                out.print("" + numero);
                out.print("</td>");

                out.print("<td>");
                out.print("" + telefono);
                out.print("</td>");

                out.print("<td>");
                out.print("" + redsocial);
                out.print("</td>");

                out.print("<td>");
                out.print("" + estado);
                out.print("</td>");

                out.print("</tr>");
            }
            out.print("</table>");

            out.print("<br> <td>Id de usuario<br> </td><td><input type=\"text\" name=\"id1\"><br></td>");
            out.print("<br> <input class=\"btn btn-primary\" type=\"submit\" value=\"Inhabilitar\">");
            out.print("  <a class='btn btn-primary' href = 'menu.jsp' role = 'button' > Regresar </a>");
            if (getRespuesta() != null) {
                //out.print("");
                out.print("<table>");
                out.print("<tr><td><div class=\"alert alert-success\" role=\"alert\">");
                out.print(getRespuesta());
                out.print("</div></td></tr>");
                out.print("</table>");
            }
            if (getRespuestaE() != null) {
                //out.print("");
                out.print("<table>");
                out.print("<tr><td><div class=\"alert alert-danger\" role=\"alert\">");
                out.print(getRespuestaE());
                out.print("</div></td></tr>");
                out.print("</table>");
            }
            out.print("</form>");
            out.print("</center>");

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        conexion con = new conexion();
        Statement stmt = null;

        int ida = Integer.parseInt(request.getParameter("id1"));

        try {

            stmt = con.conexion(request, response).createStatement();
            stmt.executeUpdate("UPDATE Usuarios set Estado= 2 where idUsuarios = " + ida);
            setRespuesta("Usuario Inhabilitado correctamente");
            
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            setRespuestaE("Error al Inhabilitar Usuario");
        }
        response.sendRedirect("Usuarios2");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
