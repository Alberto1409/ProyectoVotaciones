package votaciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Kinjiro
 */
@WebServlet(urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String LLAVE = "Nose que estoy haciendo";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\n");
            out.println("<title>Servlet Registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        RequestDispatcher rd = null;
        request.setAttribute("falloR", null);
        request.setAttribute("registro", null);

        //controlador conexion----------------------------------------
        conexion con = new conexion();
        Statement stmt = null;

        Contra contrasena1 = new Contra();
        String usuario2 = null, nomb = null, correo = null, contra = null, contraE = null, municipio = null, codigopostal = null, colonia = null, calle = null, numero = null, telefono = null, redsocial = null;

        usuario2 = request.getParameter("usuario");
        nomb = request.getParameter("nombre");
        correo = request.getParameter("correo");
        contra = request.getParameter("contra");
        contraE = contrasena1.getEncriptar(contra);
        municipio = request.getParameter("municipio");
        codigopostal = request.getParameter("cp");
        colonia = request.getParameter("colonia");
        calle = request.getParameter("calle");
        numero = request.getParameter("casa");
        telefono = request.getParameter("telefono");
        redsocial = request.getParameter("redsocial");

        if (usuario2.equals("") || nomb.equals("") || correo.equals("") || contra.equals("") || municipio.equals("")
                || codigopostal.equals("") || colonia.equals("") || calle.equals("") || numero.equals("")
                || telefono.equals("")) {
            request.setAttribute("falloR", "Por favor Ingresa los Datos con *");
            rd = request.getRequestDispatcher("Registro.jsp");
            rd.forward(request, response);
        } else {
            try {
                //controlador conexion-------------------------------------

                //statement hace el proceso de sql
                //se le asigna la coneccion que tengo
                stmt = con.conexion(request, response).createStatement();
                //ejecutar un update, (execute.Query para borrar)
                stmt.executeUpdate("INSERT INTO usuarios (Usuario,Nombre,Correo,"
                        + "Contraseña,Municipio,CodigoPostal,Colonia,Calle,"
                        + "Numero,Telefono,Redsocial) "
                        + "VALUES ('" + usuario2 + "'"
                        + ",'" + nomb + "','" + correo + "','" + contraE + "','" + municipio + "'"
                        + ",'" + codigopostal + "','" + colonia + "','" + calle + "'"
                        + ",'" + numero + "','" + telefono + "','" + redsocial + "')");
                request.setAttribute("registro", "Registro Exitoso");
                rd = request.getRequestDispatcher("Registro.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("falloR", "Registro fallido");
                rd = request.getRequestDispatcher("Registro.jsp");
                rd.forward(request, response);
            }
            try {
            } finally {
                if (con != null) {
                    try {
                        con.cerrar();
                        stmt.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
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
